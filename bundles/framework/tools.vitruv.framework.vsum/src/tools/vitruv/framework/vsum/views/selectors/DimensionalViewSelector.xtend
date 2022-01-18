package tools.vitruv.framework.vsum.views.selectors

import org.eclipse.emf.ecore.EObject
import tools.vitruv.framework.vsum.views.ViewSelector

/**
 * {@linkplain ViewSelector} that offers several dimensions in which a selection can be made to select a specific view.
 */
interface DimensionalViewSelector extends ViewSelector {
    def Iterable<ViewDimension> getDimensions()

    def Iterable<EObject> getElementsFor(ViewDimension dimension)

    def void setSelected(ViewDimension dimension, EObject element, boolean value)
}
