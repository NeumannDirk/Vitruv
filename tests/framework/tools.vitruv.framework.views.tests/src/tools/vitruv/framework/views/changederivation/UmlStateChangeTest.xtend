package tools.vitruv.framework.views.changederivation

import org.eclipse.emf.compare.utils.UseIdentifiers
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.EnumSource
import org.junit.jupiter.params.provider.MethodSource

import static tools.vitruv.testutils.metamodels.UmlMockupCreators.uml

class UmlStateChangeTest extends StateChangePropagationTest {
	@ParameterizedTest(name = "{1}")
	@MethodSource("strategiesToTest")
	def void testRenameTypes(StateBasedChangeResolutionStrategy strategyToTest, String strategyName) {
		umlRoot.classes.get(0) => [name = "RenamedClass"]
		umlRoot.interfaces.get(0) => [name = "RenamedInterface"]
		compareChanges(umlModel, umlCheckpoint, strategyToTest)
	}

	@ParameterizedTest(name = "{0}")
	@EnumSource(
	    value = UseIdentifiers,
	    //TODO: should be re-enabled when state comparison is used instead of change comparison
	    names = #["ONLY"],
	    mode = EnumSource.Mode.EXCLUDE
	)
	def void testNewAttributes(UseIdentifiers useIdentifiers) {
	    val strategyToTest = new DefaultStateBasedChangeResolutionStrategy(useIdentifiers)
		umlRoot.classes.get(0) => [
			attributes += uml.Attribute => [attributeName = "NewlyAddedAttribute"]
		]
		compareChanges(umlModel, umlCheckpoint, strategyToTest)
	}

	@ParameterizedTest(name = "{1}")
	@MethodSource("strategiesToTest")
	def void testNewMethod(StateBasedChangeResolutionStrategy strategyToTest, String strategyName) {
		umlRoot.interfaces.get(0) => [
			methods += uml.Method => [name = "NewlyAddedMethod"]
		]
		compareChanges(umlModel, umlCheckpoint, strategyToTest)
	}

	@ParameterizedTest(name = "{1}")
	@MethodSource("strategiesToTest")
	def void testNewClass(StateBasedChangeResolutionStrategy strategyToTest, String strategyName) {
		umlRoot.classes += uml.Class => [name = "NewlyAddedClass"]
		compareChanges(umlModel, umlCheckpoint, strategyToTest)
	}

	@ParameterizedTest(name = "{0}")
    @EnumSource(
        value = UseIdentifiers,
        //TODO: should be re-enabled when state comparison is used instead of change comparison
        names = #["NEVER"],
        mode = EnumSource.Mode.EXCLUDE
    )
	def void testReplaceClass(UseIdentifiers useIdentifiers) {
	    val strategyToTest = new DefaultStateBasedChangeResolutionStrategy(useIdentifiers)
		umlRoot.classes.remove(0)
		umlRoot.classes += uml.Class => [name = "NewlyAddedClass"]
		compareChanges(umlModel, umlCheckpoint, strategyToTest)
	}

	@ParameterizedTest(name = "{1}")
	@MethodSource("strategiesToTest")
	def void testDeleteClass(StateBasedChangeResolutionStrategy strategyToTest, String name) {
		umlRoot.classes.remove(0)
		compareChanges(umlModel, umlCheckpoint, strategyToTest)
	}

	@ParameterizedTest(name = "{1}")
	@MethodSource("strategiesToTest")
	def void testNewInterface(StateBasedChangeResolutionStrategy strategyToTest, String strategyName) {
		umlRoot.interfaces += uml.Interface => [name = "NewlyAddedInterface"]
		compareChanges(umlModel, umlCheckpoint, strategyToTest)
	}
}
