package mir.routines.pcm2java;

import edu.kit.ipd.sdq.vitruvius.dsls.response.runtime.AbstractEffectRealization;
import edu.kit.ipd.sdq.vitruvius.dsls.response.runtime.ResponseExecutionState;
import edu.kit.ipd.sdq.vitruvius.dsls.response.runtime.structure.CallHierarchyHaving;
import edu.kit.ipd.sdq.vitruvius.framework.meta.change.feature.reference.UpdateSingleValuedNonContainmentEReference;
import java.io.IOException;
import mir.routines.pcm2java.RoutinesFacade;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.xbase.lib.Extension;
import org.emftext.language.java.members.InterfaceMethod;
import org.palladiosimulator.pcm.repository.DataType;
import org.palladiosimulator.pcm.repository.OperationSignature;

@SuppressWarnings("all")
public class ChangeOperationSignatureReturnTypeEffect extends AbstractEffectRealization {
  public ChangeOperationSignatureReturnTypeEffect(final ResponseExecutionState responseExecutionState, final CallHierarchyHaving calledBy, final UpdateSingleValuedNonContainmentEReference<DataType> change) {
    super(responseExecutionState, calledBy);
    				this.change = change;
  }
  
  private UpdateSingleValuedNonContainmentEReference<DataType> change;
  
  private EObject getCorrepondenceSourceInterfaceMethod(final UpdateSingleValuedNonContainmentEReference<DataType> change) {
    EObject _newAffectedEObject = change.getNewAffectedEObject();
    return _newAffectedEObject;
  }
  
  protected void executeRoutine() throws IOException {
    getLogger().debug("Called routine ChangeOperationSignatureReturnTypeEffect with input:");
    getLogger().debug("   UpdateSingleValuedNonContainmentEReference: " + this.change);
    
    InterfaceMethod interfaceMethod = getCorrespondingElement(
    	getCorrepondenceSourceInterfaceMethod(change), // correspondence source supplier
    	InterfaceMethod.class,
    	(InterfaceMethod _element) -> true, // correspondence precondition checker
    	null);
    if (interfaceMethod == null) {
    	return;
    }
    initializeRetrieveElementState(interfaceMethod);
    
    preprocessElementStates();
    new mir.routines.pcm2java.ChangeOperationSignatureReturnTypeEffect.EffectUserExecution(getExecutionState(), this).executeUserOperations(
    	change, interfaceMethod);
    postprocessElementStates();
  }
  
  private static class EffectUserExecution extends AbstractEffectRealization.UserExecution {
    @Extension
    private RoutinesFacade effectFacade;
    
    public EffectUserExecution(final ResponseExecutionState responseExecutionState, final CallHierarchyHaving calledBy) {
      super(responseExecutionState);
      this.effectFacade = new mir.routines.pcm2java.RoutinesFacade(responseExecutionState, calledBy);
    }
    
    private void executeUserOperations(final UpdateSingleValuedNonContainmentEReference<DataType> change, final InterfaceMethod interfaceMethod) {
      EObject _newAffectedEObject = change.getNewAffectedEObject();
      DataType _returnType__OperationSignature = ((OperationSignature) _newAffectedEObject).getReturnType__OperationSignature();
      this.effectFacade.callChangeInterfaceMethodReturnType(interfaceMethod, _returnType__OperationSignature);
    }
  }
}