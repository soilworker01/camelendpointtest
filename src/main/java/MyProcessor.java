import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.spi.Language;

public class MyProcessor implements Processor {
	private String address;
	private String username;

	public MyProcessor(String address, String username) {
		this.address=address;
		this.username = username;
	}

	@Override
	public void process(Exchange exchange) throws Exception {
		Language simpleLanguage = exchange.getContext().resolveLanguage("simple");
		this.address = evaluateExpression(simpleLanguage, exchange, this.address);
		System.out.println(this.getClass() + " address " + this.address);
		this.username = evaluateExpression(simpleLanguage, exchange, this.username);
		System.out
				.println(this.getClass() + " username " + this.username);
	}

	private String evaluateExpression(Language language, Exchange exchange, String str) {
		if (language == null || str == null) {
			return str;
		}
		String evaluated = language.createExpression(str).evaluate(exchange, String.class);
		System.out.println(String.format("Evaluate expression %s -> %s", str, evaluated));
		return evaluated;
	}

}
