/*
 * generated by Xtext 2.9.1
 */
package edu.kit.ipd.sdq.vitruvius.dsls.mapping.ui.tests;

import com.google.inject.Injector;
import edu.kit.ipd.sdq.vitruvius.dsls.mapping.ui.internal.MappingActivator;
import org.eclipse.xtext.junit4.IInjectorProvider;

public class MappingLanguageUiInjectorProvider implements IInjectorProvider {

	@Override
	public Injector getInjector() {
		return MappingActivator.getInstance().getInjector("edu.kit.ipd.sdq.vitruvius.dsls.mapping.MappingLanguage");
	}

}
