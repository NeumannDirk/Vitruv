package tools.vitruv.dsls.mappings.tests.addressesXrecipients.mappings.halves

import tools.vitruv.extensions.dslsruntime.mappings.MappingInstanceHalf
import edu.kit.ipd.sdq.mdsd.recipients.Recipients
import org.eclipse.xtend.lib.annotations.Data

@Data class RightAdRootXReRootInstanceHalf extends MappingInstanceHalf {
	Recipients rRoot
	
	override getElements() {
		return #[rRoot]
	}
}