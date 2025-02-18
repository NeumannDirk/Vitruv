package tools.vitruv.framework.tests.change.reference

import java.util.stream.Stream
import static java.util.stream.StreamSupport.stream
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import tools.vitruv.framework.change.echange.EChange
import tools.vitruv.framework.tests.change.ChangeDescription2ChangeTransformationTest

import static allElementTypes.AllElementTypesPackage.Literals.*
import static org.junit.jupiter.api.Assertions.assertEquals
import static tools.vitruv.testutils.metamodels.AllElementTypesCreators.*

import static extension edu.kit.ipd.sdq.commons.util.java.lang.IterableUtil.mapFixed
import static extension tools.vitruv.framework.tests.change.util.AtomicEChangeAssertHelper.*
import static extension tools.vitruv.framework.tests.change.util.CompoundEChangeAssertHelper.*
import java.util.ArrayList
import tools.vitruv.framework.change.echange.EChangeUtil

class ChangeDescription2InsertEReferenceTest extends ChangeDescription2ChangeTransformationTest { 

	
	final static int NUM_PREPARATION_ELEMENTS = 10;

	@ParameterizedTest
	@MethodSource("provideParametersInsertMultipleAtOnceAtIndex")
	def void testInsertMultipleAtOnceContainment(int count, int insertAt) {
		// prepare
		val preparationElements = (0 ..< NUM_PREPARATION_ELEMENTS).map[aet.NonRoot()]
		uniquePersistedRoot.record[multiValuedContainmentEReference.addAll(preparationElements)]

		// test
		val nonRootElements = (0 ..< count).mapFixed [
			val element = aet.NonRoot()
			element.id = it.toString()
			return element
		]
		var Iterable<? extends EChange> actualChanges = uniquePersistedRoot.record [
			multiValuedContainmentEReference.addAll(insertAt, nonRootElements)
		]

		// assert
		val expectedInsertions = 
			if (insertAt == NUM_PREPARATION_ELEMENTS) nonRootElements.mapFixed[new Pair(it, EChangeUtil.LAST_POSITION_INDEX)]
			else nonRootElements.indexed().mapFixed[new Pair(value, key + insertAt)]
		assertEquals(actualChanges.size, expectedInsertions.size * 3)
		for (insertion : expectedInsertions) {
			val nonRoot = insertion.key
			val insertAtIndex = insertion.value
			actualChanges = actualChanges //
				.assertCreateAndInsertNonRoot(uniquePersistedRoot, ROOT__MULTI_VALUED_CONTAINMENT_EREFERENCE, nonRoot, insertAtIndex, false) //
				.assertReplaceSingleValuedEAttribute(nonRoot, IDENTIFIED__ID, null, nonRoot.id, false, false)
		}
	}

	@ParameterizedTest
	@MethodSource("provideParametersInsertMultipleAtOnceAtIndex")
	def void testInsertMultipleAtOnceNonContainment(int count, int insertAt) {
		// prepare
		val preparationElements = (0 ..< NUM_PREPARATION_ELEMENTS).mapFixed[aet.NonRoot()]
		uniquePersistedRoot.multiValuedContainmentEReference.addAll(preparationElements)
		uniquePersistedRoot.multiValuedNonContainmentEReference.addAll(preparationElements)

		// test
		val nonRootElements = (0 ..< count).mapFixed[aet.NonRoot()]
		uniquePersistedRoot.multiValuedContainmentEReference.addAll(nonRootElements)
		var Iterable<? extends EChange> actualChanges = uniquePersistedRoot.record [
			multiValuedNonContainmentEReference.addAll(insertAt, nonRootElements)
		]

		// assert		
		val expectedInsertions = 
			if (insertAt == NUM_PREPARATION_ELEMENTS) nonRootElements.mapFixed[new Pair(it, EChangeUtil.LAST_POSITION_INDEX)]
			else nonRootElements.indexed().mapFixed[new Pair(value, key + insertAt)]
		assertEquals(actualChanges.size, expectedInsertions.size)
		for (insertion : expectedInsertions) {
			val nonRoot = insertion.key
			val insertAtIndex = insertion.value
			actualChanges = actualChanges //
				.assertInsertEReference(uniquePersistedRoot, ROOT__MULTI_VALUED_NON_CONTAINMENT_EREFERENCE, nonRoot, insertAtIndex, false, false)
		}
	}

