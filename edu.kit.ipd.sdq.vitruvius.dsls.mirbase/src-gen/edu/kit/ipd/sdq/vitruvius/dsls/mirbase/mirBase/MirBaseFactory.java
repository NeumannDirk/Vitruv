/**
 * generated by Xtext 2.9.1
 */
package edu.kit.ipd.sdq.vitruvius.dsls.mirbase.mirBase;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see edu.kit.ipd.sdq.vitruvius.dsls.mirbase.mirBase.MirBasePackage
 * @generated
 */
public interface MirBaseFactory extends EFactory
{
  /**
   * The singleton instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  MirBaseFactory eINSTANCE = edu.kit.ipd.sdq.vitruvius.dsls.mirbase.mirBase.impl.MirBaseFactoryImpl.init();

  /**
   * Returns a new object of class '<em>Dummy Entry Rule</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Dummy Entry Rule</em>'.
   * @generated
   */
  DummyEntryRule createDummyEntryRule();

  /**
   * Returns a new object of class '<em>File</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>File</em>'.
   * @generated
   */
  MirBaseFile createMirBaseFile();

  /**
   * Returns a new object of class '<em>Metamodel Import</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Metamodel Import</em>'.
   * @generated
   */
  MetamodelImport createMetamodelImport();

  /**
   * Returns a new object of class '<em>Named Java Element</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Named Java Element</em>'.
   * @generated
   */
  NamedJavaElement createNamedJavaElement();

  /**
   * Returns a new object of class '<em>Model Element</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Model Element</em>'.
   * @generated
   */
  ModelElement createModelElement();

  /**
   * Returns a new object of class '<em>Feature Of Element</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Feature Of Element</em>'.
   * @generated
   */
  FeatureOfElement createFeatureOfElement();

  /**
   * Returns a new object of class '<em>Metamodel Reference</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Metamodel Reference</em>'.
   * @generated
   */
  MetamodelReference createMetamodelReference();

  /**
   * Returns the package supported by this factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the package supported by this factory.
   * @generated
   */
  MirBasePackage getMirBasePackage();

} //MirBaseFactory
