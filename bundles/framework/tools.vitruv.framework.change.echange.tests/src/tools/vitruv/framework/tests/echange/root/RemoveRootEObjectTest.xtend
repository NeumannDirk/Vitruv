package tools.vitruv.framework.tests.echange.root

import allElementTypes.Root
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import tools.vitruv.framework.change.echange.TypeInferringAtomicEChangeFactory
import tools.vitruv.framework.change.echange.root.RemoveRootEObject
import tools.vitruv.framework.change.echange.util.EChangeUtil

/**
 * Test class for the concrete {@link RemoveRootEObject} EChange,
 * which removes a root element from a resource.
 */
class RemoveRootEObjectTest extends RootEChangeTest {
	protected static val DEFAULT_INDEX = 2;
	
	/**
	 * Inserts new root objects into the resource
	 * to remove them in the tests.
	 */
	@Before
	override public void beforeTest()  {
		super.beforeTest()
		resource1.contents.add(DEFAULT_INDEX, newRootObject)
		resource1.contents.add(DEFAULT_INDEX + 1, newRootObject2)
	}
	
	/**
	 * Test resolves a {@link RemoveRootEObject} EChange, with a root 
	 * object already in the resource. This happens when the model is
	 * in state before the change is applied forward.
	 */
	@Test
	def public void resolveRemoveRootEObjectTest() {	
		val unresolvedChange = TypeInferringAtomicEChangeFactory.
			<Root>createRemoveRootChange(newRootObject, fileUri.toString, DEFAULT_INDEX, true)
			
		Assert.assertFalse(unresolvedChange.isResolved)
		Assert.assertNull(unresolvedChange.resource)
		Assert.assertTrue(unresolvedChange.oldValue != newRootObject)
		Assert.assertTrue(stagingArea1.contents.empty)
		
		// New root object is already in resource so it can be resolved
		val resolvedChange = unresolvedChange.copyAndResolveBefore(resourceSet1) as RemoveRootEObject<Root>
		
		Assert.assertTrue(resolvedChange.isResolved)
		Assert.assertTrue(resolvedChange != unresolvedChange)
		Assert.assertTrue(resolvedChange.oldValue == newRootObject)
		Assert.assertTrue(resolvedChange.resource.resourceSet == resourceSet1)
		Assert.assertTrue(resolvedChange.resource == resolvedChange.oldValue.eResource)
		Assert.assertTrue(stagingArea1.contents.empty)
	}
	
	/**
	 * Test resolves a {@link RemoveRootEObject} EChange, with a root
	 * object in the staging area. This happens when the model is
	 * in state after the change was applied.
	 */
	 @Test
	 def public void resolveRemoveRootEObjectTest2() {
	 	resource1.contents.remove(newRootObject)
	 	
	 	prepareStagingArea(newRootObject)
	 	
	 	Assert.assertFalse(stagingArea1.contents.empty)
	 	
	 	val unresolvedChange = TypeInferringAtomicEChangeFactory.
			<Root>createRemoveRootChange(newRootObject, fileUri.toString, DEFAULT_INDEX, true)

		Assert.assertFalse(unresolvedChange.isResolved)
		Assert.assertNull(unresolvedChange.resource)
		Assert.assertTrue(unresolvedChange.oldValue != newRootObject)
		Assert.assertFalse(stagingArea1.contents.empty)
		Assert.assertTrue(stagingArea1.contents.contains(newRootObject))
		
		val resolvedChange = unresolvedChange.copyAndResolveAfter(resourceSet1) as RemoveRootEObject<Root>
		
		Assert.assertTrue(resolvedChange.isResolved)
		Assert.assertTrue(resolvedChange != unresolvedChange)
		Assert.assertTrue(resolvedChange.oldValue == newRootObject)	
		Assert.assertTrue(resolvedChange.resource.resourceSet == resourceSet1)	
		Assert.assertTrue(stagingArea1 == resolvedChange.oldValue.eResource)
		Assert.assertFalse(stagingArea1.contents.empty)
		Assert.assertTrue(stagingArea1.contents.contains(newRootObject))
	 }
	
	/**
	 * Tests whether resolving the {@link RemoveRootEObject} EChange
	 * returns the same class.
	 */
	@Test
	def public void resolveToCorrectType() {		
		val unresolvedChange = TypeInferringAtomicEChangeFactory.
			<Root>createRemoveRootChange(newRootObject, fileUri.toString, DEFAULT_INDEX, true)
			
		val resolvedChange = unresolvedChange.copyAndResolveBefore(resourceSet1)
		
		assertDifferentChangeSameClass(unresolvedChange, resolvedChange)
	}
	
