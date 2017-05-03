/**
 */
package tools.vitruv.framework.versioning.branch.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EcorePackage;

import org.eclipse.emf.ecore.impl.EPackageImpl;
import org.eclipse.emf.ecore.impl.EcorePackageImpl;

import tools.vitruv.framework.change.echange.EChangePackage;

import tools.vitruv.framework.change.echange.impl.EChangePackageImpl;

import tools.vitruv.framework.versioning.VersioningPackage;

import tools.vitruv.framework.versioning.author.AuthorPackage;
import tools.vitruv.framework.versioning.author.impl.AuthorPackageImpl;
import tools.vitruv.framework.versioning.branch.Branch;
import tools.vitruv.framework.versioning.branch.BranchDiff;
import tools.vitruv.framework.versioning.branch.BranchDiffCreator;
import tools.vitruv.framework.versioning.branch.BranchFactory;
import tools.vitruv.framework.versioning.branch.BranchPackage;

import tools.vitruv.framework.versioning.branch.MasterBranch;
import tools.vitruv.framework.versioning.branch.UserBranch;
import tools.vitruv.framework.versioning.commit.CommitPackage;

import tools.vitruv.framework.versioning.commit.impl.CommitPackageImpl;

import tools.vitruv.framework.versioning.conflict.ConflictPackage;

import tools.vitruv.framework.versioning.conflict.impl.ConflictPackageImpl;

