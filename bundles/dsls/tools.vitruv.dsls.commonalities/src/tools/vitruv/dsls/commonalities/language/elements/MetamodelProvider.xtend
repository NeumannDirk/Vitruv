package tools.vitruv.dsls.commonalities.language.elements

import com.google.inject.Singleton
import edu.kit.ipd.sdq.activextendannotations.Lazy
import java.util.Map
import org.eclipse.emf.common.util.URI
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl
import tools.vitruv.framework.domains.VitruvDomainProviderRegistry

@Singleton
class MetamodelProvider {

	/*
	 * In order to be referenced from a Xtext language, EObjects must be
	 * contained in a resource. So we create a fake resource to put our domain
	 * adapters in. This resource is never serialized and has no other purpose.
	 */
	val static CONTAINER_RESOURCE_URI = URI.createURI('synthetic:/commonalities/metamodelAdapters')
	val container = createContainerResource

	// there is currently no way to change the domains while developing, so
	// it’s okay to cache them.
	@Lazy(PRIVATE) Map<String, Metamodel> allMetamodelsByName = loadMetamodels()

	package new() {
	}

	private def loadMetamodels() {
		return newHashMap(
			VitruvDomainProviderRegistry.allDomainProviders.map[domain].map [ domain |
			val vitruvDomain = LanguageElementsFactory.eINSTANCE.createMetamodel
				.withClassifierProvider(ClassifierProvider.INSTANCE).forEPackage(domain.metamodelRootPackage)
			container.contents += vitruvDomain
			return domain.name -> vitruvDomain
		])
	}

	private def createContainerResource() {
		val resourceSet = new ResourceSetImpl
		return resourceSet.createResource(CONTAINER_RESOURCE_URI)
	}

	def getDomainByName(String name) {
		allMetamodelsByName.get(name)
	}

	def getAllDomains() {
		allMetamodelsByName.values
	}
}
