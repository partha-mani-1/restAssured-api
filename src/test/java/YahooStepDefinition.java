import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import operations.NavigateYahoo;

public class YahooStepDefinition {

    private NavigateYahoo navigateYahoo = new NavigateYahoo();

    @Given("I login to yahoo")
    public void iLoginToYahoo() {
        navigateYahoo.logonSuccessfully();
    }

    @When("I navigate to Calendar")
    public void iNavigateToCalendar() {
        navigateYahoo.navigateToCalendar();
    }

    @Then("I capture the values of {int}th June")
    public void iCaptureTheValuesOfThJune(int date) {
        System.out.println(navigateYahoo.getData());
    }
}
