/*
 * generated by Xtext
 */
package edu.kit.ipd.sdq.vitruvius.framework.mir.ui;

import org.eclipse.xtext.ui.guice.AbstractGuiceAwareExecutableExtensionFactory;
import org.osgi.framework.Bundle;

import com.google.inject.Injector;

import edu.kit.ipd.sdq.vitruvius.framework.mir.ui.internal.MIRActivator;

/**
 * This class was generated. Customizations should only happen in a newly
 * introduced subclass. 
 */
public class MIRExecutableExtensionFactory extends AbstractGuiceAwareExecutableExtensionFactory {

	@Override
	protected Bundle getBundle() {
		return MIRActivator.getInstance().getBundle();
	}
	
	@Override
	protected Injector getInjector() {
		return MIRActivator.getInstance().getInjector(MIRActivator.EDU_KIT_IPD_SDQ_VITRUVIUS_FRAMEWORK_MIR_MIR);
	}
	
}
