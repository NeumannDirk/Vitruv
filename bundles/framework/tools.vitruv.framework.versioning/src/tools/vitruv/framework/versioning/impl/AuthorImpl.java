/**
 */
package tools.vitruv.framework.versioning.impl;

import java.lang.reflect.InvocationTargetException;
import java.util.Collection;
import java.util.Date;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;

import tools.vitruv.framework.change.echange.EChange;
import tools.vitruv.framework.versioning.Author;
import tools.vitruv.framework.versioning.VersioningPackage;

import tools.vitruv.framework.versioning.branch.Branch;
import tools.vitruv.framework.versioning.branch.BranchPackage;
import tools.vitruv.framework.versioning.commit.Commit;
import tools.vitruv.framework.versioning.commit.CommitFactory;
import tools.vitruv.framework.versioning.commit.CommitMessage;
import tools.vitruv.framework.versioning.commit.InitialCommit;
import tools.vitruv.framework.versioning.commit.SimpleCommit;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Author</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link tools.vitruv.framework.versioning.impl.AuthorImpl#getEmail <em>Email</em>}</li>
 *   <li>{@link tools.vitruv.framework.versioning.impl.AuthorImpl#getOwnedBranches <em>Owned Branches</em>}</li>
 *   <li>{@link tools.vitruv.framework.versioning.impl.AuthorImpl#getContributedBranches <em>Contributed Branches</em>}</li>
 *   <li>{@link tools.vitruv.framework.versioning.impl.AuthorImpl#getCommits <em>Commits</em>}</li>
 * </ul>
 *
 * @generated
 */
public class AuthorImpl extends NamedImpl implements Author {
	/**
	 * The default value of the '{@link #getEmail() <em>Email</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEmail()
	 * @ordered
	 */
	protected static final String EMAIL_EDEFAULT = "EMAIL";

	/**
	 * The cached value of the '{@link #getEmail() <em>Email</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEmail()
	 * @generated
	 * @ordered
	 */
	protected String email = EMAIL_EDEFAULT;

	/**
	 * The cached value of the '{@link #getOwnedBranches() <em>Owned Branches</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedBranches()
	 * @generated
	 * @ordered
	 */
	protected EList<Branch> ownedBranches;

	/**
	 * The cached value of the '{@link #getContributedBranches() <em>Contributed Branches</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getContributedBranches()
	 * @generated
	 * @ordered
	 */
	protected EList<Branch> contributedBranches;

	/**
	 * The cached value of the '{@link #getCommits() <em>Commits</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCommits()
	 * @generated
	 * @ordered
	 */
	protected EList<Commit> commits;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AuthorImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	public AuthorImpl(final String email, final String name) {
		this();
		this.email = email;
		this.name = name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return VersioningPackage.Literals.AUTHOR;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEmail(String newEmail) {
		String oldEmail = email;
		email = newEmail;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, VersioningPackage.AUTHOR__EMAIL, oldEmail, email));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Branch> getOwnedBranches() {
		if (ownedBranches == null) {
			ownedBranches = new EObjectWithInverseResolvingEList<Branch>(Branch.class, this, VersioningPackage.AUTHOR__OWNED_BRANCHES, BranchPackage.BRANCH__OWNER);
		}
		return ownedBranches;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Branch> getContributedBranches() {
		if (contributedBranches == null) {
			contributedBranches = new EObjectWithInverseResolvingEList.ManyInverse<Branch>(Branch.class, this, VersioningPackage.AUTHOR__CONTRIBUTED_BRANCHES, BranchPackage.BRANCH__CONTRIBUTORS);
		}
		return contributedBranches;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Commit> getCommits() {
		if (commits == null) {
			commits = new EObjectResolvingEList<Commit>(Commit.class, this, VersioningPackage.AUTHOR__COMMITS);
		}
		return commits;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	public InitialCommit createInitialCommit() {
		final InitialCommit initialCommit = CommitFactory.eINSTANCE.createInitialCommit();
		final CommitMessage commitMessage = CommitFactory.eINSTANCE.createCommitMessage();
		commitMessage.setAuthor(this);
		commitMessage.setDate(new Date());
		commitMessage.setMessage("Initial commit");
		initialCommit.setCommitmessage(commitMessage);
		this.getCommits().add(initialCommit);
		return initialCommit;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SimpleCommit createSimpleCommit(String message, Commit parent, EList<EChange> changes) {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Branch createBranch(String branchName) {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case VersioningPackage.AUTHOR__OWNED_BRANCHES:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getOwnedBranches()).basicAdd(otherEnd, msgs);
			case VersioningPackage.AUTHOR__CONTRIBUTED_BRANCHES:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getContributedBranches()).basicAdd(otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case VersioningPackage.AUTHOR__OWNED_BRANCHES:
				return ((InternalEList<?>)getOwnedBranches()).basicRemove(otherEnd, msgs);
			case VersioningPackage.AUTHOR__CONTRIBUTED_BRANCHES:
				return ((InternalEList<?>)getContributedBranches()).basicRemove(otherEnd, msgs);
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
			case VersioningPackage.AUTHOR__EMAIL:
				return getEmail();
			case VersioningPackage.AUTHOR__OWNED_BRANCHES:
				return getOwnedBranches();
			case VersioningPackage.AUTHOR__CONTRIBUTED_BRANCHES:
				return getContributedBranches();
			case VersioningPackage.AUTHOR__COMMITS:
				return getCommits();
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
			case VersioningPackage.AUTHOR__EMAIL:
				setEmail((String)newValue);
				return;
			case VersioningPackage.AUTHOR__OWNED_BRANCHES:
				getOwnedBranches().clear();
				getOwnedBranches().addAll((Collection<? extends Branch>)newValue);
				return;
			case VersioningPackage.AUTHOR__CONTRIBUTED_BRANCHES:
				getContributedBranches().clear();
				getContributedBranches().addAll((Collection<? extends Branch>)newValue);
				return;
			case VersioningPackage.AUTHOR__COMMITS:
				getCommits().clear();
				getCommits().addAll((Collection<? extends Commit>)newValue);
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
			case VersioningPackage.AUTHOR__EMAIL:
				setEmail(EMAIL_EDEFAULT);
				return;
			case VersioningPackage.AUTHOR__OWNED_BRANCHES:
				getOwnedBranches().clear();
				return;
			case VersioningPackage.AUTHOR__CONTRIBUTED_BRANCHES:
				getContributedBranches().clear();
				return;
			case VersioningPackage.AUTHOR__COMMITS:
				getCommits().clear();
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
			case VersioningPackage.AUTHOR__EMAIL:
				return EMAIL_EDEFAULT == null ? email != null : !EMAIL_EDEFAULT.equals(email);
			case VersioningPackage.AUTHOR__OWNED_BRANCHES:
				return ownedBranches != null && !ownedBranches.isEmpty();
			case VersioningPackage.AUTHOR__CONTRIBUTED_BRANCHES:
				return contributedBranches != null && !contributedBranches.isEmpty();
			case VersioningPackage.AUTHOR__COMMITS:
				return commits != null && !commits.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	@SuppressWarnings("unchecked")
	public Object eInvoke(int operationID, EList<?> arguments) throws InvocationTargetException {
		switch (operationID) {
			case VersioningPackage.AUTHOR___CREATE_INITIAL_COMMIT:
				return createInitialCommit();
			case VersioningPackage.AUTHOR___CREATE_SIMPLE_COMMIT__STRING_COMMIT_ELIST:
				return createSimpleCommit((String)arguments.get(0), (Commit)arguments.get(1), (EList<EChange>)arguments.get(2));
			case VersioningPackage.AUTHOR___CREATE_BRANCH__STRING:
				return createBranch((String)arguments.get(0));
		}
		return super.eInvoke(operationID, arguments);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (email: ");
		result.append(email);
		result.append(')');
		return result.toString();
	}

} //AuthorImpl
