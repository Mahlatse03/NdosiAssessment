package StepDefinitions;

import Utils.Base;
import Utils.BrowserFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.en.And;
import org.openqa.selenium.support.ui.WebDriverWait;


public class PhoneSelectStepDefs extends Base {

   /* public WebDriver driver;
    public PhoneSelectStepDefs() {
        this.driver = super.driver;
    }*/

    @Given("I am on Wizard page and there is no device selected")
    public void i_am_on_wizard_page_and_there_is_no_device_selected() {
        loginPage.validLogin("md@gmail.com", "emd12345");
        learningMaterialPage.navigateToWizardPage();
        learningMaterialPage.verifyInventoryTitleIsDisplayed();

    }

    @When("User selects a device {}")
    public void user_selects_a_device_type(String deviceType) {
        learningMaterialPage.selectDeviceType(deviceType);

    }

    @And("User must select a brand {} if there is no brand selected")
    public void user_must_select_a_brand(String deviceBrand) {
        learningMaterialPage.verifyNoBrandSelected();
        learningMaterialPage.selectBrand(deviceBrand);
    }

    @And("User must select a storage {} if there is no storage selected")
    public void user_must_select_a_storage(String deviceStorage) {
        learningMaterialPage.verifyNoStorageSelected();
        learningMaterialPage.selectDeviceStorage(deviceStorage);

    }

    @And("User must select a color {} if there is no colour selected")
    public void userMustSelectAColourColorIfThereIsNoColourSelected(String deviceColor) {
        learningMaterialPage.selectColor(deviceColor);
    }

    @And("User must select a quantity {} if there is no quantity selected")
    public void user_must_select_a_quantity(String quantity) {
        learningMaterialPage.enterQuantity(quantity);

    }

    @And("User must capture address {} if there is no address")
    public void user_must_capture_address(String address) {
        learningMaterialPage.enterAddress(address);

    }

    @And("Next button is clicked and all fields are filled")
    public void next_button_is_clicked_and_all_fields_are_filled() {
        learningMaterialPage.verifyFormCompletionAndClickNextButton();
    }

    @Then("User should see an error message {}")
    public void user_should_see_an_error_message(String deviceErrorMessage) {
        learningMaterialPage.confirmMissingFieldsAlert(deviceErrorMessage);

    }

    @Then("User should see a success message {}")
    public void userShouldSeeASuccessMessageMessage(String successMessage) {
        learningMaterialPage.confirmSuccessMessageIsDisplayed(successMessage);
    }

    @Then("User should be taken to the next step where pricing panel is displayed")
    public void userShouldBeTakenToTheNextStep() {
        learningMaterialPage.verifyStep2ActionsIsDisplayed();
    }

    @And("Next button should not be enabled if any field is empty")
    public void nextButtonShouldNotBeEnabledIfAnyFieldIsEmpty() {
        learningMaterialPage.verifyNextButtonIsDisabled();
    }

    @And("Order total should be correctly calculated based on device quantity {} unit price {} storage price {}")
    public void orderTotalShouldBeCorrectlyCalculatedBasedOnDeviceUnitPriceUnitPriceStoragePriceStorageCostAndQuantityQuantity(int quantity, double unitPrice, double priceOfStorage) {
        learningMaterialPage.verifySubtotalCalculation(quantity, unitPrice, priceOfStorage);
    }


    @When("User clears the device selection")
    public void userClearsTheDeviceSelection() {

    }

    @Then("Pricing should be reset")
    public void pricingShouldBeReset() {
    }

    @When("User selects Express shipping {}")
    public void userSelectsExpressShipping(String expressShipping) {
        learningMaterialPage.selectShippingOption(expressShipping);
        
    }

    @And("User selects warranty {}")
    public void userSelectsWarrantyWarranty(String warranty) {
        learningMaterialPage.selectWarrantyOption(warranty);
    }

    @Then("Shipping cost {} and warranty {} should be added to the order total")
    public void shippingCostShouldBeAddedToTheOrderTotal(double shippingCost, double warrantyCost) {
        learningMaterialPage.verifyTotalInclusiveOfShippingAndWarranty(shippingCost, warrantyCost);
        
    }



   /* @After
    public void quitBrowser() {
        if (driver != null) {
            driver.quit();
        }
    }*/


}
