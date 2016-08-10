package edu.kit.ipd.sdq.vitruvius.tests.framework.changes.changepreparer.attribute

import edu.kit.ipd.sdq.vitruvius.tests.framework.changes.changepreparer.ChangeDescription2ChangeTransformationTest
import org.junit.Test

import static extension edu.kit.ipd.sdq.vitruvius.tests.framework.changes.changepreparer.util.ChangeDescription2ChangeTransformationTestUtil.*

class ChangeDescription2ReplaceSingleValuedEAttributeTest extends ChangeDescription2ChangeTransformationTest {
	
	@Test
	def void testSetSingleValuedAttribute() {
		testReplaceSingleValuedAttribute(0, 42)
	}
	
	@Test
	def void testReplaceSingleValuedAttribute(){
		testSetSingleValuedAttribute()
		testReplaceSingleValuedAttribute(42, 21)
		testReplaceSingleValuedAttribute(21, 0)
	}
	
}