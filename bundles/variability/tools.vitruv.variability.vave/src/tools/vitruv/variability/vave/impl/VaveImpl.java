package tools.vitruv.variability.vave.impl;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceImpl;

import tools.vitruv.framework.change.description.VitruviusChange;
import tools.vitruv.framework.change.description.impl.TransactionalChangeImpl;
import tools.vitruv.framework.change.echange.EChange;
import tools.vitruv.framework.domains.VitruvDomain;
import tools.vitruv.framework.domains.repository.VitruvDomainRepository;
import tools.vitruv.framework.domains.repository.VitruvDomainRepositoryImpl;
import tools.vitruv.framework.propagation.ChangePropagationSpecification;
import tools.vitruv.framework.propagation.ChangePropagationSpecificationRepository;
import tools.vitruv.framework.userinteraction.InternalUserInteractor;
import tools.vitruv.framework.userinteraction.UserInteractionFactory;
import tools.vitruv.framework.vsum.VirtualModelManager;
import tools.vitruv.framework.vsum.helper.VsumFileSystemLayout;
import tools.vitruv.variability.vave.Vave;
import tools.vitruv.variability.vave.VirtualModelProduct;
import vavemodel.DeltaModule;
import vavemodel.VavemodelFactory;

public class VaveImpl implements Vave {

	private VitruvDomainRepository domainRepository = null;
	private vavemodel.System system;
	private Resource resource;
	private final Set<ChangePropagationSpecification> changePropagationSpecifications = new HashSet<ChangePropagationSpecification>();

	public VaveImpl(Set<VitruvDomain> domains, Set<ChangePropagationSpecification> changePropagationSpecifications,
			Path storageFolder) throws Exception {
//		try {
//		this.resource = resSet.getResource(URI.createFileURI(storageFolder.resolve("vavemodel.vave").toString()),
//				true);
//	} catch (Exception e) {
//		this.resource = resSet.getResource(URI.createFileURI(storageFolder.resolve("vavemodel.vave").toString()),
//				false);
//	}
		if (Files.exists(storageFolder.resolve("vavemodel.vave"))) {
			// load
			this.resource = new XMIResourceImpl();
			File source = new File(storageFolder.resolve("vavemodel.vave").toString());
			this.resource.load(new FileInputStream(source), new HashMap<Object, Object>());
			this.system = vavemodel.System.class.cast(this.resource.getContents().get(0));
		} else {
			// create
			Resource.Factory.Registry reg = Resource.Factory.Registry.INSTANCE;
			Map<String, Object> m = reg.getExtensionToFactoryMap();
			m.put("vave", new XMIResourceFactoryImpl());
			ResourceSet resSet = new ResourceSetImpl();
			this.resource = resSet
					.createResource(URI.createFileURI(storageFolder.resolve("vavemodel.vave").toString()));
			this.system = VavemodelFactory.eINSTANCE.createSystem();
			this.resource.getContents().add(this.system);
			try {
				this.resource.save(Collections.EMPTY_MAP);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		this.domainRepository = new VitruvDomainRepositoryImpl(domains);

		this.changePropagationSpecifications.addAll(changePropagationSpecifications);
	}

	public void init(Path storageFolder) throws IOException {

	}

	public VirtualModelProduct externalizeProduct(Path storageFolder, String configuration) throws Exception {

//		final VirtualModelProductImpl vsum = new VirtualModelProductBuilder().withStorageFolder(storageFolder)
//				.withDomainRepository(this.domainRepository)
//				.withUserInteractor(UserInteractionFactory.instance.createUserInteractor(UserInteractionFactory.instance.createPredefinedInteractionResultProvider(null)))
//				.buildAndInitialize();

//		final Set<ChangePropagationSpecification> changePropagationSpecifications = new HashSet<ChangePropagationSpecification>();
		InternalUserInteractor userInteractor = UserInteractionFactory.instance
				.createUserInteractor(UserInteractionFactory.instance.createPredefinedInteractionResultProvider(null));

		if (storageFolder == null)
			throw new Exception("No storage folder was configured!");

		if (userInteractor == null)
			throw new Exception("No user interactor was configured!");

		final ChangePropagationSpecificationRepository changeSpecificationRepository = new ChangePropagationSpecificationRepository(
				changePropagationSpecifications);
		for (final ChangePropagationSpecification changePropagationSpecification : changePropagationSpecifications) {
			{
				boolean containsSourceDomain = false;
				boolean containsTargetDomain = false;
				for (VitruvDomain domain : this.domainRepository) {
					if (domain.equals(changePropagationSpecification.getSourceDomain())) {
						containsSourceDomain = true;
					}
					if (domain.equals(changePropagationSpecification.getTargetDomain())) {
						containsTargetDomain = true;
					}
				}
				if (!containsTargetDomain)
					throw new Exception("The change propagation specification’s source domain ‹"
							+ changePropagationSpecification.getSourceDomain() + "› has not been configured: "
							+ changePropagationSpecification);
				if (!containsSourceDomain)
					throw new Exception("The change propagation specification’s target domain ‹"
							+ changePropagationSpecification.getTargetDomain() + "› has not been configured: "
							+ changePropagationSpecification);
			}
		}

		for (final ChangePropagationSpecification changePropagationSpecification_1 : this.changePropagationSpecifications) {
			changePropagationSpecification_1.setUserInteractor(userInteractor);
		}

		final VsumFileSystemLayout fileSystemLayout = new VsumFileSystemLayout(storageFolder);
		fileSystemLayout.prepare();

		final VirtualModelProductImpl vsum = new VirtualModelProductImpl(configuration, fileSystemLayout,
				userInteractor, this.domainRepository, changeSpecificationRepository);
		vsum.loadExistingModels();
		VirtualModelManager.getInstance().putVirtualModel(vsum);

		// TODO for each delta: check if its mapping is true given configuration. if yes: propagate it in vsum.

		// One VitruviusChange per DeltaModule
		EList<DeltaModule> deltamodules = this.system.getDeltamodule();
		if (!deltamodules.isEmpty()) {

			for (DeltaModule deltamodule : deltamodules) {
//				EStructuralFeature eStructFeature = deltamodule.eClass().getEStructuralFeature("change");
//				echanges.add((EChange) deltamodule.eGet(eStructFeature));
				VitruviusChange vitruvchange = new TransactionalChangeImpl(deltamodule.getChange());
				vsum.propagateChange(vitruvchange);
			}
		}

		// return vsum instance
		return vsum;
	}

	public void internalizeChanges(VirtualModelProduct virtualModel) throws IOException { // TODO: add expression parameter and map deltas to expression
		for (VitruviusChange change : virtualModel.getDeltas()) {
			DeltaModule dm = VavemodelFactory.eINSTANCE.createDeltaModule();
			System.out.println("DELTA: " + change);
			for (EChange echange : change.getEChanges()) {
				dm.getChange().add(echange);
			}
			this.system.getDeltamodule().add(dm);
		}
		virtualModel.clearDeltas();
		this.save();
	}

	private void save() throws IOException {
		this.resource.save(Collections.EMPTY_MAP);
	}

}
