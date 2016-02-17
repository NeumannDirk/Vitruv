package edu.kit.ipd.sdq.vitruvius.dsls.response.api.runtime

import org.eclipse.emf.ecore.EObject
import edu.kit.ipd.sdq.vitruvius.framework.contracts.datatypes.CorrespondenceInstance
import edu.kit.ipd.sdq.vitruvius.framework.contracts.meta.correspondence.Correspondence
import edu.kit.ipd.sdq.vitruvius.framework.contracts.datatypes.TUID

public final class ResponseRuntimeHelper {
	public static def EObject getModelRoot(EObject modelObject) {
		var result = modelObject;
		while (result.eContainer() != null) {
			result = result.eContainer();
		}
		return result;
	}
	
	public static def Iterable<? extends EObject> getCorrespondingObjects(CorrespondenceInstance correspondenceInstance, EObject source) {
		val correspondences = correspondenceInstance.getCorrespondences(#[source])
		return correspondences.map[correspondence |
			if (correspondence.^as.contains(source)) {
				return correspondence.^bs;
			} else {
				return correspondence.^as;
			}
		].flatten
	}
	
	private static def getTUID(CorrespondenceInstance correspondenceInstance, EObject object, EObject parent) {
		if (parent == null) {
			return correspondenceInstance.calculateTUIDFromEObject(object);
		} else {
			val rootTUID = correspondenceInstance.calculateTUIDFromEObject(parent);
			val String prefix = rootTUID.toString;
			return correspondenceInstance.calculateTUIDFromEObject(object, object.eContainer(), prefix);
		}
	}
	
	public static def removeCorrespondence(CorrespondenceInstance correspondenceInstance, EObject source, EObject sourceParent, EObject target, EObject targetParent) {
		val sourceTUID = correspondenceInstance.getTUID(source, sourceParent);
		val targetTUID = correspondenceInstance.getTUID(source, targetParent);
		val correspondences = correspondenceInstance.getCorrespondencesForTUIDs(#[sourceTUID]);
		for (correspondence : correspondences) {
			if ((correspondence.ATUIDs.contains(sourceTUID)
				&& correspondence.BTUIDs.contains(targetTUID))
				|| (correspondence.BTUIDs.contains(sourceTUID)
				&& correspondence.ATUIDs.contains(targetTUID))) {
				correspondenceInstance.removeCorrespondencesAndDependendCorrespondences(correspondence);		
			}
		}
	}
	
	public static def <T> Iterable<T> getCorrespondingObjectsOfType(CorrespondenceInstance correspondenceInstance, EObject source, Class<T> type) {
		//return correspondenceInstance.getCorrespondingObjectsOfType(source, source.eContainer(), type);
		return correspondenceInstance.getCorrespondingObjects(source).filter(type);
	}
	
	public static def <T> Iterable<Correspondence> getCorrespondencesWithTargetType(CorrespondenceInstance correspondenceInstance, EObject source, EObject sourceParent,
			Class<T> type) {
		val tuid = correspondenceInstance.getTUID(source, sourceParent);
		val correspondences = correspondenceInstance.getCorrespondencesForTUIDs(#[tuid]); 
		return correspondences.filter[correspondence |
			if (correspondence.ATUIDs.contains(tuid)) {
				return !correspondence.bs.filter(type).empty;
			}
			if (correspondence.BTUIDs.contains(tuid)) {
				return !correspondence.^as.filter(type).empty;
			}
			return false;
		]
	}
	
	public static def <T> Iterable<T> getCorrespondingObjectsOfType(CorrespondenceInstance correspondenceInstance, EObject source, EObject sourceParent,
			Class<T> type) {
		val tuid = correspondenceInstance.getTUID(source, sourceParent);
		return correspondenceInstance.getCorrespondencesForTUIDs(#[tuid]).map[it.getCorrespondingObjectsOfTypeInCorrespondence(tuid, type)].flatten;
	}
	
	public static def <T> Iterable<Correspondence> getCorrespondencesWithTargetType(CorrespondenceInstance correspondenceInstance, EObject source,
			Class<T> type) {
		val correspondences = correspondenceInstance.getCorrespondences(#[source])
		return correspondences.filter[correspondence |
			if (correspondence.^as.contains(source)) {
				return !correspondence.bs.filter(type).empty;
			}
			if (correspondence.^bs.contains(source)) {
				return !correspondence.^as.filter(type).empty;
			}
			return false;
		]
	}
	
	private static def <T> Iterable<T> getCorrespondingObjectsOfTypeInCorrespondence(Correspondence correspondence, TUID source, Class<T> type) {
		var Iterable<T> correspondences = 
			if (correspondence.ATUIDs.contains(source)) {
				correspondence.^bs.filter(type);
			} else {
				correspondence.^as.filter(type);
			}
		return correspondences;
	}
	
	public static def <T> Iterable<T> getCorrespondingObjectsOfTypeInCorrespondence(Correspondence correspondence, EObject source, Class<T> type) {
		var Iterable<T> correspondences = 
			if (correspondence.^as.contains(source)) {
				correspondence.^bs.filter(type);
			} else {
				correspondence.^as.filter(type);
			}
		return correspondences;
	}
	
}
