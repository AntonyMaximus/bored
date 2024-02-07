package stepdefinitions;

import io.cucumber.java.en.*;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;

public class StepDefinitions {

    private Response response;
    private RequestSpecification request;

    @Given("the BoredAPI is available")
    public void theBoredAPIIsAvailable() {
        RestAssured.baseURI = "https://www.boredapi.com";
        request = RestAssured.given();
    }

    @When("I request for an activity")
    public void iRequestForAnActivity() {
        response = request.get("/api/activity");
    }

    @Then("I should receive a response with status code {int}")
    public void iShouldReceiveAResponseWithStatusCode(int expectedStatusCode) {
        Assert.assertEquals(expectedStatusCode, response.getStatusCode());
    }

    @Then("the response should contain the following schema:")
    public void theResponseShouldContainTheFollowingSchema(io.cucumber.datatable.DataTable dataTable) {
        dataTable.asLists().forEach(row -> {
            String fieldName = row.get(0);
            String fieldType = row.get(1);
            Assert.assertTrue(response.jsonPath().get(fieldName) != null);
            Assert.assertTrue(response.jsonPath().get(fieldName).getClass().getSimpleName().equalsIgnoreCase(fieldType));
        });
    }
}
