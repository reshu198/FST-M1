package examples;


import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.Matchers.lessThanOrEqualTo;
import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class  SpecificationTest{
	RequestSpecification requestSpec;
	ResponseSpecification responseSpec;
	int petID = 0 ;
	
	@BeforeClass
	public void SetUp() {
		//Request Specification
		requestSpec = new RequestSpecBuilder().
				setBaseUri("https://petstore.swagger.io/v2/pet").
				addHeader("Content-type", "application/json").
				build();
		
		//Response Specification
		responseSpec = new ResponseSpecBuilder().
				expectStatusCode(200).
				expectResponseTime(lessThanOrEqualTo(3000L)).
				build();
		
		
	}
	
	@Test(priority = 1)
	public void postRequest() {
		Map<String, Object> reqBody = new HashMap<>();
		reqBody.put("id", 77232);
		reqBody.put("name", "Riley");
		reqBody.put("status", "alive");

		Response response = given()
			.baseUri("https://petstore.swagger.io/v2/pet") // Set base URI
			.header("Content-Type", "application/json") // Set headers
			.body(reqBody) // Add request body
			.when().post(); // Send POST request

		petID = response.then().extract().path("id");
		
		// Assertion
		response.then().spec(responseSpec).body("name", equalTo("Riley"));

	}
	@Test(priority = 2)
	public void getRequest() {
		given().spec(requestSpec).pathParam("petId", petID).
		when().get("/{petId}").
		then().spec(responseSpec).body("status", equalTo("alive"));

		
	}

	@Test(priority = 3)
	public void deleteRequest() {
		given().spec(requestSpec).pathParam("petId", petID).
		when().delete("/{petId}").
		then().spec(responseSpec).body("message", equalTo(""+ petID));
		
	}
}
