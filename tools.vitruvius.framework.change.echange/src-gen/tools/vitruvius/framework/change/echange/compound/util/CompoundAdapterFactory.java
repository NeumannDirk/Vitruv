/**
 */
package tools.vitruvius.framework.change.echange.compound.util;

import tools.vitruvius.framework.change.echange.AdditiveEChange;
import tools.vitruvius.framework.change.echange.EChange;
import tools.vitruvius.framework.change.echange.SubtractiveEChange;
import tools.vitruvius.framework.change.echange.compound.*;
import tools.vitruvius.framework.change.echange.feature.FeatureEChange;
import tools.vitruvius.framework.change.echange.feature.list.InsertInListEChange;
import tools.vitruvius.framework.change.echange.feature.list.RemoveFromListEChange;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see tools.vitruvius.framework.change.echange.compound.CompoundPackage
 * @generated
 */
public class CompoundAdapterFactory extends AdapterFactoryImpl {
    /**
	 * The cached model package.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    protected static CompoundPackage modelPackage;

    /**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    public CompoundAdapterFactory() {
		if (modelPackage == null) {
			modelPackage = CompoundPackage.eINSTANCE;
		}
	}

    /**
	 * Returns whether this factory is applicable for the type of the object.
	 * <!-- begin-user-doc -->
     * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
     * <!-- end-user-doc -->
	 * @return whether this factory is applicable for the type of the object.
	 * @generated
	 */
    @Override
    public boolean isFactoryForType(Object object) {
		if (object == modelPackage) {
			return true;
		}
		if (object instanceof EObject) {
			return ((EObject)object).eClass().getEPackage() == modelPackage;
		}
		return false;
	}

    /**
	 * The switch that delegates to the <code>createXXX</code> methods.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @generated
	 */
    protected CompoundSwitch<Adapter> modelSwitch =
        new CompoundSwitch<Adapter>() {
			@Override
			public Adapter caseCompoundEChange(CompoundEChange object) {
				return createCompoundEChangeAdapter();
			}
			@Override
			public <A extends EObject, B extends EObject, T extends EObject> Adapter caseMoveEObject(MoveEObject<A, B, T> object) {
				return createMoveEObjectAdapter();
			}
			@Override
			public <A extends EObject, F extends EStructuralFeature, T extends EObject, R extends RemoveFromListEChange<A, F> & FeatureEChange<A, F> & SubtractiveEChange<T>, I extends InsertInListEChange<A, F> & FeatureEChange<A, F> & AdditiveEChange<T>> Adapter caseReplaceInEList(ReplaceInEList<A, F, T, R, I> object) {
				return createReplaceInEListAdapter();
			}
			@Override
			public <A extends EObject, F extends EStructuralFeature, T extends Object, S extends FeatureEChange<A, F> & SubtractiveEChange<T>> Adapter caseExplicitUnsetEFeature(ExplicitUnsetEFeature<A, F, T, S> object) {
				return createExplicitUnsetEFeatureAdapter();
			}
			@Override
			public Adapter caseEChange(EChange object) {
				return createEChangeAdapter();
			}
			@Override
			public Adapter defaultCase(EObject object) {
				return createEObjectAdapter();
			}
		};

    /**
	 * Creates an adapter for the <code>target</code>.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @param target the object to adapt.
	 * @return the adapter for the <code>target</code>.
	 * @generated
	 */
    @Override
    public Adapter createAdapter(Notifier target) {
		return modelSwitch.doSwitch((EObject)target);
	}


    /**
	 * Creates a new adapter for an object of class '{@link tools.vitruvius.framework.change.echange.compound.CompoundEChange <em>EChange</em>}'.
	 * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see tools.vitruvius.framework.change.echange.compound.CompoundEChange
	 * @generated
	 */
    public Adapter createCompoundEChangeAdapter() {
		return null;
	}

    /**
	 * Creates a new adapter for an object of class '{@link tools.vitruvius.framework.change.echange.compound.MoveEObject <em>Move EObject</em>}'.
	 * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see tools.vitruvius.framework.change.echange.compound.MoveEObject
	 * @generated
	 */
    public Adapter createMoveEObjectAdapter() {
		return null;
	}

    /**
	 * Creates a new adapter for an object of class '{@link tools.vitruvius.framework.change.echange.compound.ReplaceInEList <em>Replace In EList</em>}'.
	 * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see tools.vitruvius.framework.change.echange.compound.ReplaceInEList
	 * @generated
	 */
    public Adapter createReplaceInEListAdapter() {
		return null;
	}

    /**
	 * Creates a new adapter for an object of class '{@link tools.vitruvius.framework.change.echange.compound.ExplicitUnsetEFeature <em>Explicit Unset EFeature</em>}'.
	 * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see tools.vitruvius.framework.change.echange.compound.ExplicitUnsetEFeature
	 * @generated
	 */
    public Adapter createExplicitUnsetEFeatureAdapter() {
		return null;
	}

    /**
	 * Creates a new adapter for an object of class '{@link tools.vitruvius.framework.change.echange.EChange <em>EChange</em>}'.
	 * <!-- begin-user-doc -->
     * This default implementation returns null so that we can easily ignore cases;
     * it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see tools.vitruvius.framework.change.echange.EChange
	 * @generated
	 */
    public Adapter createEChangeAdapter() {
		return null;
	}

    /**
	 * Creates a new adapter for the default case.
	 * <!-- begin-user-doc -->
     * This default implementation returns null.
     * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @generated
	 */
    public Adapter createEObjectAdapter() {
		return null;
	}

} //CompoundAdapterFactory