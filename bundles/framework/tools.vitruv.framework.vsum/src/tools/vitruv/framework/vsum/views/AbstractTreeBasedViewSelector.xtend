package tools.vitruv.framework.vsum.views

import org.eclipse.emf.ecore.EObject

abstract class AbstractTreeBasedViewSelector extends BasicViewSelector implements TreeBasedViewSelector {
    val EObject root

    new(EObject root, ViewType owner) {
        super(owner)
        this.root = root
        addRecursively(root)
    }

    override getRoot() {
        return root
    }

    def private void addRecursively(EObject parent) {
        selectableElements.add(new SelectableElement(parent))
        parent.children.forEach[addRecursively]
    }

}
