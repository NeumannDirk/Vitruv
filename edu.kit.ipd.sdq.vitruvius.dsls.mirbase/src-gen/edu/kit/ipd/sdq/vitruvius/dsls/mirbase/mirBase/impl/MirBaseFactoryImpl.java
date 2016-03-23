/**
 * generated by Xtext 2.9.1
 */
package edu.kit.ipd.sdq.vitruvius.dsls.mirbase.mirBase.impl;

import edu.kit.ipd.sdq.vitruvius.dsls.mirbase.mirBase.*;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class MirBaseFactoryImpl extends EFactoryImpl implements MirBaseFactory
{
  /**
   * Creates the default factory implementation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static MirBaseFactory init()
  {
    try
    {
      MirBaseFactory theMirBaseFactory = (MirBaseFactory)EPackage.Registry.INSTANCE.getEFactory(MirBasePackage.eNS_URI);
      if (theMirBaseFactory != null)
      {
        return theMirBaseFactory;
      }
    }
    catch (Exception exception)
    {
      EcorePlugin.INSTANCE.log(exception);
    }
    return new MirBaseFactoryImpl();
  }

  /**
   * Creates an instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public MirBaseFactoryImpl()
  {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EObject create(EClass eClass)
  {
    switch (eClass.getClassifierID())
    {
      case MirBasePackage.DUMMY_ENTRY_RULE: return createDummyEntryRule();
      case MirBasePackage.MIR_BASE_FILE: return createMirBaseFile();
      case MirBasePackage.METAMODEL_IMPORT: return createMetamodelImport();
      case MirBasePackage.NAMED_JAVA_ELEMENT: return createNamedJavaElement();
      case MirBasePackage.MODEL_ELEMENT: return createModelElement();
      case MirBasePackage.FEATURE_OF_ELEMENT: return createFeatureOfElement();
      case MirBasePackage.METAMODEL_REFERENCE: return createMetamodelReference();
      default:
        throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public DummyEntryRule createDummyEntryRule()
  {
    DummyEntryRuleImpl dummyEntryRule = new DummyEntryRuleImpl();
    return dummyEntryRule;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public MirBaseFile createMirBaseFile()
  {
    MirBaseFileImpl mirBaseFile = new MirBaseFileImpl();
    return mirBaseFile;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public MetamodelImport createMetamodelImport()
  {
    MetamodelImportImpl metamodelImport = new MetamodelImportImpl();
    return metamodelImport;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NamedJavaElement createNamedJavaElement()
  {
    NamedJavaElementImpl namedJavaElement = new NamedJavaElementImpl();
    return namedJavaElement;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ModelElement createModelElement()
  {
    ModelElementImpl modelElement = new ModelElementImpl();
    return modelElement;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public FeatureOfElement createFeatureOfElement()
  {
    FeatureOfElementImpl featureOfElement = new FeatureOfElementImpl();
    return featureOfElement;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public MetamodelReference createMetamodelReference()
  {
    MetamodelReferenceImpl metamodelReference = new MetamodelReferenceImpl();
    return metamodelReference;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public MirBasePackage getMirBasePackage()
  {
    return (MirBasePackage)getEPackage();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @deprecated
   * @generated
   */
  @Deprecated
  public static MirBasePackage getPackage()
  {
    return MirBasePackage.eINSTANCE;
  }

} //MirBaseFactoryImpl
