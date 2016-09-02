package edu.kit.ipd.sdq.vitruvius.extensions.dslsruntime.mapping.interfaces

import edu.kit.ipd.sdq.vitruvius.framework.correspondence.Correspondence
import java.util.List
import org.eclipse.emf.ecore.EObject
import org.eclipse.xtend.lib.annotations.Data

@Data
public class Candidate implements ElementProvider {
	public List<Correspondence> requiredCorrespondences;
	public List<EObject> elements;
}