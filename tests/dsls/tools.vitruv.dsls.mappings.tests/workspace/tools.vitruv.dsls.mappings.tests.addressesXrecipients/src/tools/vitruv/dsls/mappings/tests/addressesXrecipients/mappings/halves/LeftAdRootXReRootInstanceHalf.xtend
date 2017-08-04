package tools.vitruv.dsls.mappings.tests.addressesXrecipients.mappings.halves

import edu.kit.ipd.sdq.mdsd.addresses.Addresses
import tools.vitruv.extensions.dslsruntime.mappings.MappingInstanceHalf
import org.eclipse.xtend.lib.annotations.Data

@Data class LeftAdRootXReRootInstanceHalf extends MappingInstanceHalf {
	Addresses aRoot
	
	override getElements() {
		return #[aRoot]
	}	
}