package tools.vitruv.framework.tests.matchers

import org.eclipse.emf.ecore.EObject
import org.hamcrest.Description
import org.hamcrest.Matcher
import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.xtend.lib.annotations.FinalFieldsConstructor
import java.util.Collection
import java.util.Stack
import org.hamcrest.TypeSafeMatcher
import java.util.function.Consumer
import java.util.Map
import java.util.HashMap
import edu.kit.ipd.sdq.activextendannotations.Utility
import java.util.Collections

@Utility
class ModelMatchers {
	def static Matcher<Resource> contains(EObject root) {
		new ResourceContainmentMatcher(root)
	}

	def static Matcher<EObject> equalsDeeply(EObject object) {
		new ModelTreeEqualityMatcher(object)
	}
}

package class ResourceContainmentMatcher extends TypeSafeMatcher<Resource> {
	val Matcher<EObject> delegateMatcher
	val EObject expectedObject
	int contentsSize
	boolean exists

	package new(EObject expectedObject) {
		this.expectedObject = expectedObject
		delegateMatcher = new ModelTreeEqualityMatcher(expectedObject)
	}

	override protected describeMismatchSafely(Resource item, Description mismatchDescription) {
		if (!exists) {
			mismatchDescription.appendText("there is no resource at ").appendValue(item.URI)
		} else if (contentsSize == 0) {
			mismatchDescription.appendText("the resource was empty.")
		} else if (contentsSize > 1) {
			mismatchDescription.appendText("the resource contained ").appendValue(contentsSize).appendText(
				" instead of just one content element.")
		} else {
			delegateMatcher.describeMismatch(expectedObject, mismatchDescription)
		}
	}

	override describeTo(Description description) {
		description.appendText("A resource containing the object tree rooted at ").appendValue(expectedObject);
	}

	override protected matchesSafely(Resource item) {
		exists = item.resourceSet.URIConverter.exists(item.URI, Collections.emptyMap)
		if (!exists) return false
		contentsSize = item.contents.size
		if (contentsSize != 1) return false
		return delegateMatcher.matches(item.contents.get(0))
	}

}

@FinalFieldsConstructor
package class ModelTreeEqualityMatcher extends TypeSafeMatcher<EObject> {

	package val EObject expectedObject
	var Stack<String> navigationStack = new Stack
	var Consumer<Description> mismatch
	var Map<Object, Object> checkCache = new HashMap

	override protected matchesSafely(EObject item) {
		return expectedObject.equalsDeeply(item)
	}

	def private dispatch boolean equalsDeeply(EObject expected, EObject item) {
		if (checkCache.get(item) == expected) {
			return true;
		}
		if (expected.eClass !== item.eClass) {
			mismatch = [
				appendText("had the wrong EClass. Expected ").appendValue(expected.eClass.name).appendText(
					" but found ").appendValue(item.eClass.name).appendText(".")
			]
			return false
		}
		for (feature : expected.eClass.EAllStructuralFeatures) {
			navigationStack.push('''.«feature.name»''')
			if (!expected.eGet(feature).equalsDeeply(item.eGet(feature))) {
				return false;
			}
			navigationStack.pop()
		}
		checkCache.put(item, expected);
		return true;
	}

	def private dispatch boolean equalsDeeply(Collection<?> expected, Collection<?> item) {
		if (expected.size() > item.size()) {
			return false;
		} else if (expected.size() < item.size()) {
			return false;
		} else {
			var count = 0;
			val expectedIter = expected.iterator()
			val itemIter = item.iterator()
			while (expectedIter.hasNext()) {
				navigationStack.push('''[«count++»]''')
				if (!expectedIter.next.equalsDeeply(itemIter.next)) {
					return false;
				}
				navigationStack.pop()
			}
		}
		return true
	}

	def private dispatch boolean equalsDeeply(Object expected, Object item) {
		if (expected != item) {
			equalityMismatch(expected, item)
			return false
		}
		return true
	}

	def private dispatch boolean equalsDeeply(Void expected, Object item) {
		equalityMismatch(expected, item)
		false
	}

	def private dispatch boolean equalsDeeply(Object expected, Void item) {
		equalityMismatch(expected, item)
		false
	}

	def private dispatch boolean equalsDeeply(Void expected, Void item) {
		true
	}

	def private equalityMismatch(Object expected, Object item) {
		mismatch = [
			appendText("had the wrong value. Expected ").appendValue(expected).appendText(" but found ").
				appendValue(item)
		]
	}

	override describeTo(Description description) {
		description.appendText("An EObject deeply equal to ").appendValue(expectedObject);
	}

	override protected describeMismatchSafely(EObject item, Description mismatchDescription) {
		if (navigationStack.isEmpty) {
			mismatchDescription.appendText("The EObject ")
		} else {
			mismatchDescription.appendText('''The element at object«navigationStack.join» ''')
		}
		mismatch.accept(mismatchDescription)
	}

}
