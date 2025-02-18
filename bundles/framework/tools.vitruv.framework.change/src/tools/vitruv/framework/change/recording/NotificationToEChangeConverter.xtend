package tools.vitruv.framework.change.recording

import java.util.List
import org.eclipse.emf.common.util.URI
import org.eclipse.emf.ecore.EAttribute
import org.eclipse.emf.ecore.EObject
import org.eclipse.emf.ecore.EReference
import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.xtend.lib.annotations.FinalFieldsConstructor
import tools.vitruv.framework.change.echange.EChange
import tools.vitruv.framework.change.echange.TypeInferringAtomicEChangeFactory
import tools.vitruv.framework.change.echange.eobject.EObjectAddedEChange
import tools.vitruv.framework.change.echange.eobject.EObjectSubtractedEChange
import tools.vitruv.framework.change.echange.feature.attribute.AttributeFactory
import tools.vitruv.framework.change.echange.feature.reference.UpdateReferenceEChange

import static org.eclipse.emf.common.notify.Notification.*

import static extension edu.kit.ipd.sdq.commons.util.java.lang.IterableUtil.*
import static extension tools.vitruv.framework.change.recording.EChangeCreationUtil.*
import tools.vitruv.framework.change.echange.EChangeUtil

/** 
 * Converts an EMF notification to an {@link EChange}.
 * @author Heiko Klare
 */