import tools.vitruv.framework.versioning.impl.VersioningPackageImpl;
import tools.vitruv.framework.versioning.repository.RepositoryPackage;
import tools.vitruv.framework.versioning.repository.impl.RepositoryPackageImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class BranchPackageImpl extends EPackageImpl implements BranchPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass branchDiffCreatorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass branchDiffEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass userBranchEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass masterBranchEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass branchEClass = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with
	 * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
	 * package URI value.
	 * <p>Note: the correct way to create the package is via the static
	 * factory method {@link #init init()}, which also performs
	 * initialization of the package, or returns the registered package,
	 * if one already exists.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see tools.vitruv.framework.versioning.branch.BranchPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private BranchPackageImpl() {
		super(eNS_URI, BranchFactory.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
	 * 
	 * <p>This method is used to initialize {@link BranchPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static BranchPackage init() {
		if (isInited) return (BranchPackage)EPackage.Registry.INSTANCE.getEPackage(BranchPackage.eNS_URI);

		// Obtain or create and register package
		BranchPackageImpl theBranchPackage = (BranchPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof BranchPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new BranchPackageImpl());

		isInited = true;

		// Obtain or create and register interdependencies
		VersioningPackageImpl theVersioningPackage = (VersioningPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(VersioningPackage.eNS_URI) instanceof VersioningPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(VersioningPackage.eNS_URI) : VersioningPackage.eINSTANCE);
		ConflictPackageImpl theConflictPackage = (ConflictPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(ConflictPackage.eNS_URI) instanceof ConflictPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(ConflictPackage.eNS_URI) : ConflictPackage.eINSTANCE);
		CommitPackageImpl theCommitPackage = (CommitPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(CommitPackage.eNS_URI) instanceof CommitPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(CommitPackage.eNS_URI) : CommitPackage.eINSTANCE);
		AuthorPackageImpl theAuthorPackage = (AuthorPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(AuthorPackage.eNS_URI) instanceof AuthorPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(AuthorPackage.eNS_URI) : AuthorPackage.eINSTANCE);
		RepositoryPackageImpl theRepositoryPackage = (RepositoryPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(RepositoryPackage.eNS_URI) instanceof RepositoryPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(RepositoryPackage.eNS_URI) : RepositoryPackage.eINSTANCE);
		EcorePackageImpl theEcorePackage = (EcorePackageImpl)(EPackage.Registry.INSTANCE.getEPackage(EcorePackage.eNS_URI) instanceof EcorePackageImpl ? EPackage.Registry.INSTANCE.getEPackage(EcorePackage.eNS_URI) : EcorePackage.eINSTANCE);
		EChangePackageImpl theEChangePackage = (EChangePackageImpl)(EPackage.Registry.INSTANCE.getEPackage(EChangePackage.eNS_URI) instanceof EChangePackageImpl ? EPackage.Registry.INSTANCE.getEPackage(EChangePackage.eNS_URI) : EChangePackage.eINSTANCE);

		// Create package meta-data objects
		theBranchPackage.createPackageContents();
		theVersioningPackage.createPackageContents();
		theConflictPackage.createPackageContents();
		theCommitPackage.createPackageContents();
		theAuthorPackage.createPackageContents();
		theRepositoryPackage.createPackageContents();
		theEcorePackage.createPackageContents();
		theEChangePackage.createPackageContents();

		// Initialize created meta-data
		theBranchPackage.initializePackageContents();
		theVersioningPackage.initializePackageContents();
		theConflictPackage.initializePackageContents();
		theCommitPackage.initializePackageContents();
		theAuthorPackage.initializePackageContents();
		theRepositoryPackage.initializePackageContents();
		theEcorePackage.initializePackageContents();
		theEChangePackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theBranchPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(BranchPackage.eNS_URI, theBranchPackage);
		return theBranchPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getBranchDiffCreator() {
		return branchDiffCreatorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getBranchDiffCreator_Source() {
		return (EReference)branchDiffCreatorEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getBranchDiffCreator_Target() {
		return (EReference)branchDiffCreatorEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getBranchDiffCreator__CreateVersionDiff() {
		return branchDiffCreatorEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getBranchDiff() {
		return branchDiffEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getBranchDiff_SourceCommits() {
		return (EReference)branchDiffEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getBranchDiff_TargetCommits() {
		return (EReference)branchDiffEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getBranchDiff_Source() {
		return (EReference)branchDiffEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getBranchDiff_Target() {
		return (EReference)branchDiffEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getBranchDiff_LastCommonAncestor() {
		return (EReference)branchDiffEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getUserBranch() {
		return userBranchEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getUserBranch_Owner() {
		return (EReference)userBranchEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getUserBranch_BranchedFrom() {
		return (EReference)userBranchEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMasterBranch() {
		return masterBranchEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getBranch() {
		return branchEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getBranch_CurrentHeadCommit() {
		return (EReference)branchEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getBranch_Contributors() {
		return (EReference)branchEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getBranch_ChildBranches() {
		return (EReference)branchEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BranchFactory getBranchFactory() {
		return (BranchFactory)getEFactoryInstance();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isCreated = false;

	/**
	 * Creates the meta-model objects for the package.  This method is
	 * guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void createPackageContents() {
		if (isCreated) return;
		isCreated = true;

		// Create classes and their features
		branchDiffCreatorEClass = createEClass(BRANCH_DIFF_CREATOR);
		createEReference(branchDiffCreatorEClass, BRANCH_DIFF_CREATOR__SOURCE);
		createEReference(branchDiffCreatorEClass, BRANCH_DIFF_CREATOR__TARGET);
		createEOperation(branchDiffCreatorEClass, BRANCH_DIFF_CREATOR___CREATE_VERSION_DIFF);

		branchDiffEClass = createEClass(BRANCH_DIFF);
		createEReference(branchDiffEClass, BRANCH_DIFF__SOURCE_COMMITS);
		createEReference(branchDiffEClass, BRANCH_DIFF__TARGET_COMMITS);
		createEReference(branchDiffEClass, BRANCH_DIFF__SOURCE);
		createEReference(branchDiffEClass, BRANCH_DIFF__TARGET);
		createEReference(branchDiffEClass, BRANCH_DIFF__LAST_COMMON_ANCESTOR);

		userBranchEClass = createEClass(USER_BRANCH);
		createEReference(userBranchEClass, USER_BRANCH__OWNER);
		createEReference(userBranchEClass, USER_BRANCH__BRANCHED_FROM);

		masterBranchEClass = createEClass(MASTER_BRANCH);

		branchEClass = createEClass(BRANCH);
		createEReference(branchEClass, BRANCH__CURRENT_HEAD_COMMIT);
		createEReference(branchEClass, BRANCH__CONTRIBUTORS);
		createEReference(branchEClass, BRANCH__CHILD_BRANCHES);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isInitialized = false;

	/**
	 * Complete the initialization of the package and its meta-model.  This
	 * method is guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void initializePackageContents() {
		if (isInitialized) return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Obtain other dependent packages
		CommitPackage theCommitPackage = (CommitPackage)EPackage.Registry.INSTANCE.getEPackage(CommitPackage.eNS_URI);
		AuthorPackage theAuthorPackage = (AuthorPackage)EPackage.Registry.INSTANCE.getEPackage(AuthorPackage.eNS_URI);
		VersioningPackage theVersioningPackage = (VersioningPackage)EPackage.Registry.INSTANCE.getEPackage(VersioningPackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		userBranchEClass.getESuperTypes().add(this.getBranch());
		masterBranchEClass.getESuperTypes().add(this.getBranch());
		branchEClass.getESuperTypes().add(theVersioningPackage.getNamed());

		// Initialize classes, features, and operations; add parameters
		initEClass(branchDiffCreatorEClass, BranchDiffCreator.class, "BranchDiffCreator", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getBranchDiffCreator_Source(), this.getUserBranch(), null, "source", null, 1, 1, BranchDiffCreator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getBranchDiffCreator_Target(), this.getUserBranch(), null, "target", null, 1, 1, BranchDiffCreator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEOperation(getBranchDiffCreator__CreateVersionDiff(), this.getBranchDiff(), "createVersionDiff", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(branchDiffEClass, BranchDiff.class, "BranchDiff", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getBranchDiff_SourceCommits(), theCommitPackage.getCommit(), null, "sourceCommits", null, 0, -1, BranchDiff.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getBranchDiff_TargetCommits(), theCommitPackage.getCommit(), null, "targetCommits", null, 0, -1, BranchDiff.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getBranchDiff_Source(), this.getUserBranch(), null, "source", null, 1, 1, BranchDiff.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getBranchDiff_Target(), this.getUserBranch(), null, "target", null, 1, 1, BranchDiff.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getBranchDiff_LastCommonAncestor(), theCommitPackage.getCommit(), null, "lastCommonAncestor", null, 1, 1, BranchDiff.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(userBranchEClass, UserBranch.class, "UserBranch", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getUserBranch_Owner(), theAuthorPackage.getAuthor(), theAuthorPackage.getAuthor_OwnedBranches(), "owner", null, 1, 1, UserBranch.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getUserBranch_BranchedFrom(), this.getBranch(), this.getBranch_ChildBranches(), "branchedFrom", null, 1, 1, UserBranch.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(masterBranchEClass, MasterBranch.class, "MasterBranch", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(branchEClass, Branch.class, "Branch", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getBranch_CurrentHeadCommit(), theCommitPackage.getCommit(), null, "currentHeadCommit", null, 1, 1, Branch.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getBranch_Contributors(), theAuthorPackage.getAuthor(), theAuthorPackage.getAuthor_ContributedBranches(), "contributors", null, 0, -1, Branch.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getBranch_ChildBranches(), this.getUserBranch(), this.getUserBranch_BranchedFrom(), "childBranches", null, 0, -1, Branch.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
	}

} //BranchPackageImpl
