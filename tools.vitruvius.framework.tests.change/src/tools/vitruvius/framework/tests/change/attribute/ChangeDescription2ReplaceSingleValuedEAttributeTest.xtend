package tools.vitruvius.framework.tests.change.attribute

import tools.vitruvius.framework.tests.change.ChangeDescription2ChangeTransformationTest
import org.junit.Test

import static extension tools.vitruvius.framework.tests.change.util.ChangeDescription2ChangeTransformationTestUtil.*

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