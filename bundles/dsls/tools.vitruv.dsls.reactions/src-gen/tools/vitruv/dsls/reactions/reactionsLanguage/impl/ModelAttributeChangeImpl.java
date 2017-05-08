/**
 * generated by Xtext 2.12.0-SNAPSHOT
 */
package tools.vitruv.dsls.reactions.reactionsLanguage.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import tools.vitruv.dsls.mirbase.mirBase.MetaclassEAttributeReference;

import tools.vitruv.dsls.reactions.reactionsLanguage.ModelAttributeChange;
import tools.vitruv.dsls.reactions.reactionsLanguage.ReactionsLanguagePackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Model Attribute Change</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link tools.vitruv.dsls.reactions.reactionsLanguage.impl.ModelAttributeChangeImpl#getFeature <em>Feature</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ModelAttributeChangeImpl extends ConcreteModelChangeImpl implements ModelAttributeChange
{
  /**
   * The cached value of the '{@link #getFeature() <em>Feature</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getFeature()
   * @generated
   * @ordered
   */
  protected MetaclassEAttributeReference feature;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected ModelAttributeChangeImpl()
  {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected EClass eStaticClass()
  {
    return ReactionsLanguagePackage.Literals.MODEL_ATTRIBUTE_CHANGE;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public MetaclassEAttributeReference getFeature()
  {
    return feature;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetFeature(MetaclassEAttributeReference newFeature, NotificationChain msgs)
  {
    MetaclassEAttributeReference oldFeature = feature;
    feature = newFeature;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ReactionsLanguagePackage.MODEL_ATTRIBUTE_CHANGE__FEATURE, oldFeature, newFeature);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setFeature(MetaclassEAttributeReference newFeature)
  {
    if (newFeature != feature)
    {
      NotificationChain msgs = null;
      if (feature != null)
        msgs = ((InternalEObject)feature).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ReactionsLanguagePackage.MODEL_ATTRIBUTE_CHANGE__FEATURE, null, msgs);
      if (newFeature != null)
        msgs = ((InternalEObject)newFeature).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ReactionsLanguagePackage.MODEL_ATTRIBUTE_CHANGE__FEATURE, null, msgs);
      msgs = basicSetFeature(newFeature, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ReactionsLanguagePackage.MODEL_ATTRIBUTE_CHANGE__FEATURE, newFeature, newFeature));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs)
  {
    switch (featureID)
    {
      case ReactionsLanguagePackage.MODEL_ATTRIBUTE_CHANGE__FEATURE:
        return basicSetFeature(null, msgs);
    }
    return super.eInverseRemove(otherEnd, featureID, msgs);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Object eGet(int featureID, boolean resolve, boolean coreType)
  {
    switch (featureID)
    {
      case ReactionsLanguagePackage.MODEL_ATTRIBUTE_CHANGE__FEATURE:
        return getFeature();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void eSet(int featureID, Object newValue)
  {
    switch (featureID)
    {
      case ReactionsLanguagePackage.MODEL_ATTRIBUTE_CHANGE__FEATURE:
        setFeature((MetaclassEAttributeReference)newValue);
        return;
    }
    super.eSet(featureID, newValue);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void eUnset(int featureID)
  {
    switch (featureID)
    {
      case ReactionsLanguagePackage.MODEL_ATTRIBUTE_CHANGE__FEATURE:
        setFeature((MetaclassEAttributeReference)null);
        return;
    }
    super.eUnset(featureID);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public boolean eIsSet(int featureID)
  {
    switch (featureID)
    {
      case ReactionsLanguagePackage.MODEL_ATTRIBUTE_CHANGE__FEATURE:
        return feature != null;
    }
    return super.eIsSet(featureID);
  }

} //ModelAttributeChangeImpl
