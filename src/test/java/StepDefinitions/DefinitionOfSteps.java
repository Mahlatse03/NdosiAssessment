package StepDefinitions;

import Utils.Base;
import Utils.BrowserFactory;
import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DefinitionOfSteps extends Base {

   /* public WebDriver driver;
    public DefinitionOfSteps (){
        this.driver = super.driver;
    }*/

    @Given("User is on the login page")
    public void user_is_on_the_login_page() {
        loginPage.verifyLoginPageIsDisplayed();
    }

    @When("User enters email {}")
    public void userEntersEmailEmail(String email) {
        loginPage.enterLoginEmail(email);
    }

    @And("User enters password {}")
    public void userEntersPasswordPassword(String password) {
        loginPage.enterPassword(password);
    }

    @And("User clicks on the login button")
    public void userClicksOnTheLoginButton() {
        loginPage.clickLoginButton();
    }

    @Then("User should land on  the landing page with {} displayed")
    public void userShouldLandOnTheLandingPageWithMessageDisplayed(String firstName) {
        learningMaterialPage.verifyOverviewSectionIsDisplayed(firstName);
    }

    @Then("User should see a message {}")
    public void userShouldSeeAMessageMessage(String message) {
        loginPage.confirmIfErrorMessageIsDisplayed(message);
    }

    @When("User switcher Tabs")
    public void userSwitcherTabs() {
        loginPage.switchTabs();
    }

    @Then("User should be logged out and redirected to the login page")
    public void userShouldBeLoggedOutAndRedirectedToTheLoginPage() {
        loginPage.verifyLoginPageIsDisplayed();
    }

    @After
    public void quitBrowser() {
        if (driver != null) {
            driver.quit();// Prevent reuse
        }
    }

}
