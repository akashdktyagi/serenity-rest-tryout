package starter.petstore.stepdefs;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import net.serenitybdd.screenplay.rest.interactions.Get;
import net.thucydides.model.util.EnvironmentVariables;


public class StepDefs {

//    Given
//    When I call get pet with status as "available"
//    Then I should get the list of all the available pets

    EnvironmentVariables environmentVariables;

    String theRestApiBaseUrl = environmentVariables.getProperty("restapi.baseurl");
    Actor I;

    @Given("I have a pet store API")
    public void iHaveAPetStoreAPI() {
        I = Actor.named("I the caller of the API")
                .whoCan(CallAnApi.at(theRestApiBaseUrl));

    }
    @When("I call get end point pet with status as {string}")
    public void iCallGetEndPointWithStatusAs(String status) {
        I.attemptsTo(
                Get.resource("/pet/findByStatus?status=available")
        );
    }
    @Then("I should get a response")
    public void i_should_get_a_response() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
}
