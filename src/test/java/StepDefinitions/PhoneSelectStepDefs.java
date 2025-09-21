package StepDefinitions;

import Utils.Base;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;

public class PhoneSelectStepDefs extends Base {

    public WebDriver driver;
    public PhoneSelectStepDefs (){
        this.driver = super.driver;
    }

    @Given("I am on Wizard page and there is no device selected")
    public void i_am_on_wizard_page_and_there_is_no_device_selected() {

    }
    @When("User selects a device <type>")
    public void user_selects_a_device_type() {

    }
    @When("There is no devide <brand> selected")
    public void there_is_no_devide_brand_selected() {

    }
    @Then("User must select a <brand>")
    public void user_must_select_a_brand() {

    }
    @When("There is no storage <storage> selected")
    public void there_is_no_storage_storage_selected() {

    }
    @Then("User must select a <storage>")
    public void user_must_select_a_storage() {

    }
    @When("There is no quantity <quantity> selected")
    public void there_is_no_quantity_quantity_selected() {

    }
    @Then("User must select a <quantity>")
    public void user_must_select_a_quantity() {

    }
    @When("There is no address <address> selected")
    public void there_is_no_address_address_selected() {

    }
    @Then("User must capture <address>")
    public void user_must_capture_address() {

    }
    @When("Next button is clicked and there are missing fields")
    public void next_button_is_clicked_and_there_are_missing_fields() {

    }
    @Then("User should see an error message Please correct highlighted fields")
    public void user_should_see_an_error_message_please_correct_highlighted_fields() {

    }
}
