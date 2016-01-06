package edu.kit.ipd.sdq.vitruvius.dsls.response.executor

import edu.kit.ipd.sdq.vitruvius.framework.contracts.interfaces.Change2CommandTransformingProviding
import edu.kit.ipd.sdq.vitruvius.framework.util.datatypes.ClaimableMap
import edu.kit.ipd.sdq.vitruvius.framework.contracts.datatypes.VURI
import edu.kit.ipd.sdq.vitruvius.framework.contracts.interfaces.Change2CommandTransforming
import java.util.List
import edu.kit.ipd.sdq.vitruvius.framework.util.datatypes.ClaimableHashMap
import edu.kit.ipd.sdq.vitruvius.framework.util.datatypes.Pair;

abstract class AbstractResponseChange2CommandTransformingProviding implements Change2CommandTransformingProviding {
	protected ClaimableMap<Pair<VURI, VURI>, Change2CommandTransforming> transformationExecuterMap;
	
	new() {
		this.transformationExecuterMap = new ClaimableHashMap<Pair<VURI, VURI>, Change2CommandTransforming>();
	}
	
	protected def void initializeTransformationExecuterMap(List<Change2CommandTransforming> transformationExecutingList) {
		for (transformationExecuting : transformationExecutingList) {
			val transformableMetamodels = transformationExecuting.getTransformableMetamodels();
			for (transformableMetamodel : transformableMetamodels) {
				this.transformationExecuterMap.put(transformableMetamodel, transformationExecuting);
			}
		}
	}
	
	public override Change2CommandTransforming getChange2CommandTransforming(VURI mmURI1, VURI mmURI2) {
		val vuriPair = new Pair<VURI, VURI>(mmURI1, mmURI2);
		return this.transformationExecuterMap.claimValueForKey(vuriPair);
	}
}