/**
 * generated by Xtext 2.10.0
 */
package tools.vitruvius.dsls.response.responseLanguage;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Taggable</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link tools.vitruvius.dsls.response.responseLanguage.Taggable#getTag <em>Tag</em>}</li>
 * </ul>
 *
 * @see tools.vitruvius.dsls.response.responseLanguage.ResponseLanguagePackage#getTaggable()
 * @model
 * @generated
 */
public interface Taggable extends EObject
{
  /**
   * Returns the value of the '<em><b>Tag</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Tag</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Tag</em>' containment reference.
   * @see #setTag(TagCodeBlock)
   * @see tools.vitruvius.dsls.response.responseLanguage.ResponseLanguagePackage#getTaggable_Tag()
   * @model containment="true"
   * @generated
   */
  TagCodeBlock getTag();

  /**
   * Sets the value of the '{@link tools.vitruvius.dsls.response.responseLanguage.Taggable#getTag <em>Tag</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Tag</em>' containment reference.
   * @see #getTag()
   * @generated
   */
  void setTag(TagCodeBlock value);

} // Taggable