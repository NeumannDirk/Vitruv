/**
 */
package tools.vitruv.framework.change.echange.compound.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import tools.vitruv.framework.change.echange.AdditiveEChange;

import tools.vitruv.framework.change.echange.compound.CompoundAddition;
import tools.vitruv.framework.change.echange.compound.CompoundPackage;

import tools.vitruv.framework.change.echange.impl.AdditiveEChangeImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Addition</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link tools.vitruv.framework.change.echange.compound.impl.CompoundAdditionImpl#getAdditiveChanges <em>Additive Changes</em>}</li>
 * </ul>
 *
 * @generated
 */
public class CompoundAdditionImpl<T extends Object> extends AdditiveEChangeImpl<T> implements CompoundAddition<T> {
	/**
	 * The cached value of the '{@link #getAdditiveChanges() <em>Additive Changes</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAdditiveChanges()
	 * @generated
	 * @ordered
	 */
	protected EList<AdditiveEChange<T>> additiveChanges;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CompoundAdditionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return CompoundPackage.Literals.COMPOUND_ADDITION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<AdditiveEChange<T>> getAdditiveChanges() {
		if (additiveChanges == null) {
			additiveChanges = new EObjectContainmentEList<AdditiveEChange<T>>(AdditiveEChange.class, this, CompoundPackage.COMPOUND_ADDITION__ADDITIVE_CHANGES);
		}
		return additiveChanges;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case CompoundPackage.COMPOUND_ADDITION__ADDITIVE_CHANGES:
				return ((InternalEList<?>)getAdditiveChanges()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case CompoundPackage.COMPOUND_ADDITION__ADDITIVE_CHANGES:
				return getAdditiveChanges();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case CompoundPackage.COMPOUND_ADDITION__ADDITIVE_CHANGES:
				getAdditiveChanges().clear();
				getAdditiveChanges().addAll((Collection<? extends AdditiveEChange<T>>)newValue);
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
	public void eUnset(int featureID) {
		switch (featureID) {
			case CompoundPackage.COMPOUND_ADDITION__ADDITIVE_CHANGES:
				getAdditiveChanges().clear();
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
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case CompoundPackage.COMPOUND_ADDITION__ADDITIVE_CHANGES:
				return additiveChanges != null && !additiveChanges.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //CompoundAdditionImpl
