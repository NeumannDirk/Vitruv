package edu.kit.ipd.sdq.vitruvius.tests.framework.changedescription2change.util

import edu.kit.ipd.sdq.vitruvius.tests.framework.changedescription2change.ChangeDescription2ChangeTransformationTest

import static extension edu.kit.ipd.sdq.vitruvius.tests.framework.changedescription2change.util.ChangeAssertHelper.*

class ChangeDescription2ChangeTransformationTestUtil {
	private new() {
	}

	def public static testReplaceSingleValuedAttribute(ChangeDescription2ChangeTransformationTest test, int oldValue,
		int newValue) {
		// the test
		test.startRecording
		test.rootElement.singleValuedEAttribute = newValue

		// get the changes
		val changes = test.getChanges()

		// assert the changes
		changes.get(0).assertReplaceSingleValueEAttribute(oldValue, newValue)
	}

	def public static void testInsertEAttributeValue(
		ChangeDescription2ChangeTransformationTest changeDescription2Change, int expectedIndex, int expectedValue,
		int position) {
			// test
			var int index = expectedIndex
			changeDescription2Change.startRecording
			if(-1 == position){
				changeDescription2Change.rootElement.multiValuedEAttribute.add(expectedValue)
				index = changeDescription2Change.rootElement.multiValuedEAttribute.size - 1
			}else{
				changeDescription2Change.rootElement.multiValuedEAttribute.add(position, expectedValue)
			}

			// get changes
			val changes = changeDescription2Change.getChanges()

			// assert
			changes.assertInsertEAttribute(changeDescription2Change.rootElement,
				ChangeDescription2ChangeTransformationTest.MULTI_VALUE_E_ATTRIBUTE_NAME, expectedValue, index)
		}

	}
	