	def static Stream<Arguments> provideParametersInsertMultipleAtOnceAtIndex() {
		val counts = #[2, 3, 5, 10]
		val insertionIndexes = #[0, 5, 10]
		return stream(insertionIndexes.map[index|counts.map[Arguments.of(it, index)]].flatten.spliterator, false)
	}

	@Test
	def void testInsertSingleNonContainment() {
		insertAndAssertSingleNonContainment(0, EChangeUtil.LAST_POSITION_INDEX)
	}

	@ParameterizedTest
	@MethodSource("provideParametersInsertElementOneByOne")
	def void testInsertMultipleIterativelyNonContainment(Iterable<Pair<Integer, Integer>> indecesPair) {
		// prepare
		val preparationElements = (0 ..< NUM_PREPARATION_ELEMENTS).mapFixed[aet.NonRoot()]
		uniquePersistedRoot.multiValuedContainmentEReference.addAll(preparationElements)
		uniquePersistedRoot.multiValuedNonContainmentEReference.addAll(preparationElements)

		for(var i = 0; i < indecesPair.size; i++) {
			insertAndAssertSingleNonContainment(indecesPair.get(i).key, indecesPair.get(i).value)
		}
	}

	@Test
	def void testInsertSingleContainment() {
		insertAndAssertSingleContainment(0, EChangeUtil.LAST_POSITION_INDEX)
	}

	@ParameterizedTest
	@MethodSource("provideParametersInsertElementOneByOne")
	def void testInsertMultipleIterativelyContainment(Iterable<Pair<Integer, Integer>> indecesPair) { 
		// prepare
		val preparationElements = (0 ..< NUM_PREPARATION_ELEMENTS).mapFixed[aet.NonRoot()]
		uniquePersistedRoot.multiValuedContainmentEReference.addAll(preparationElements)

		for(var i = 0; i < indecesPair.size; i++) {
			insertAndAssertSingleContainment(indecesPair.get(i).key, indecesPair.get(i).value)
		}
	}

	def static Stream<Arguments> provideParametersInsertElementOneByOne() {
		val testCases = new ArrayList<Iterable<Pair<Integer, Integer>>>()
		(0 ..< NUM_PREPARATION_ELEMENTS).forEach[testCases.add(#[new Pair(it, it)])]
		testCases.add(#[new Pair(0,0), new Pair(1,1), new Pair(2,2), new Pair(1,1)])
		testCases.add(#[new Pair(0,0), new Pair(1,1), new Pair(0,0), new Pair(2,2), new Pair(4,4)])
		testCases.add(#[new Pair(10, EChangeUtil.LAST_POSITION_INDEX)])
		testCases.add(#[new Pair(10,EChangeUtil.LAST_POSITION_INDEX), new Pair(10,10), new Pair(12,EChangeUtil.LAST_POSITION_INDEX)])
		testCases.add(#[new Pair(0,0), new Pair(11,EChangeUtil.LAST_POSITION_INDEX), new Pair(12,EChangeUtil.LAST_POSITION_INDEX)])
		return stream(testCases.map[Arguments.of(it)].spliterator, false)
	}

	def private void insertAndAssertSingleContainment(int insertAtIndex, int expectedEChangeIndex) {
		// prepare
		uniquePersistedRoot

		// test
		val nonRoot = aet.NonRoot
		val result = uniquePersistedRoot.record [
			multiValuedContainmentEReference.add(insertAtIndex, nonRoot)
		]

		// assert
		result.assertChangeCount(3)
			.assertCreateAndInsertNonRoot(uniquePersistedRoot, ROOT__MULTI_VALUED_CONTAINMENT_EREFERENCE, nonRoot, expectedEChangeIndex, false)
			.assertReplaceSingleValuedEAttribute(nonRoot, IDENTIFIED__ID, null, nonRoot.id, false, false)
			.assertEmpty
	}

	def private void insertAndAssertSingleNonContainment(int insertAtIndex, int expectedEChangeIndex) {
		// prepare
		val nonRoot = aet.NonRoot
		uniquePersistedRoot => [
			multiValuedContainmentEReference.add(insertAtIndex, nonRoot)
		]

		// test
		val result = uniquePersistedRoot.record [
			multiValuedNonContainmentEReference.add(insertAtIndex, nonRoot)
		]

		// assert
		result.assertChangeCount(1)
			.assertInsertEReference(uniquePersistedRoot, ROOT__MULTI_VALUED_NON_CONTAINMENT_EREFERENCE, nonRoot, expectedEChangeIndex, false, false)
			.assertEmpty
	}

}
