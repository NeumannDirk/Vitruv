package mir.routines.simpleChangesTests;

import allElementTypes.NonRoot;
import allElementTypes.Root;
import com.google.common.base.Objects;
import java.io.IOException;
import java.util.function.Predicate;
import mir.routines.simpleChangesTests.RoutinesFacade;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.xbase.lib.Extension;
import tools.vitruv.dsls.response.tests.simpleChangesTests.SimpleChangesTestsExecutionMonitor;
import tools.vitruv.extensions.dslsruntime.response.AbstractEffectRealization;
import tools.vitruv.extensions.dslsruntime.response.ResponseExecutionState;
import tools.vitruv.extensions.dslsruntime.response.structure.CallHierarchyHaving;

@SuppressWarnings("all")
public class RemoveNonContainmentReferenceEffect extends AbstractEffectRealization {
  public RemoveNonContainmentReferenceEffect(final ResponseExecutionState responseExecutionState, final CallHierarchyHaving calledBy, final Root root, final NonRoot removedNonRoot) {
    super(responseExecutionState, calledBy);
    				this.root = root;this.removedNonRoot = removedNonRoot;
  }
  
  private Root root;
  
  private NonRoot removedNonRoot;
  
  private static class EffectUserExecution extends AbstractEffectRealization.UserExecution {
    public EffectUserExecution(final ResponseExecutionState responseExecutionState, final CallHierarchyHaving calledBy) {
      super(responseExecutionState);
    }
    
    private void executeUserOperations(final Root root, final NonRoot removedNonRoot, final Root targetRoot) {
      EList<NonRoot> _multiValuedNonContainmentEReference = targetRoot.getMultiValuedNonContainmentEReference();
      final Predicate<NonRoot> _function = (NonRoot it) -> {
        String _id = it.getId();
        String _id_1 = removedNonRoot.getId();
        return Objects.equal(_id, _id_1);
      };
      _multiValuedNonContainmentEReference.removeIf(_function);
      SimpleChangesTestsExecutionMonitor _instance = SimpleChangesTestsExecutionMonitor.getInstance();
      _instance.set(SimpleChangesTestsExecutionMonitor.ChangeType.RemoveNonContainmentEReference);
    }
  }
  
  private static class CallRoutinesUserExecution extends AbstractEffectRealization.UserExecution {
    @Extension
    private RoutinesFacade effectFacade;
    
    public CallRoutinesUserExecution(final ResponseExecutionState responseExecutionState, final CallHierarchyHaving calledBy) {
      super(responseExecutionState);
      this.effectFacade = new mir.routines.simpleChangesTests.RoutinesFacade(responseExecutionState, calledBy);
    }
  }
  
  private EObject getCorrepondenceSourceTargetRoot(final Root root, final NonRoot removedNonRoot) {
    return root;
  }
  
  protected void executeRoutine() throws IOException {
    getLogger().debug("Called routine RemoveNonContainmentReferenceEffect with input:");
    getLogger().debug("   Root: " + this.root);
    getLogger().debug("   NonRoot: " + this.removedNonRoot);
    
    Root targetRoot = getCorrespondingElement(
    	getCorrepondenceSourceTargetRoot(root, removedNonRoot), // correspondence source supplier
    	Root.class,
    	(Root _element) -> true, // correspondence precondition checker
    	null);
    if (targetRoot == null) {
    	return;
    }
    initializeRetrieveElementState(targetRoot);
    
    preprocessElementStates();
    new mir.routines.simpleChangesTests.RemoveNonContainmentReferenceEffect.EffectUserExecution(getExecutionState(), this).executeUserOperations(
    	root, removedNonRoot, targetRoot);
    postprocessElementStates();
  }
}
