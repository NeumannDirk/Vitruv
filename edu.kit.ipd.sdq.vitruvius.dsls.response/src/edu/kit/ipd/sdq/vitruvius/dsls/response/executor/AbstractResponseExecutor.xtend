package edu.kit.ipd.sdq.vitruvius.dsls.response.executor

import org.apache.log4j.Logger
import java.util.List
import org.eclipse.emf.common.command.Command
import edu.kit.ipd.sdq.vitruvius.framework.contracts.util.bridges.EMFCommandBridge
import java.util.ArrayList
import edu.kit.ipd.sdq.vitruvius.dsls.response.generator.ResponseRealization
import edu.kit.ipd.sdq.vitruvius.framework.meta.change.EChange

abstract class AbstractResponseExecutor  {
	private final static val LOGGER = Logger.getLogger(AbstractResponseExecutor);

	private Change2ResponseMap changeToResponseMap;

	new () {
		this.changeToResponseMap = new Change2ResponseMap();
		this.setup();
	}

	protected def void addResponse(Class<? extends EChange> eventType, ResponseRealization response) {
		this.changeToResponseMap.addResponse(eventType, response);
	}
	
	public def List<Command> generateCommandsForEvent(EChange event) {
		return handleEvent(event);
	}

	protected def List<Command> callRelevantResponses(EChange event) {
		val result = new ArrayList<Command>();
		val relevantResponses = this.changeToResponseMap.getResponses(event);
		LOGGER.debug("call relevant responses");
		for (response : relevantResponses) {
			LOGGER.debug(response.toString());
			result.add(EMFCommandBridge
					.createVitruviusTransformationRecordingCommand([| response.applyEvent(event)]) as Command);
		}
		return result;
	}

	protected def List<Command> handleEvent(EChange event) {
		return this.callRelevantResponses(event);
	}

	protected def void setup();
}