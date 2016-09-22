/*
 * generated by Xtext 2.9.0
 */
package tools.vitruv.dsls.response.ui.outline

import org.eclipse.xtext.ui.editor.outline.impl.DefaultOutlineTreeProvider
import org.eclipse.xtext.ui.editor.outline.impl.DocumentRootNode
import tools.vitruv.dsls.response.responseLanguage.ResponseFile
import tools.vitruv.dsls.response.responseLanguage.Response
import tools.vitruv.dsls.response.responseLanguage.Trigger
import static extension tools.vitruv.dsls.response.helper.EChangeHelper.*;
import tools.vitruv.dsls.response.responseLanguage.CodeBlock
import tools.vitruv.dsls.response.responseLanguage.ResponseLanguagePackage
import org.eclipse.xtext.ui.editor.outline.impl.EStructuralFeatureNode
import tools.vitruv.dsls.response.responseLanguage.ConcreteModelElementChange
import tools.vitruv.dsls.response.responseLanguage.AtomicFeatureChange
import tools.vitruv.dsls.response.responseLanguage.AtomicRootObjectChange
import tools.vitruv.dsls.mirbase.mirBase.MetamodelImport
import tools.vitruv.dsls.mirbase.mirBase.MirBasePackage
import tools.vitruv.dsls.response.responseLanguage.PreconditionCodeBlock
import tools.vitruv.dsls.response.responseLanguage.Effect
import tools.vitruv.dsls.response.responseLanguage.ResponsesSegment
import tools.vitruv.dsls.response.responseLanguage.Routine
import tools.vitruv.dsls.response.responseLanguage.CreateCorrespondence
import tools.vitruv.dsls.response.responseLanguage.RemoveCorrespondence
import tools.vitruv.dsls.response.responseLanguage.RetrieveModelElement

/**
 * Outline structure definition for a response file.
 *
 * @author Heiko Klare
 */
class ResponseLanguageOutlineTreeProvider extends DefaultOutlineTreeProvider {
	protected def void _createChildren(DocumentRootNode root, ResponseFile responseFile) {
		val importsNode = createEStructuralFeatureNode(root, responseFile, 
			MirBasePackage.Literals.MIR_BASE_FILE__METAMODEL_IMPORTS,
			imageDispatcher.invoke(responseFile), "imports", false);
		for (imp : responseFile.metamodelImports) {
			createChildren(importsNode, imp);
		}
		for (responseSegment : responseFile.responsesSegments) {
			createChildren(root, responseSegment);
		}
	}
	
	protected def void _createChildren(EStructuralFeatureNode parentNode, ResponsesSegment responsesSegment) {
		val segmentNode = createEObjectNode(parentNode, responsesSegment);
		for (response: responsesSegment.responses) {
			createChildren(segmentNode, response);	
		}
		for (routine : responsesSegment.routines) {
			createChildren(segmentNode, routine);	
		}
	}
	
	protected def void _createChildren(EStructuralFeatureNode parentNode, MetamodelImport imp) {
		val importNode = createEObjectNode(parentNode, imp);
		createEStructuralFeatureNode(importNode,
			imp, MirBasePackage.Literals.METAMODEL_IMPORT__PACKAGE,
			imageDispatcher.invoke(imp.package),
			imp.package.name, true);
	}
	
	protected def void _createChildren(EStructuralFeatureNode parentNode, Response response) {
		val responseNode = createEObjectNode(parentNode, response);
		if (response.documentation != null) {
			createEStructuralFeatureNode(responseNode, response,
				ResponseLanguagePackage.Literals.RESPONSE__DOCUMENTATION,
				imageDispatcher.invoke(response.documentation),
				"documentation", true);
		}
		val triggerNode = createEStructuralFeatureNode(responseNode, response, 
			ResponseLanguagePackage.Literals.RESPONSE__TRIGGER,
			imageDispatcher.invoke(response.trigger), "trigger", response.trigger == null);
		if (response.trigger != null) {
			createChildren(triggerNode, response.trigger);
		}
		if (response.trigger?.precondition != null) {
			createChildren(triggerNode, response.trigger.precondition)
		}
	}
	
	protected def void _createChildren(EStructuralFeatureNode parentNode, PreconditionCodeBlock preconditionBlock) {
		createEObjectNode(parentNode, preconditionBlock);
	}
	
