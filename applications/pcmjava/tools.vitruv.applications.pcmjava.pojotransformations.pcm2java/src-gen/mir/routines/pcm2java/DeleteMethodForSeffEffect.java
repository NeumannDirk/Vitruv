package mir.routines.pcm2java;

import java.io.IOException;
import mir.routines.pcm2java.RoutinesFacade;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.xbase.lib.Extension;
import org.emftext.language.java.members.ClassMethod;
import org.palladiosimulator.pcm.seff.ServiceEffectSpecification;
import tools.vitruv.extensions.dslsruntime.response.AbstractEffectRealization;
import tools.vitruv.extensions.dslsruntime.response.ResponseExecutionState;
import tools.vitruv.extensions.dslsruntime.response.structure.CallHierarchyHaving;

@SuppressWarnings("all")
public class DeleteMethodForSeffEffect extends AbstractEffectRealization {
  public DeleteMethodForSeffEffect(final ResponseExecutionState responseExecutionState, final CallHierarchyHaving calledBy, final ServiceEffectSpecification seff) {
    super(responseExecutionState, calledBy);
    				this.seff = seff;
  }
  
  private ServiceEffectSpecification seff;
  
  private static class EffectUserExecution extends AbstractEffectRealization.UserExecution {
    public EffectUserExecution(final ResponseExecutionState responseExecutionState, final CallHierarchyHaving calledBy) {
      super(responseExecutionState);
    }
  }
  
  private static class CallRoutinesUserExecution extends AbstractEffectRealization.UserExecution {
    @Extension
    private RoutinesFacade effectFacade;
    
    public CallRoutinesUserExecution(final ResponseExecutionState responseExecutionState, final CallHierarchyHaving calledBy) {
      super(responseExecutionState);
      this.effectFacade = new mir.routines.pcm2java.RoutinesFacade(responseExecutionState, calledBy);
    }
  }
  
  private EObject getElement0(final ServiceEffectSpecification seff, final ClassMethod classMethod) {
    return classMethod;
  }
  
  protected void executeRoutine() throws IOException {
    getLogger().debug("Called routine DeleteMethodForSeffEffect with input:");
    getLogger().debug("   ServiceEffectSpecification: " + this.seff);
    
    ClassMethod classMethod = getCorrespondingElement(
    	getCorrepondenceSourceClassMethod(seff), // correspondence source supplier
    	ClassMethod.class,
    	(ClassMethod _element) -> true, // correspondence precondition checker
    	null);
    if (classMethod == null) {
    	return;
    }
    initializeRetrieveElementState(classMethod);
    deleteObject(getElement0(seff, classMethod));
    
    preprocessElementStates();
    postprocessElementStates();
  }
  
  private EObject getCorrepondenceSourceClassMethod(final ServiceEffectSpecification seff) {
    return seff;
  }
}
