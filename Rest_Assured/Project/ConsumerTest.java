package Project;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.lessThanOrEqualTo;
import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import au.com.dius.pact.consumer.dsl.DslPart;
import au.com.dius.pact.consumer.dsl.PactDslJsonBody;
import au.com.dius.pact.consumer.dsl.PactDslWithProvider;
import au.com.dius.pact.consumer.junit5.PactConsumerTestExt;
import au.com.dius.pact.consumer.junit5.PactTestFor;
import au.com.dius.pact.core.model.RequestResponsePact;
import au.com.dius.pact.core.model.annotations.Pact;
@ExtendWith(PactConsumerTestExt.class)
public class ConsumerTest {
	
	//Set the headers
	Map<String, String> headers = new HashMap<>();
	
	
	//Create the Contract(Pact)
	@Pact(consumer = "userConsumer", provider = "UserProvider")
	public RequestResponsePact createPact(PactDslWithProvider builder) {
	
	// Set the headers
	headers.put("Content-Type","application/json");
	
	//The request and response body
	DslPart reqResBody = new PactDslJsonBody().
			numberType("id", 190).
			stringType("firstName","Rashmi").
			stringType("lastName", "S").
			stringType("email","testassured@xyz.com");
	
	
	//Create the pact
	return builder.given("POST Request")
			.uponReceiving("A request to create a user")
			.method("POST")
			.path("/api/users")
			.headers(headers)
			.body(reqResBody)
			.willRespondWith()
			.status(201)
			.body(reqResBody)
			.toPact();			
		}
	
	//Consumer test with mock provider
	@Test
	@PactTestFor(providerName = "UserProvider" , port = "8282")
	public void postRequestTest() {
		Map<String, Object> reqBody = new HashMap<>();	
		reqBody.put("id", 190);
		reqBody.put("firstName","Rashmi");
		reqBody.put("lastName", "S");
		reqBody.put("email","testassured@xyz.com");
		
		
		//send request, get response, add assertions
		given().baseUri("http://localhost:8282/api/users").headers(headers).body(reqBody).log().all()
		.when().post()
		.then().statusCode(201).body("firstName",equalTo("Rashmi")).log().all();
	}
	
}