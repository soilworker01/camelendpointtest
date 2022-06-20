import org.apache.camel.Exchange;
import org.apache.camel.test.junit5.CamelTestSupport;
import org.junit.jupiter.api.Test;

public class MyTest extends CamelTestSupport {

	@Test
	public void test() {
		
		
		Exchange exchange = this.createExchangeWithBody(null);
		
		exchange.getIn().setHeader("username", "user1");
		exchange.getIn().setHeader("address", "address1");

		template.send("my://test?username=${header.username}&address=${header.address}", exchange);

		Exchange exchange2 = this.createExchangeWithBody(null);
		exchange2.getIn().setHeader("username", "user2");
		exchange2.getIn().setHeader("address", "address2");

		template.send("my://test?username=${header.username}&address=${header.address}", exchange2);
	}
}
