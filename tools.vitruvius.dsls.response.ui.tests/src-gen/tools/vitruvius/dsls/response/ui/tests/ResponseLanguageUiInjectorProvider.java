/*
 * generated by Xtext 2.10.0
 */
package tools.vitruvius.dsls.response.ui.tests;

import com.google.inject.Injector;
import tools.vitruvius.dsls.response.ui.internal.ResponseActivator;
import org.eclipse.xtext.junit4.IInjectorProvider;

public class ResponseLanguageUiInjectorProvider implements IInjectorProvider {

	@Override
	public Injector getInjector() {
		return ResponseActivator.getInstance().getInjector("tools.vitruvius.dsls.response.ResponseLanguage");
	}

}