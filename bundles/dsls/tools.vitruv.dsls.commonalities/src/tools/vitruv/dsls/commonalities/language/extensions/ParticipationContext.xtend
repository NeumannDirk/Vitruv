package tools.vitruv.dsls.commonalities.language.extensions

import edu.kit.ipd.sdq.activextendannotations.Lazy
import java.util.Collections
import java.util.List
import org.eclipse.xtend.lib.annotations.Accessors
import org.eclipse.xtend.lib.annotations.Data
import org.eclipse.xtend.lib.annotations.FinalFieldsConstructor
import org.eclipse.xtend.lib.annotations.ToString
import tools.vitruv.dsls.commonalities.language.Participation
import tools.vitruv.dsls.commonalities.language.ParticipationClass

import static extension tools.vitruv.dsls.commonalities.language.extensions.CommonalitiesLanguageModelExtensions.*
import static extension tools.vitruv.dsls.commonalities.language.extensions.ParticipationContextHelper.*

/**
 * Represents a participation in the context of a specific containment
 * hierarchy.
 * <p>
 * If a commonality is referenced by other commonalities, its participations
 * need to be matched in differently rooted containment hierarchies: A
 * participation may specify an own containment hierarchy that roots inside a
 * <code>Resource</code>, and/or it may be referenced by external commonality
 * reference mappings, which each specify different root containers for the
 * participation's non-root objects. This class represents the participation
 * adapted to one of those various contexts.
 * <p>
 * For a commonality participation in its own context the root is empty, since
 * the participation objects are implicitly contained inside their intermediate
 * model's root.
 */
@FinalFieldsConstructor
@ToString
class ParticipationContext {

	enum ParticipationClassRole {
		EXTERNAL_ROOT,
		ROOT,
		NON_ROOT
	}

	/**
	 * A ParticipationClass with its context specific role.
	 */
	@Data
	static class ContextClass {

		val ParticipationClass participationClass
		val ParticipationClassRole role

		def isRootClass() {
			return (role == ParticipationClassRole.ROOT
				|| role == ParticipationClassRole.EXTERNAL_ROOT)
		}

		/**
		 * Returns whether the ParticipationClass belongs to an external
		 * participation, i.e. to the referencing participation if the
		 * participation context is for a reference mapping.
		 * <p>
		 * Note that if a commonality references itself, its participations act
		 * both as referencing and as referenced participation. In that case,
		 * the participation context may contain multiple ContextClasses for
		 * the same ParticipationClass, once for the 'external' and once for
		 * the non-external role.
		 */
		def isExternal() {
			return (role == ParticipationClassRole.EXTERNAL_ROOT)
		}
	}

	@Data
	static class ContextContainment {
		val ContextClass contained
		val ContextClass container
		val Containment containment
	}

	@Accessors(PUBLIC_GETTER)
	val Participation participation
	@Accessors(PUBLIC_GETTER)
	val ParticipationRoot root // not null
	@Lazy val List<ContextClass> rootClasses = calculateRootClasses()
	@Lazy val List<ContextClass> nonRootClasses = calculateNonRootClasses()
	@Lazy val List<ContextContainment> rootContainments = calculateRootContainments()
	@Lazy val List<ContextContainment> boundaryContainments = calculateBoundaryContainments()
	@Lazy val List<ContextContainment> nonRootContainments = calculateNonRootContainments()

	private def calculateRootClasses() {
		return Collections.unmodifiableList(root.classes.map [
			val role = (isForReferenceMapping) ? ParticipationClassRole.EXTERNAL_ROOT : ParticipationClassRole.ROOT
			new ContextClass(it, role)
		].toList)
	}

	private def calculateNonRootClasses() {
		return Collections.unmodifiableList(participation.nonRootClasses.map [
			new ContextClass(it, ParticipationClassRole.NON_ROOT)
		].toList)
	}

	private def getRootClass(ParticipationClass participationClass) {
		return rootClasses.findFirst[it.participationClass == participationClass]
	}

	private def getNonRootClass(ParticipationClass participationClass) {
		return nonRootClasses.findFirst[it.participationClass == participationClass]
	}

	private def calculateRootContainments() {
		return Collections.unmodifiableList(root.rootContainments.map [
			new ContextContainment(contained.rootClass, container.rootClass, it)
		].toList)
	}

	private def calculateBoundaryContainments() {
		return Collections.unmodifiableList(root.boundaryContainments.map [
			new ContextContainment(contained.nonRootClass, container.rootClass, it)
		].toList)
	}

	private def calculateNonRootContainments() {
		return Collections.unmodifiableList(participation.nonRootContainments.map [
			new ContextContainment(contained.nonRootClass, container.nonRootClass, it)
		].toList)
	}

	def isRootContext() {
		return !isForReferenceMapping
	}

	def isForSingletonRoot() {
		return (isRootContext && participation.hasSingletonClass)
	}

	def isForReferenceMapping() {
		return (referenceMapping !== null)
	}

	def getReferenceMapping() {
		return root.referenceMapping
	}

	def getReferencingCommonality() {
		return referenceMapping?.containingCommonality
	}

	/**
	 * Note: In the context of an external reference mapping, this may include
	 * participation classes that originate from an external participation. If
	 * the referenced commonality is the referencing commonality itself (eg. a
	 * Package commonality containing other packages as subpackages), the same
	 * participation class may act as both root and non-root class.
	 */
	def getClasses() {
		return rootClasses + nonRootClasses
	}

	/**
	 * Gets all participation classes that are managed by the corresponding
	 * Intermediate.
	 * <p>
	 * In the context of a reference mapping this does not include the
	 * context's root container (since that is managed by another
	 * Intermediate). For non-reference participation contexts it does include
	 * the root Resource container class. If the participation has a singleton
	 * root, the singleton class and its containers are not included.
	 */
	def getManagedClasses() {
		if (forReferenceMapping) {
			return classes.filter[!isRootContainerClass]
		} else if (isForSingletonRoot) {
			return nonRootClasses
		} else {
			return classes
		}
	}

	def getRootContainerClass() {
		return rootClasses.last
	}

	def isRootContainerClass(ContextClass contextClass) {
		return (contextClass == rootContainerClass)
	}

	def getContainments() {
		return rootContainments + boundaryContainments + nonRootContainments
	}

	/**
	 * Gets all containments that this participation context is responsible
	 * for.
	 * <p>
	 * I.e. this omits the root containments if this context is for a singleton
	 * root.
	 */
	def getManagedContainments() {
		if (isForSingletonRoot) {
			// Omit the root containments, since those are handled by the singleton root:
			return boundaryContainments + nonRootContainments
		} else {
			return containments
		}
	}
}
