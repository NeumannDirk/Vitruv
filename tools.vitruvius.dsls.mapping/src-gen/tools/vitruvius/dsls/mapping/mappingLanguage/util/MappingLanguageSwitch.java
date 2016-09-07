/**
 * generated by Xtext 2.9.2
 */
package tools.vitruvius.dsls.mapping.mappingLanguage.util;

import tools.vitruvius.dsls.mapping.mappingLanguage.*;

import tools.vitruvius.dsls.mirbase.mirBase.MirBaseFile;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.util.Switch;

/**
 * <!-- begin-user-doc -->
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * @see tools.vitruvius.dsls.mapping.mappingLanguage.MappingLanguagePackage
 * @generated
 */
public class MappingLanguageSwitch<T> extends Switch<T>
{
  /**
   * The cached model package
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected static MappingLanguagePackage modelPackage;

  /**
   * Creates an instance of the switch.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public MappingLanguageSwitch()
  {
    if (modelPackage == null)
    {
      modelPackage = MappingLanguagePackage.eINSTANCE;
    }
  }

  /**
   * Checks whether this is a switch for the given package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param ePackage the package in question.
   * @return whether this is a switch for the given package.
   * @generated
   */
  @Override
  protected boolean isSwitchFor(EPackage ePackage)
  {
    return ePackage == modelPackage;
  }