	protected def void _createChildren(EStructuralFeatureNode parentNode, Trigger trigger) {
		createEObjectNode(parentNode, trigger);
	}
	
	protected def void _createChildren(EStructuralFeatureNode parentNode, AtomicFeatureChange event) {
		createEObjectNode(parentNode, event);
		if (event.changedFeature != null) {
			createEObjectNode(parentNode, event.changedFeature.element);
			if (event.changedFeature.feature != null) {
				createEObjectNode(parentNode, event.changedFeature.feature);
			}
		}
	}
	
	protected def void _createChildren(EStructuralFeatureNode parentNode, AtomicRootObjectChange event) {
		createEObjectNode(parentNode, event);
		if (event.changedElement != null) {
			createEObjectNode(parentNode, event.changedElement.element);
		}
	}
	
	protected def void _createChildren(EStructuralFeatureNode parentNode, Routine routine) {
		for (element : routine.matching.retrievedElements) {
			createEObjectNode(parentNode, element);	
		}
		
		createChildren(parentNode, routine.effect);
	}
	
	protected def void _createChildren(EStructuralFeatureNode parentNode, Effect effect) {
		for (element : effect.correspondenceCreation) {
			createEObjectNode(parentNode, element);	
		}
		for (element : effect.correspondenceDeletion) {
			createEObjectNode(parentNode, element);	
		}
		
		createChildren(parentNode, effect.codeBlock);
	}
	
	protected def void _createChildren(EStructuralFeatureNode parentNode, CreateCorrespondence createCorrespondence) {
		createEObjectNode(parentNode, createCorrespondence);
	}
	
	protected def void _createChildren(EStructuralFeatureNode parentNode, CodeBlock codeBlock) {
		createEObjectNode(parentNode, codeBlock);
	}
	
	protected def Object _text(MetamodelImport imp) {
		return imp?.name;
	}
	
	protected def Object _text(Response response) {
		return "response: " + response.name;
	}
	
	protected def Object _text(Routine routine) {
		return "effect: " + routine.name;
	}
	
	protected def Object _text(ResponsesSegment responsesSegment) {
		return "segment: " + responsesSegment.name;
	}
	
	protected def Object _text(Trigger trigger) {
		return "There is no outline for this trigger";
	}
	
	protected def Object _text(AtomicFeatureChange event) {
		if (event.changedFeature?.element != null) {
			return event.generateEChange()?.name;
		} else {
			return "No changed element specified"
		}
	}
	
	protected def Object _text(AtomicRootObjectChange event) {
		if (event.changedElement?.element != null) {
			return event.generateEChange()?.name;
		} else {
			return "No changed element specified"
		}
	}
	
	protected def Object _text(PreconditionCodeBlock preconditionBlock) {
		return "precondition Block"
	}
	
	protected def Object _text(CodeBlock codeBlock) {
		return "execution Block"
	}
	
//	protected def Object _text(CorrespondingModelElementCreate elementCreate) {
//		"Create element: " + elementCreate.elementText;
//	}
	
	protected def Object _text(RetrieveModelElement elementRetrieve) {
		"retrieve element: " + elementRetrieve.elementText;
	}
	
	protected def Object _text(CreateCorrespondence createCorrespondence) {
		"new correspondence";
	}
	
	protected def Object _text(RemoveCorrespondence removeCorrespondence) {
		"remove correspondence";
	}
	
//	protected def Object _text(CorrespondingModelElementDelete elementDelete) {
//		"Delete element: " + elementDelete.elementText;
//	}
	
	private def String getElementText(RetrieveModelElement retrieveElement) {
		return retrieveElement.element.name + " (" + retrieveElement.element?.element?.name + ")"
	}
	
	protected def boolean _isLeaf(PreconditionCodeBlock compareBlock) {
		return true;
	}
	
	protected def boolean _isLeaf(CodeBlock codeBlock) {
		return true;
	}
	
	protected def boolean _isLeaf(ConcreteModelElementChange event) {
		return true;
	}
	
	protected def boolean _isLeaf(RetrieveModelElement element) {
		return true;
	}
	
	protected def boolean _isLeaf(CreateCorrespondence correspondenceCreate) {
		return true;
	}
	
	protected def boolean _isLeaf(RemoveCorrespondence element) {
		return true;
	}
	
}