@FinalFieldsConstructor
package final class NotificationToEChangeConverter {
	extension val TypeInferringAtomicEChangeFactory changeFactory = TypeInferringAtomicEChangeFactory.instance
	
	val (EObject, EObject)=>boolean isCreateChange

	def createDeleteChange(EObjectSubtractedEChange<?> change) {
		val deleteChange = createDeleteEObjectChange(change.oldValue)
		return deleteChange
	}
	
	/** 
	 * Converts the given notification to a list of {@link EChange}s.
	 * @param n the notification to convert
	 * @return the  {@link Iterable} of {@link EChange}s
	 */
	def Iterable<? extends EChange> convert(extension NotificationInfo notification) {
		return switch (notification) {
			case isTouch,
			case isTransient,
			case oldValue == newValue:
				emptyList()
			case notification.isAttributeNotification:
				switch (eventType) {
					case SET: handleSetAttribute(notification)
					case UNSET: handleUnsetAttribute(notification)
					case ADD: handleInsertAttribute(notification)
					case ADD_MANY: handleMultiInsertAttribute(notification)
					case REMOVE: handleRemoveAttribute(notification)
					case REMOVE_MANY: handleMultiRemoveAttribute(notification)
					default: emptyList()
				}
			case notification.isReferenceNotification:
				switch (eventType) {
					case SET: handleSetReference(notification)
					case UNSET: handleUnsetReference(notification)
					case ADD: handleInsertReference(notification)
					case ADD_MANY: handleMultiInsertReference(notification)
					case REMOVE: handleRemoveReference(notification)
					case REMOVE_MANY: handleMultiRemoveReference(notification)
					default: emptyList()
				}
			case notifier instanceof Resource:
				switch (getFeatureID(Resource)) {
					case Resource.RESOURCE__CONTENTS:
						switch (eventType) {
							case ADD: handleInsertRootChange(notification)
							case ADD_MANY: handleMultiInsertRootChange(notification)
							case REMOVE: handleRemoveRootChange(notification)
							case REMOVE_MANY: handleMultiRemoveRootChange(notification)
							default: emptyList()
						}
					case Resource.RESOURCE__URI:
						switch (eventType) {
							case SET: handleSetUriChange(notification)
							default: emptyList()
						}
					default:
						emptyList()
				}
			default:
				emptyList()
		}
	}

	def private Iterable<? extends EChange> handleSetAttribute(extension NotificationInfo notification) {
		switch (notification) {
			case !attribute.isMany:
				handleReplaceAttribute(notification)
			case oldValue !== null && newValue !== null:
				handleRemoveAttribute(notification) + handleInsertAttribute(notification)
			case newValue !== null:
				handleInsertAttribute(notification)
			case oldValue !== null:
				handleRemoveAttribute(notification)
			default:
				emptyList()
		}
	}

	private def Iterable<? extends EChange> handleSetReference(extension NotificationInfo notification) {
		switch (notification) {
			case !reference.isMany:
				handleReplaceReference(notification)
			case oldValue !== null && newValue !== null:
				handleRemoveReference(notification) + handleInsertReference(notification)
			case newValue !== null:
				handleInsertReference(notification)
			case oldValue !== null:
				handleRemoveReference(notification)
			default:
				emptyList()
		}
	}

	def private Iterable<? extends EChange> handleUnsetAttribute(extension NotificationInfo notification) {
		return if (!attribute.isMany) {
			handleSetAttribute(notification)
		} else {
			List.of(createUnsetFeatureChange(notifierModelElement, attribute))
		}
	}

	private def Iterable<? extends EChange> handleUnsetReference(extension NotificationInfo notification) {
		if (!reference.isMany) {
			handleSetReference(notification)
		} else {
			List.of(createUnsetFeatureChange(notifierModelElement, reference))
		}
	}

	private def Iterable<? extends EChange> handleReplaceAttribute(extension NotificationInfo notification) {
		val change = AttributeFactory.eINSTANCE.createReplaceSingleValuedEAttribute()
		change.oldValue = oldValue
		change.newValue = newValue
		change.affectedFeature = attribute
		change.affectedEObject = notifierModelElement
		change.isUnset = wasUnset
		return List.of(change)
	}

	private def Iterable<? extends EChange> handleReplaceReference(extension NotificationInfo notification) {
		val change = createReplaceSingleReferenceChange(notifierModelElement, reference, oldModelElementValue,
			newModelElementValue)
		change.isUnset = notification.wasUnset
		return change.surroundWithCreateAndFeatureChangesIfNecessary()
	}

	private def handleRemoveAttribute(extension NotificationInfo notification) {
		createRemoveAttributeChange(notifierModelElement, attribute, position, oldValue).
			addUnsetChangeIfNecessary(notification)
	}

	private def handleMultiRemoveAttribute(extension NotificationInfo notification) {
		// TODO HK Is that check necessary?
		if (newValue === null) {
			val oldValues = oldValue as List<?>
			oldValues.reverseView.mapFixedIndexed [ index, value |
				val valueIndex = initialIndex + oldValues.size - 1 - index
				createRemoveAttributeChange(notifierModelElement, attribute, valueIndex, value)
			].addUnsetChangeIfNecessary(notification)
		} else {
			unsetChangeOrEmpty(notification)
		}
	}

	private def Iterable<? extends EChange> handleRemoveReference(extension NotificationInfo notification) {
		createRemoveReferenceChange(notifierModelElement, reference, oldModelElementValue, position).
			addUnsetChangeIfNecessary(notification)
	}

	private def Iterable<? extends EChange> handleMultiRemoveReference(extension NotificationInfo notification) {
		if (newValue === null) {
			val oldValues = oldValue as List<EObject>
			oldValues.reverseView.mapFixedIndexed [ index, value |
				val valueIndex = initialIndex + oldValues.size - 1 - index
				createRemoveReferenceChange(notifierModelElement, reference, value, valueIndex)
			].addUnsetChangeIfNecessary(notification)
		} else {
			unsetChangeOrEmpty(notification)
		}
	}

	private def handleInsertAttribute(extension NotificationInfo notification) {
		List.of(createInsertAttributeChange(notifierModelElement, attribute, position, newValue))
	}

	private def handleMultiInsertAttribute(extension NotificationInfo notification) {
		(newValue as List<?>).mapFixedIndexed [ index, value |
			createInsertAttributeChange(notifierModelElement, attribute, initialIndex + index, value)
		]
	}

	private def Iterable<? extends EChange> handleInsertReference(extension NotificationInfo notification) {
		/* If the new value was just inserted at the last position the index can be
		 * changed to {@code EChangeUtil.LAST_POSITION_INDEX}.
		 */		 
		var newIndex = position
		var eRef = notifierModelElement.eGet(reference) as Iterable<Object>
		if (isInsertionAtLastPosition(position, eRef.size(), 1)) {
			newIndex = EChangeUtil.LAST_POSITION_INDEX
		}
		createInsertReferenceChange(notifierModelElement, reference, newModelElementValue, newIndex).
			surroundWithCreateAndFeatureChangesIfNecessary()
	}

	private def Iterable<? extends EChange> handleMultiInsertReference(extension NotificationInfo notification) {
		val listOfNewValues = newValue as List<EObject>
		val numOfElementsInEReferenceAfterInsertion = (notifierModelElement.eGet(reference) as Iterable<Object>).size

		/* If the first new element an therefore all other new elements as well are inserted at the last position,
		 * the insertion index can be changed to {@code EChangeUtil.LAST_POSITION_INDEX} for all elements.
		 */
		if (isInsertionAtLastPosition(initialIndex, numOfElementsInEReferenceAfterInsertion, listOfNewValues.size)) {
			listOfNewValues.flatMapFixedIndexed [ index, value |
				createInsertReferenceChange(notifierModelElement, reference, value, EChangeUtil.LAST_POSITION_INDEX).
					surroundWithCreateAndFeatureChangesIfNecessary()
			]
		} else {
			listOfNewValues.flatMapFixedIndexed [ index, value |
				createInsertReferenceChange(notifierModelElement, reference, value, initialIndex + index).
					surroundWithCreateAndFeatureChangesIfNecessary()
			]
		}
	}
	
	private def boolean isInsertionAtLastPosition(int positionOfFirstInsertion, int sizeAfterInsertions, int numberOfInsertions) {
		return positionOfFirstInsertion == sizeAfterInsertions - numberOfInsertions
	}

	private def handleInsertRootChange(extension NotificationInfo notification) {
		createInsertRootChange(newModelElementValue, notifierResource, position).
			surroundWithCreateAndFeatureChangesIfNecessary()
	}

	private def handleMultiInsertRootChange(extension NotificationInfo notification) {
		(notification.newValue as List<EObject>).flatMapFixedIndexed [ index, value |
			createInsertRootChange(value, notifierResource, initialIndex + index).
				surroundWithCreateAndFeatureChangesIfNecessary()
		]
	}

	private def handleRemoveRootChange(extension NotificationInfo notification) {
		List.of(createRemoveRootChange(oldModelElementValue, notifierResource, position))
	}

	private def handleMultiRemoveRootChange(extension NotificationInfo notification) {
		val oldValues = notification.oldValue as List<EObject>
		oldValues.reverseView.mapFixedIndexed [ index, value |
			val valueIndex = initialIndex + oldValues.size - 1 - index
			createRemoveRootChange(value, notifierResource, valueIndex)
		]
	}

	private def Iterable<? extends EChange> handleSetUriChange(extension NotificationInfo notification) {
		val oldUri = notification.oldValue as URI
		notifierResource.contents.mapFixedIndexed [ index, value |
			val valueIndex = initialIndex + notifierResource.contents.size - 1 - index
			val oldResource = notifierResource.resourceSet.createResource(oldUri)
			createRemoveRootChange(value, oldResource, oldUri, valueIndex)
		] + notifierResource.contents.flatMapFixedIndexed [ index, value |
			createInsertRootChange(value, notifierResource, initialIndex + index).
				surroundWithCreateAndFeatureChangesIfNecessary()
		]
	}

	def private Iterable<? extends EChange> allAdditiveChangesForChangeRelevantFeatures(EObjectAddedEChange<?> change, EObject eObject) {
		change.newValue.walkChangeRelevantFeatures(
			[object, attribute|createAdditiveEChangeForAttribute(object, attribute)],
			[object, reference|if (reference.isContainment) createAdditiveEChangeForReferencedObject(object, reference, [referencedObject | isCreateChange.apply(object, referencedObject)])]
		) + change.newValue.walkChangeRelevantFeatures(null) [ object, reference |
			if (!reference.isContainment) createAdditiveEChangeForReferencedObject(object, reference, [false])
		]
	}

	def private static Iterable<? extends EChange> walkChangeRelevantFeatures(
		EObject eObject,
		(EObject, EAttribute)=>Iterable<? extends EChange> attributeVisitor,
		(EObject, EReference)=>Iterable<? extends EChange> referenceVisitor
	) {
		val changeRelevantFeatures = eObject.eClass.EAllStructuralFeatures.filter [
			eObject.hasChangeableUnderivedPersistedNotContainingNonDefaultValue(it)
		]
		val thisLayerAttributeResults = changeRelevantFeatures.filter(EAttribute).flatMapFixed [
			attributeVisitor?.apply(eObject, it) ?: emptyList()
		]
		val thisLayerReferenceResults = changeRelevantFeatures.filter(EReference).flatMapFixed [
			referenceVisitor?.apply(eObject, it) ?: emptyList()
		]
		val nextLayer = changeRelevantFeatures.filter(EReference).filter[isContainment].flatMap [
			eObject.getReferencedElements(it)
		].flatMapFixed [
			it.walkChangeRelevantFeatures(attributeVisitor, referenceVisitor)
		]
		thisLayerAttributeResults + thisLayerReferenceResults + nextLayer
	}

	def static private Iterable<EObject> getReferencedElements(EObject eObject, EReference reference) {
		return if (reference.many)
			eObject.eGet(reference) as Iterable<EObject>
		else
			List.of(eObject.eGet(reference) as EObject)
	}

	def private unsetChangeOrEmpty(NotificationInfo notification) {
		if (notification.wasUnset) {
			List.of(createUnsetFeatureChange(notification.notifierModelElement, notification.structuralFeature))
		} else
			emptyList()
	}

	def private <T extends EChange> addUnsetChangeIfNecessary(Iterable<T> changes, NotificationInfo notification) {
		return if (notification.wasUnset)
			changes +
				List.of(createUnsetFeatureChange(notification.notifierModelElement, notification.structuralFeature))
		else
			changes
	}

	def private addUnsetChangeIfNecessary(EChange change, NotificationInfo notification) {
		return if (notification.wasUnset)
			List.of(change, createUnsetFeatureChange(notification.notifierModelElement, notification.structuralFeature))
		else
			List.of(change)
	}

	private def Iterable<? extends EChange> surroundWithCreateAndFeatureChangesIfNecessary(
		EObjectAddedEChange<?> change) {
		return if (isCreateChange.apply(if (change instanceof UpdateReferenceEChange<?>) change.affectedEObject, change.newValue)) {
			val createChange = createCreateEObjectChange(change.newValue)
			List.of(createChange, change) + allAdditiveChangesForChangeRelevantFeatures(change, change.newValue)
		} else
			List.of(change)
	}

}