  /**
   * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the first non-null result returned by a <code>caseXXX</code> call.
   * @generated
   */
  @Override
  protected T doSwitch(int classifierID, EObject theEObject)
  {
    switch (classifierID)
    {
      case MappingLanguagePackage.MAPPING_FILE:
      {
        MappingFile mappingFile = (MappingFile)theEObject;
        T result = caseMappingFile(mappingFile);
        if (result == null) result = caseMirBaseFile(mappingFile);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case MappingLanguagePackage.MAPPING:
      {
        Mapping mapping = (Mapping)theEObject;
        T result = caseMapping(mapping);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case MappingLanguagePackage.SIGNATURE:
      {
        Signature signature = (Signature)theEObject;
        T result = caseSignature(signature);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case MappingLanguagePackage.REQUIRED_MAPPING:
      {
        RequiredMapping requiredMapping = (RequiredMapping)theEObject;
        T result = caseRequiredMapping(requiredMapping);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case MappingLanguagePackage.CONSTRAINT_BLOCK:
      {
        ConstraintBlock constraintBlock = (ConstraintBlock)theEObject;
        T result = caseConstraintBlock(constraintBlock);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case MappingLanguagePackage.CONSTRAINT_EXPRESSION:
      {
        ConstraintExpression constraintExpression = (ConstraintExpression)theEObject;
        T result = caseConstraintExpression(constraintExpression);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case MappingLanguagePackage.SIGNATURE_CONSTRAINT_BLOCK:
      {
        SignatureConstraintBlock signatureConstraintBlock = (SignatureConstraintBlock)theEObject;
        T result = caseSignatureConstraintBlock(signatureConstraintBlock);
        if (result == null) result = caseConstraintBlock(signatureConstraintBlock);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case MappingLanguagePackage.BODY_CONSTRAINT_BLOCK:
      {
        BodyConstraintBlock bodyConstraintBlock = (BodyConstraintBlock)theEObject;
        T result = caseBodyConstraintBlock(bodyConstraintBlock);
        if (result == null) result = caseConstraintBlock(bodyConstraintBlock);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case MappingLanguagePackage.FEATURE_OF_CONTEXT_VARIABLE:
      {
        FeatureOfContextVariable featureOfContextVariable = (FeatureOfContextVariable)theEObject;
        T result = caseFeatureOfContextVariable(featureOfContextVariable);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case MappingLanguagePackage.CONTEXT_VARIABLE:
      {
        ContextVariable contextVariable = (ContextVariable)theEObject;
        T result = caseContextVariable(contextVariable);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case MappingLanguagePackage.REQUIRED_MAPPING_PATH_BASE:
      {
        RequiredMappingPathBase requiredMappingPathBase = (RequiredMappingPathBase)theEObject;
        T result = caseRequiredMappingPathBase(requiredMappingPathBase);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case MappingLanguagePackage.REQUIRED_MAPPING_PATH_TAIL:
      {
        RequiredMappingPathTail requiredMappingPathTail = (RequiredMappingPathTail)theEObject;
        T result = caseRequiredMappingPathTail(requiredMappingPathTail);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case MappingLanguagePackage.CONSTRAINT_LITERAL:
      {
        ConstraintLiteral constraintLiteral = (ConstraintLiteral)theEObject;
        T result = caseConstraintLiteral(constraintLiteral);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case MappingLanguagePackage.XBASE_SIGNATURE_CONSTRAINT_EXPRESSION:
      {
        XbaseSignatureConstraintExpression xbaseSignatureConstraintExpression = (XbaseSignatureConstraintExpression)theEObject;
        T result = caseXbaseSignatureConstraintExpression(xbaseSignatureConstraintExpression);
        if (result == null) result = caseConstraintExpression(xbaseSignatureConstraintExpression);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case MappingLanguagePackage.XBASE_BODY_CONSTRAINT_EXPRESSION:
      {
        XbaseBodyConstraintExpression xbaseBodyConstraintExpression = (XbaseBodyConstraintExpression)theEObject;
        T result = caseXbaseBodyConstraintExpression(xbaseBodyConstraintExpression);
        if (result == null) result = caseConstraintExpression(xbaseBodyConstraintExpression);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case MappingLanguagePackage.VARIABLE_REF:
      {
        VariableRef variableRef = (VariableRef)theEObject;
        T result = caseVariableRef(variableRef);
        if (result == null) result = caseConstraintExpression(variableRef);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case MappingLanguagePackage.IN_EXPRESSION:
      {
        InExpression inExpression = (InExpression)theEObject;
        T result = caseInExpression(inExpression);
        if (result == null) result = caseConstraintExpression(inExpression);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case MappingLanguagePackage.NOT_NULL_EXPRESSION:
      {
        NotNullExpression notNullExpression = (NotNullExpression)theEObject;
        T result = caseNotNullExpression(notNullExpression);
        if (result == null) result = caseConstraintExpression(notNullExpression);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case MappingLanguagePackage.DEFAULT_CONTAIN_EXPRESSION:
      {
        DefaultContainExpression defaultContainExpression = (DefaultContainExpression)theEObject;
        T result = caseDefaultContainExpression(defaultContainExpression);
        if (result == null) result = caseConstraintExpression(defaultContainExpression);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case MappingLanguagePackage.EQUALS_LITERAL_EXPRESSION:
      {
        EqualsLiteralExpression equalsLiteralExpression = (EqualsLiteralExpression)theEObject;
        T result = caseEqualsLiteralExpression(equalsLiteralExpression);
        if (result == null) result = caseConstraintExpression(equalsLiteralExpression);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case MappingLanguagePackage.ATTRIBUTE_EQUIVALENCE_EXPRESSION:
      {
        AttributeEquivalenceExpression attributeEquivalenceExpression = (AttributeEquivalenceExpression)theEObject;
        T result = caseAttributeEquivalenceExpression(attributeEquivalenceExpression);
        if (result == null) result = caseConstraintExpression(attributeEquivalenceExpression);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case MappingLanguagePackage.CONSTRAINT_BOOLEAN_LITERAL:
      {
        ConstraintBooleanLiteral constraintBooleanLiteral = (ConstraintBooleanLiteral)theEObject;
        T result = caseConstraintBooleanLiteral(constraintBooleanLiteral);
        if (result == null) result = caseConstraintLiteral(constraintBooleanLiteral);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case MappingLanguagePackage.CONSTRAINT_NULL_LITERAL:
      {
        ConstraintNullLiteral constraintNullLiteral = (ConstraintNullLiteral)theEObject;
        T result = caseConstraintNullLiteral(constraintNullLiteral);
        if (result == null) result = caseConstraintLiteral(constraintNullLiteral);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case MappingLanguagePackage.CONSTRAINT_NUMBER_LITERAL:
      {
        ConstraintNumberLiteral constraintNumberLiteral = (ConstraintNumberLiteral)theEObject;
        T result = caseConstraintNumberLiteral(constraintNumberLiteral);
        if (result == null) result = caseConstraintLiteral(constraintNumberLiteral);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case MappingLanguagePackage.CONSTRAINT_STRING_LITERAL:
      {
        ConstraintStringLiteral constraintStringLiteral = (ConstraintStringLiteral)theEObject;
        T result = caseConstraintStringLiteral(constraintStringLiteral);
        if (result == null) result = caseConstraintLiteral(constraintStringLiteral);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      default: return defaultCase(theEObject);
    }
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Mapping File</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Mapping File</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseMappingFile(MappingFile object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Mapping</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Mapping</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseMapping(Mapping object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Signature</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Signature</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseSignature(Signature object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Required Mapping</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Required Mapping</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseRequiredMapping(RequiredMapping object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Constraint Block</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Constraint Block</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseConstraintBlock(ConstraintBlock object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Constraint Expression</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Constraint Expression</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseConstraintExpression(ConstraintExpression object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Signature Constraint Block</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Signature Constraint Block</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseSignatureConstraintBlock(SignatureConstraintBlock object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Body Constraint Block</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Body Constraint Block</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseBodyConstraintBlock(BodyConstraintBlock object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Feature Of Context Variable</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Feature Of Context Variable</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseFeatureOfContextVariable(FeatureOfContextVariable object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Context Variable</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Context Variable</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseContextVariable(ContextVariable object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Required Mapping Path Base</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Required Mapping Path Base</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseRequiredMappingPathBase(RequiredMappingPathBase object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Required Mapping Path Tail</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Required Mapping Path Tail</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseRequiredMappingPathTail(RequiredMappingPathTail object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Constraint Literal</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Constraint Literal</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseConstraintLiteral(ConstraintLiteral object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Xbase Signature Constraint Expression</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Xbase Signature Constraint Expression</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseXbaseSignatureConstraintExpression(XbaseSignatureConstraintExpression object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Xbase Body Constraint Expression</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Xbase Body Constraint Expression</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseXbaseBodyConstraintExpression(XbaseBodyConstraintExpression object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Variable Ref</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Variable Ref</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseVariableRef(VariableRef object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>In Expression</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>In Expression</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseInExpression(InExpression object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Not Null Expression</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Not Null Expression</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseNotNullExpression(NotNullExpression object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Default Contain Expression</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Default Contain Expression</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseDefaultContainExpression(DefaultContainExpression object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Equals Literal Expression</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Equals Literal Expression</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseEqualsLiteralExpression(EqualsLiteralExpression object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Attribute Equivalence Expression</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Attribute Equivalence Expression</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseAttributeEquivalenceExpression(AttributeEquivalenceExpression object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Constraint Boolean Literal</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Constraint Boolean Literal</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseConstraintBooleanLiteral(ConstraintBooleanLiteral object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Constraint Null Literal</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Constraint Null Literal</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseConstraintNullLiteral(ConstraintNullLiteral object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Constraint Number Literal</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Constraint Number Literal</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseConstraintNumberLiteral(ConstraintNumberLiteral object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Constraint String Literal</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Constraint String Literal</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseConstraintStringLiteral(ConstraintStringLiteral object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>File</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>File</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseMirBaseFile(MirBaseFile object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch, but this is the last case anyway.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject)
   * @generated
   */
  @Override
  public T defaultCase(EObject object)
  {
    return null;
  }

} //MappingLanguageSwitch