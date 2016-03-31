package edu.kit.ipd.sdq.vitruvius.dsls.response.runtime.correspondenceFailHandler

import org.eclipse.emf.ecore.EObject
import edu.kit.ipd.sdq.vitruvius.framework.contracts.interfaces.UserInteracting

class CorrespondenceFailException extends AbstractCorrespondenceFailHandler {
	override handle(Iterable<? extends EObject> foundObjects, EObject sourceElement, Class<?> expectedType, UserInteracting userInteracting) {
		logFail(foundObjects, sourceElement, expectedType);
		logger.debug("Throw exception due to correspondence fail");
		throw new IllegalArgumentException(
			"There were (" + foundObjects.size + ") corresponding elements of type " +
				expectedType.getSimpleName() + " for: " + sourceElement + ", which are: " + foundObjects);
	}
}