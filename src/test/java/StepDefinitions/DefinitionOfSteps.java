package StepDefinitions;

import Utils.Base;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DefinitionOfSteps extends Base {

    private static final Logger log = LoggerFactory.getLogger(DefinitionOfSteps.class);
    public WebDriver driver;
    public DefinitionOfSteps (){
        this.driver = super.driver;
    }

    @Given("User is on the login page")
        public void user_is_on_the_login_page() {
         loginPage.verifyLoginPageIsDisplayed();
        }

    @When("User enters email {}")
    public void user_enters_email(String email) {
        loginPage.enterEmail(email);
    }

    @And("User enters password {}")
    public void user_enters_password(String password) {
        loginPage.enterPassword(password);
    }
    @And("User clicks on the login button")
    public void user_clicks_on_the_login_button() {
        loginPage.clickLoginButton();
    }
    @Then("User should land on  the landing page")
    public void user_should_land_on_the_landing_page() {
        //landingPage.verifyLearnAutomationTheRightWayIsDisplayed();
    }

    @When("User enters invalid email {} or {}")
    public void userEntersInvalidEmailEmailOrPassword(String email, String password) {
        //loginPage.enterEmail(email);
        //loginPage.enterPassword(password);
    }

    @Then("User should see a message {}")
    public void userShouldSeeAMessageMessage(String message) {
        //loginPage.confirmIfErrorMessageIsDisplayed(message);
    }

}
