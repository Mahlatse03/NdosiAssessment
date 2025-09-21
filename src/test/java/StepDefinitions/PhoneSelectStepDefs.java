package StepDefinitions;

import Utils.Base;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.devtools.v137.audits.model.SRIMessageSignatureError;

public class PhoneSelectStepDefs extends Base {

    public WebDriver driver;
    public PhoneSelectStepDefs (){
        this.driver = super.driver;
    }

    @Given("I am on Wizard page and there is no device selected")
    public void i_am_on_wizard_page_and_there_is_no_device_selected() {
        learningMaterialPage.verifyInventoryTitleIsDisplayed();

    }
    @When("User selects a device {}")
    public void user_selects_a_device_type(String deviceType) {
        learningMaterialPage.selectDeviceType(deviceType);

    }

    @Then("User must select a brand {} if there is no brand selected")
    public void user_must_select_a_brand(String deviceBrand) {
        learningMaterialPage.verifyNoBrandSelected();
        learningMaterialPage.selectBrand(deviceBrand);
    }

    @Then("User must select a storage {} if there is no storage selected")
    public void user_must_select_a_storage(String deviceStorage) {
        learningMaterialPage.verifyNoStorageSelected();
        learningMaterialPage.selectDeviceStorage(deviceStorage);

    }
    @Then("User must select a quantity {} if there is no quantity selected")
    public void user_must_select_a_quantity(String quantity) {
        learningMaterialPage.enterQuantity(quantity);

    }

    @Then("User must capture address <address> if there is no address")
    public void user_must_capture_address(String address) {
        learningMaterialPage.enterAddress(address);

    }
    @When("Next button is clicked and there are missing fields")
    public void next_button_is_clicked_and_there_are_missing_fields() {
        learningMaterialPage.verifyFormCompletionAndClickNextButton();
    }
    @Then("User should see an error message {}")
    public void user_should_see_an_error_message (String deviceErrorMessage) {
        learningMaterialPage.confirmMissingFieldsAlert(deviceErrorMessage);

    }
}
