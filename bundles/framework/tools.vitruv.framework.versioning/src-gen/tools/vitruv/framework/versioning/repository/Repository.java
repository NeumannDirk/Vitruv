/**
 */
package tools.vitruv.framework.versioning.repository;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

import tools.vitruv.framework.versioning.branch.Branch;
import tools.vitruv.framework.versioning.branch.MasterBranch;

import tools.vitruv.framework.versioning.commit.Commit;
import tools.vitruv.framework.versioning.commit.InitialCommit;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Repository</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link tools.vitruv.framework.versioning.repository.Repository#getTags <em>Tags</em>}</li>
 *   <li>{@link tools.vitruv.framework.versioning.repository.Repository#getCommits <em>Commits</em>}</li>
 *   <li>{@link tools.vitruv.framework.versioning.repository.Repository#getBranches <em>Branches</em>}</li>
 *   <li>{@link tools.vitruv.framework.versioning.repository.Repository#getInitialCommit <em>Initial Commit</em>}</li>
 *   <li>{@link tools.vitruv.framework.versioning.repository.Repository#getMaster <em>Master</em>}</li>
 * </ul>
 *
 * @see tools.vitruv.framework.versioning.repository.RepositoryPackage#getRepository()
 * @model
 * @generated
 */
public interface Repository extends EObject {
	/**
	 * Returns the value of the '<em><b>Tags</b></em>' containment reference list.
	 * The list contents are of type {@link tools.vitruv.framework.versioning.repository.Tag}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Tags</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Tags</em>' containment reference list.
	 * @see tools.vitruv.framework.versioning.repository.RepositoryPackage#getRepository_Tags()
	 * @model containment="true"
	 * @generated
	 */
	EList<Tag> getTags();

	/**
	 * Returns the value of the '<em><b>Commits</b></em>' reference list.
	 * The list contents are of type {@link tools.vitruv.framework.versioning.commit.Commit}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Commits</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Commits</em>' reference list.
	 * @see tools.vitruv.framework.versioning.repository.RepositoryPackage#getRepository_Commits()
	 * @model
	 * @generated
	 */
	EList<Commit> getCommits();

	/**
	 * Returns the value of the '<em><b>Branches</b></em>' containment reference list.
	 * The list contents are of type {@link tools.vitruv.framework.versioning.branch.Branch}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Branches</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Branches</em>' containment reference list.
	 * @see tools.vitruv.framework.versioning.repository.RepositoryPackage#getRepository_Branches()
	 * @model containment="true"
	 * @generated
	 */
	EList<Branch> getBranches();

	/**
	 * Returns the value of the '<em><b>Initial Commit</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Initial Commit</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Initial Commit</em>' containment reference.
	 * @see #setInitialCommit(InitialCommit)
	 * @see tools.vitruv.framework.versioning.repository.RepositoryPackage#getRepository_InitialCommit()
	 * @model containment="true" required="true"
	 * @generated
	 */
	InitialCommit getInitialCommit();

	/**
	 * Sets the value of the '{@link tools.vitruv.framework.versioning.repository.Repository#getInitialCommit <em>Initial Commit</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Initial Commit</em>' containment reference.
	 * @see #getInitialCommit()
	 * @generated
	 */
	void setInitialCommit(InitialCommit value);

	/**
	 * Returns the value of the '<em><b>Master</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Master</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Master</em>' reference.
	 * @see #setMaster(MasterBranch)
	 * @see tools.vitruv.framework.versioning.repository.RepositoryPackage#getRepository_Master()
	 * @model required="true"
	 * @generated
	 */
	MasterBranch getMaster();

	/**
	 * Sets the value of the '{@link tools.vitruv.framework.versioning.repository.Repository#getMaster <em>Master</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Master</em>' reference.
	 * @see #getMaster()
	 * @generated
	 */
	void setMaster(MasterBranch value);

} // Repository