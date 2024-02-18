package starter.petstore.stepdefs;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import net.serenitybdd.screenplay.rest.interactions.Get;
import net.thucydides.model.util.EnvironmentVariables;
import static net.serenitybdd.screenplay.rest.questions.ResponseConsequence.seeThatResponse;


@Data
@NoArgsConstructor
public class StepDefs {

    EnvironmentVariables environmentVariables;

    String theRestApiBaseUrl = environmentVariables.getProperty("restapi.baseurl");
    Actor I;

    @Given("I have a pet store API")
    public void iHaveAPetStoreAPI() {
        I = Actor.named("I the caller of the API")
                .whoCan(CallAnApi.at(theRestApiBaseUrl));

    }

    @When("I call get end point for fetching pets and with status as {string}")
    public void iCallGetEndPointWithStatusAs(String status) {
        I.attemptsTo(
                Get.resource("/pet/findByStatus?status="+status)
        );
    }

    @Then("I should get the status code as 200")
    public void iShouldGetTheStatusCodeAs() {
        I.should(
                seeThatResponse("The Status code is : ", response -> response.statusCode(200))
        );
    }
    @Then("I should get the list of all the available pets")
    public void iShouldGetTheListOfAllTheAvailablePets() {
        I.should(
                seeThatResponse("I should get the response body with text as : ",
                        response -> response.statusCode(200).body("status", org.hamcrest.Matchers.equalTo("available"))
        ));
    }
}
