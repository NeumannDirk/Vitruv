/**
 * generated by Xtext 2.12.0-SNAPSHOT
 */
package tools.vitruv.dsls.mirbase.mirBase;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see tools.vitruv.dsls.mirbase.mirBase.MirBasePackage
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
  MirBaseFactory eINSTANCE = tools.vitruv.dsls.mirbase.mirBase.impl.MirBaseFactoryImpl.init();

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
   * Returns a new object of class '<em>Metaclass Reference</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Metaclass Reference</em>'.
   * @generated
   */
  MetaclassReference createMetaclassReference();

  /**
   * Returns a new object of class '<em>Named Metaclass Reference</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Named Metaclass Reference</em>'.
   * @generated
   */
  NamedMetaclassReference createNamedMetaclassReference();

  /**
   * Returns a new object of class '<em>Metaclass Feature Reference</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Metaclass Feature Reference</em>'.
   * @generated
   */
  MetaclassFeatureReference createMetaclassFeatureReference();

  /**
   * Returns a new object of class '<em>Metaclass EAttribute Reference</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Metaclass EAttribute Reference</em>'.
   * @generated
   */
  MetaclassEAttributeReference createMetaclassEAttributeReference();

  /**
   * Returns a new object of class '<em>Metaclass EReference Reference</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Metaclass EReference Reference</em>'.
   * @generated
   */
  MetaclassEReferenceReference createMetaclassEReferenceReference();

  /**
   * Returns a new object of class '<em>Metamodel Reference</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Metamodel Reference</em>'.
   * @generated
   */
  MetamodelReference createMetamodelReference();

  /**
   * Returns a new object of class '<em>Domain Reference</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Domain Reference</em>'.
   * @generated
   */
  DomainReference createDomainReference();

  /**
   * Returns the package supported by this factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the package supported by this factory.
   * @generated
   */
  MirBasePackage getMirBasePackage();

} //MirBaseFactory