	/**
	 * Tests applying the {@link RemoveRootEObject} EChange 
	 * by removing two root elements from a resource.
	 */
	@Test
	def public void removeRootEObjectApplyForwardTest() {
		val oldSize = resourceContent.size
	
		// Remove first root element (newRootObject at index 2)
		val resolvedChange = TypeInferringAtomicEChangeFactory.
			<Root>createRemoveRootChange(newRootObject, fileUri.toString, DEFAULT_INDEX, true).
			copyAndResolveBefore(resourceSet1) as RemoveRootEObject<Root>
			
		Assert.assertTrue(stagingArea1.contents.empty)	
				
		Assert.assertTrue(resolvedChange.applyForward)
		
		Assert.assertEquals(resourceContent.size, oldSize - 1)
		Assert.assertTrue(resolvedChange.oldValue == newRootObject)
		Assert.assertFalse(resourceContent.contains(resolvedChange.oldValue))
		Assert.assertFalse(stagingArea1.contents.empty)
		Assert.assertTrue(stagingArea1.contents.contains(newRootObject))
		
		// Now the element is deleted or inserted again.
		stagingArea1.contents.clear()
		
		// Remove second root element (newRootObject2 now at index 2)
		val resolvedChange2 = TypeInferringAtomicEChangeFactory.
			<Root>createRemoveRootChange(newRootObject2, fileUri.toString, DEFAULT_INDEX, true).
			copyAndResolveBefore(resourceSet1) as RemoveRootEObject<Root>
		
		Assert.assertTrue(stagingArea1.contents.empty)
		
		Assert.assertTrue(resolvedChange2.applyForward)
		
		Assert.assertEquals(resourceContent.size, oldSize - 2)
		Assert.assertTrue(resolvedChange2.oldValue == newRootObject2)
		Assert.assertFalse(resourceContent.contains(resolvedChange2.oldValue))
	}
	
	/**
	 * Tests applying two {@link RemoveRootEObject} EChanges
	 * by inserts two removed root objects in a resource.
	 */
	@Test
	def public void removeRootEObjectApplyBackwardTest() {
		val beforeRemoveSize = resourceContent.size
		val indexRoot1 = resourceContent.indexOf(newRootObject)
		val indexRoot2 = resourceContent.indexOf(newRootObject2)
		
		// Remove first root element
		val resolvedChange = TypeInferringAtomicEChangeFactory.
			<Root>createRemoveRootChange(newRootObject, fileUri.toString, DEFAULT_INDEX, true).
			copyAndResolveBefore(resourceSet1) as RemoveRootEObject<Root>
	
		Assert.assertTrue(resolvedChange.applyForward)
		
		stagingArea1.contents.clear()
		
		// Remove second root element 
		val resolvedChange2 = TypeInferringAtomicEChangeFactory.
			<Root>createRemoveRootChange(newRootObject2, fileUri.toString, DEFAULT_INDEX, true).
			copyAndResolveBefore(resourceSet1) as RemoveRootEObject<Root>
		
		Assert.assertTrue(resolvedChange2.applyForward)
		
		Assert.assertEquals(resourceContent.size, beforeRemoveSize - 2)
		Assert.assertFalse(resourceContent.contains(newRootObject))
		Assert.assertFalse(resourceContent.contains(newRootObject2))
		
		// Revert second change
		Assert.assertTrue(resolvedChange2.applyBackward)
		
		Assert.assertEquals(resourceContent.size, beforeRemoveSize - 1)
		Assert.assertTrue(resourceContent.contains(newRootObject2))
		
		// Revert first change
		Assert.assertTrue(resolvedChange.applyBackward)
		Assert.assertEquals(resourceContent.size, beforeRemoveSize)
		Assert.assertTrue(resourceContent.contains(newRootObject))
		
		// At same index
		Assert.assertEquals(resourceContent.indexOf(newRootObject), indexRoot1)
		Assert.assertEquals(resourceContent.indexOf(newRootObject2), indexRoot2)
	}
	
	/**
	 * Tests a {@link RemoveRootEObject} EChange with invalid index.
	 */
	@Test
	def public void removeRootEObjectInvalidIndex() {
		prepareStagingArea(newRootObject)
		val index = 5
		
		Assert.assertTrue(resourceContent.size < index)
		
		val resolvedChange = TypeInferringAtomicEChangeFactory.
			<Root>createRemoveRootChange(newRootObject, fileUri.toString, index, true).
			copyAndResolveAfter(resourceSet1) as RemoveRootEObject<Root> 
			
		Assert.assertTrue(resolvedChange.isResolved)
		Assert.assertFalse(resolvedChange.applyBackward)
	}
}