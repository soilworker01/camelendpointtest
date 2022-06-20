import org.apache.camel.Component;
import org.apache.camel.support.ProcessorEndpoint;

public class MyEndpoint extends ProcessorEndpoint {
	private MyProcessor myProcessor;


	public MyEndpoint(String endpointUri, Component component, MyProcessor processor) {
		super(endpointUri, component);
		this.myProcessor = processor;
		setProcessor(processor);
	}

	/**
	 * 
	 * @see org.apache.camel.support.ProcessorEndpoint#isSingleton()
	 */
	@Override
	public boolean isSingleton() {
		return false;
	}

	public MyProcessor getMyProcessor() {
		return this.myProcessor;
	}

	public void setMyProcessor(MyProcessor myProcessor) {
		this.myProcessor = myProcessor;
	}
}
