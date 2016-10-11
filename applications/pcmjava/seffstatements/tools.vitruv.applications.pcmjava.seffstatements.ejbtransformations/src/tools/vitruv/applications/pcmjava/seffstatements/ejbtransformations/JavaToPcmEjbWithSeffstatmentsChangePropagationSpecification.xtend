package tools.vitruv.applications.pcmjava.seffstatements.ejbtransformations

import tools.vitruv.applications.pcmjava.seffstatements.code2seff.Java2PcmMethodBodyChangePreprocessor
import tools.vitruv.applications.pcmjava.seffstatements.ejbtransformations.java2pcm.EJBJava2PCMCode2SEFFFactory
import tools.vitruv.applications.pcmjava.ejbtransformations.java2pcm.change2commandtransforming.JavaToPcmEjbChangePropagationSpecification

class JavaToPcmEjbWithSeffstatmentsChangePropagationSpecification extends JavaToPcmEjbChangePropagationSpecification {
	public override setup() {
		super.setup();
		addChangePreprocessor(new Java2PcmMethodBodyChangePreprocessor(userInteracting, new EJBJava2PCMCode2SEFFFactory));
	}
}