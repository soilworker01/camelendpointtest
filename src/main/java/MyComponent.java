import java.util.Map;

import org.apache.camel.Endpoint;
import org.apache.camel.support.DefaultComponent;

public class MyComponent extends DefaultComponent {

	@Override
	protected Endpoint createEndpoint(String uri, String remaining, Map<String, Object> parameters) throws Exception {
		String address = getAndRemoveParameter(parameters, "address",
				String.class);

		String username = getAndRemoveParameter(parameters, "username",
				String.class);

		Endpoint endpoint = new MyEndpoint(uri, this,
				new MyProcessor(address, username));
		setProperties(endpoint, parameters);
		return endpoint;
	}

}
