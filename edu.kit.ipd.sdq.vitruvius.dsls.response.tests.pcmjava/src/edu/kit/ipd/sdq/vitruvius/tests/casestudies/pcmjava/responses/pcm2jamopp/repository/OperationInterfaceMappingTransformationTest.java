package edu.kit.ipd.sdq.vitruvius.tests.casestudies.pcmjava.responses.pcm2jamopp.repository;

import org.emftext.language.java.classifiers.Interface;
import org.emftext.language.java.containers.CompilationUnit;
import org.junit.Test;

import org.palladiosimulator.pcm.repository.OperationInterface;
import org.palladiosimulator.pcm.repository.Repository;
import edu.kit.ipd.sdq.vitruvius.framework.contracts.datatypes.VURI;
import edu.kit.ipd.sdq.vitruvius.tests.casestudies.pcmjava.responses.pcm2jamopp.PCM2JaMoPPTransformationTest;
import edu.kit.ipd.sdq.vitruvius.tests.casestudies.pcmjava.responses.utils.PCM2JaMoPPTestUtils;

public class OperationInterfaceMappingTransformationTest extends PCM2JaMoPPTransformationTest {

    @Test
    public void testAddInterface() throws Throwable {
        final Repository repo = this.createAndSyncRepository(this.resourceSet, PCM2JaMoPPTestUtils.REPOSITORY_NAME);

        final OperationInterface opInterface = this.addInterfaceToReposiotryAndSync(repo,
                PCM2JaMoPPTestUtils.INTERFACE_NAME);

        this.assertOperationInterfaceCorrespondences(opInterface);
    }

    @Test
    public void testRenameInterface() throws Throwable {
        final Repository repo = this.createAndSyncRepository(this.resourceSet, PCM2JaMoPPTestUtils.REPOSITORY_NAME);
        OperationInterface opInterface = this.addInterfaceToReposiotryAndSync(repo, PCM2JaMoPPTestUtils.INTERFACE_NAME);

        opInterface = this.renameInterfaceAndSync(opInterface);
        super.triggerSynchronization(VURI.getInstance(opInterface.eResource()));

        this.assertOperationInterfaceCorrespondences(opInterface);
    }

    @SuppressWarnings("unchecked")
    private void assertOperationInterfaceCorrespondences(final OperationInterface opInterface) throws Throwable {
        this.assertCorrespondnecesAndCompareNames(opInterface, 2, new java.lang.Class[] { CompilationUnit.class,
                Interface.class }, new String[] { opInterface.getEntityName(), opInterface.getEntityName() });
    }
}
