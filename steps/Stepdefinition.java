package steps;

import java.io.File;
import java.util.Map;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Stepdefinition {
	public static RequestSpecification inputRequest;
	public static Response response;

	@Given("Set the endpoint")
	public void setEndpoint(){
		RestAssured.baseURI="https://dev116510.service-now.com/api/now/table/";
	}
	@And("Set the Auth")
	public void setAuth(){
		RestAssured.authentication=RestAssured.basic("admin","Ngpe$1UnA9=A");
		
	}
	@When("create change request with String body{string}")
	public void create_changerequest(String body){
		inputRequest=RestAssured.given().contentType("application/json").body(body);
		response=inputRequest.post("change_request");
		response.prettyPrint();
		
	}
	@Then("validate response code as {int}")
	public void validateresponse(int Responsecode){
		response.then().assertThat().statusCode(Responsecode);
		
	}
	
	@When("get changerequest with queryparam {string} and {string}")
	public void getchangerequestQP(String key, String value) {
		
		inputRequest = RestAssured.given().queryParam(key, value);
		response = inputRequest.get("change_request");
	}
	@When("create changerequest with file {string}")
	public void createIncidentFile(String fileName) {
		
		File file =new File ("./data/"+fileName);
		inputRequest = RestAssured.given().contentType("application/json").body(file);
		response = inputRequest.post("change_request");
		}
	
	@When("get changerequest with queryparams")
	public void getIncidentwithQPs(DataTable dt) {
		
		Map<String, String> QP = dt.asMap();
		
		inputRequest = RestAssured.given().queryParams(QP);
		response = inputRequest.get("change_request");
		response.prettyPrint();
		
	}
	
	
	
}
