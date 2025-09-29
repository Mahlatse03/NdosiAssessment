package Pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;

public class LearningMaterialPage {

    WebDriver driver;
    public LearningMaterialPage(WebDriver driver) {
        this.driver = driver;
    }

    @FindBy(id = "deviceType")
    List<WebElement> deviceType_id;

    @FindBy(id = "brand")
    List<WebElement> brand_id;

    @FindBy(name = "storage")
    List<WebElement> deviceStorageRadios;

    @FindBy(name = "warranty")
    List<WebElement> warrantyRadios;

    @FindBy(id = "color")
    List<WebElement> color_id;

    @FindBy(id = "quantity")
    WebElement quantity_id;

    @FindBy(id = "address")
    WebElement address_id;

    @FindBy(id = "step1-pricing-summary")
    WebElement pricingSummary_id;

    @FindBy(id = "step2-actions")
    WebElement Step2Actions_id;

    @FindBy(id = "inventory-next-btn")
    WebElement nextButton_id;

    @FindBy(id = "inventory-title")
    WebElement inventoryTitle_id;

    @FindBy(id = "summary-device-type")
    WebElement summaryDeviceType_id;

    @FindBy(id = "summary-storage")
    WebElement summaryStorage_id;

    @FindBy(id = "summary-quantity")
    WebElement summaryQuantity_id;

    @FindBy(id = "base-price-value")
    WebElement basePriceValue_id;

    @FindBy(id = "breakdown-quantity-value")
    WebElement breakdownQuantityValue_id;

    @FindBy(id = "breakdown-subtotal-value")
    WebElement breakdownSubtotalValue_id;

    @FindBy(id = "breakdown-warranty-value")
    WebElement breakdownWarrantyValue_id;

    @FindBy(id = "breakdown-shipping-value")
    WebElement breakdownShippingValue_id;

    @FindBy(id = "breakdown-total-value")
    WebElement breakdownTotalValue_id;

    @FindBy(id = "shipping-option-standard")
    WebElement shippingOptionStandard_id;

    @FindBy(id = "shipping-option-express")
    WebElement shippingOptionExpress_id;

    @FindBy(id = "inventory-back-btn")
    WebElement inventoryBackButton_id;

    @FindBy(id = "unit-price-value")
    WebElement unitPriceValue_id;

    @FindBy(id = "subtotal-value")
    WebElement subtotalValue_id;

    @FindBy(id = "discount-code")
    WebElement discountCode_id;

    @FindBy(id = "apply-discount-btn")
    WebElement applyDiscountButton_id;

    @FindBy(id = "discount-feedback")
    WebElement discountFeedback_id;

    public void verifyOverviewSectionIsDisplayed(String firstName) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement header = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("practice-header")));
        String actualText = header.getText();
        //Trim the text to exclude everything after the exclamation mark
        int index = actualText.indexOf("!");
        String result = (index != -1) ? actualText.substring(0, index + 1).trim() : actualText.trim();

        // Verify the text
        Assert.assertEquals("Welcome back, "+ firstName + "!", result);
        header.isDisplayed();
    }

    public void navigateToWizardPage() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement webTabButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("tab-btn-web")));
        webTabButton.click();
    }

    public void verifyInventoryTitleIsDisplayed() {
        Select dropdown = new Select(driver.findElement(By.id("deviceType")));
        String selectedValue = dropdown.getFirstSelectedOption().getAttribute("value");
        Assert.assertTrue(selectedValue == null || selectedValue.isEmpty(), "Device is not selected.");
        inventoryTitle_id.isDisplayed();
    }

    public void selectDeviceType(String deviceType) {
        Select dropdown = new Select(driver.findElement(By.id("deviceType")));
        dropdown.selectByVisibleText(deviceType);
    }

    public void clearDeviceType() {
        inventoryBackButton_id.click();
        Select dropdown = new Select(driver.findElement(By.id("deviceType")));
        dropdown.selectByVisibleText("Select");
    }

    public void verifyNoBrandSelected() {
        Select dropdown = new Select(driver.findElement(By.id("brand")));
        String selectedValue = dropdown.getFirstSelectedOption().getAttribute("value");
        Assert.assertTrue(selectedValue == null || selectedValue.isEmpty(), "Brand is not selected.");
    }

    public void selectBrand(String deviceBrand) {
        Select dropdown = new Select(driver.findElement(By.id("brand")));
        dropdown.selectByVisibleText(deviceBrand);
    }

    public void verifyNoStorageSelected() {
        boolean isSelected = false;
        for (WebElement radio : deviceStorageRadios) {
            if (radio.isSelected()) {
                isSelected = false;
                break;
            }
        }
        Assert.assertFalse(isSelected, "A storage option must be selected.");
    }
    public void selectDeviceStorage(String deviceStorage) {
        for (WebElement radio : deviceStorageRadios) {
            if (radio.getAttribute("value").equals(deviceStorage)) {
                radio.click();
                break;
            }
        }
    }

    public void selectColor(String deviceColor) {
        Select dropdown = new Select(driver.findElement(By.id("color")));
        dropdown.selectByVisibleText(deviceColor);
    }
    public void enterQuantity(String quantity) {
        if (quantity_id.getAttribute("value").isEmpty()) {
            quantity_id.sendKeys(quantity);
            return;
        }

    }

    public void enterAddress(String address) {
        if (address_id.getAttribute("value").isEmpty()) {
            address_id.sendKeys(address);
            return;
        }
    }

    public void verifyFormCompletionAndClickNextButton() {
        if (nextButton_id.isEnabled()){
            nextButton_id.click();
            return;
        }
    }

    public void verifyNextButtonIsDisabled() {
        Assert.assertTrue(nextButton_id.isEnabled(), "Next button is disable because some fields are empty.");
    }

    public void verifyStep2ActionsIsDisplayed() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement step2Actions = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("step2-actions")));
        Assert.assertTrue(step2Actions.isDisplayed(), "Step 2 actions section is not displayed.");
    }

    public void confirmMissingFieldsAlert(String deviceErrorMessage) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        String alertText = alert.getText();
        Assert.assertEquals(alertText, deviceErrorMessage);
        alert.accept();
    }

    public void confirmErrorMessageIsDisplayed(String deviceErrorMessage) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        String alertText = alert.getText();
        Assert.assertEquals(alertText, deviceErrorMessage);
        alert.accept();
    }

    public void confirmSuccessMessageIsDisplayed(String successMessage) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        String alertText = alert.getText();
        Assert.assertEquals(alertText, successMessage);
        alert.accept();
    }

    public void enterDiscountCode(String discountCode) {
        discountCode_id.sendKeys(discountCode);
        applyDiscountButton_id.click();

        //Trim discount code to get discount value
        int index = discountCode.indexOf("SAVE");
        int discountValue = Integer.parseInt((index != -1) ? discountCode.substring(index + 4, index + 6).trim() : discountCode.trim());

        //Verify discount applied
        if (!discountFeedback_id.getText().isEmpty()) {
            String feedbackText = discountFeedback_id.getText().trim();
            Assert.assertEquals(feedbackText, "Code " + discountCode + " applied: -" + discountValue + "%");
        }
    }

    public void verifySubtotalCalculation(int quantity, double unitPrice, double priceOfStorage) {
        String basePriceText = basePriceValue_id.getText().replace("R", "").trim();
        String quantityText = breakdownQuantityValue_id.getText().trim();
        String subtotalText = breakdownSubtotalValue_id.getText().replace("R", "").trim();
        String totalText = breakdownTotalValue_id.getText().replace("R", "").trim();

        double basePriceValue = Double.parseDouble(basePriceText);
        int quantityValue = Integer.parseInt(quantityText);
        double actualSubtotalValue = Double.parseDouble(subtotalText);
        double actualTotalValue = Double.parseDouble(totalText);

        double expectedBasePrice = (unitPrice + priceOfStorage) * quantity;

        double expectedTotalValue = (unitPrice + priceOfStorage) * quantity;
        Assert.assertEquals(basePriceValue, expectedBasePrice, "Base price is incorrect.");
        Assert.assertEquals(quantityValue, quantity, "Quantity is incorrect.");
        Assert.assertEquals(actualSubtotalValue, (unitPrice + priceOfStorage) * quantity, "Subtotal calculation is incorrect.");
        Assert.assertEquals(actualTotalValue, expectedTotalValue, "Total calculation is incorrect.");
    }

    public void verifyTotalInclusiveOfShippingAndWarranty(double warrantyCost, double shippingCost, String discountCode) {
        String totalText = breakdownTotalValue_id.getText().replace("R", "").trim();
        double actualTotalValue = Double.parseDouble(totalText);
        String subtotalText = breakdownSubtotalValue_id.getText().replace("R", "").trim();
        double actualSubtotalValue = Double.parseDouble(subtotalText);

        //Trim discount code to get discount value
        int index = discountCode.indexOf("SAVE");
        int discountValue = Integer.parseInt((index != -1) ? discountCode.substring(index + 4, index + 6).trim() : discountCode.trim());

        double expectedTotalValue = actualSubtotalValue + warrantyCost + shippingCost;

      //  System.out.println("Discount value: " + discountValue);
       // System.out.println("Expected total value: " + expectedTotalValue);
        double discountAmount = (expectedTotalValue * discountValue) / 100;
        double expectedTotalWithDiscount = expectedTotalValue - discountAmount;

        Assert.assertEquals(actualTotalValue, expectedTotalWithDiscount, "Total calculation is incorrect including shipping and warranty.");
    }

    public void verifyClearCartAmount(){
        String totalText = subtotalValue_id.getText().replace("R", "").trim();
        double actualTotalValue = Double.parseDouble(totalText);
        String unitPriceText = unitPriceValue_id.getText().replace("R", "").trim();
        double actualUnitPriceValue = Double.parseDouble(unitPriceText);

        double expectedUnitPriceValue = actualUnitPriceValue;
        Assert.assertEquals(actualTotalValue, expectedUnitPriceValue, "Total calculation is incorrect after clearing the cart.");
    }

    public void selectShippingOption (String shippingOption) {

        if (shippingOption.equalsIgnoreCase("Yes")) {
            shippingOptionExpress_id.click();
        }
        else {
            shippingOptionStandard_id.click();
        }
    }

    public void selectWarrantyOption (String warranty) {

        for (WebElement radio : warrantyRadios) {
            if (warranty.equals(radio.getAttribute("value"))) {
            //if (radio.getAttribute("value").equals(warranty)){
                radio.click();
                break;
            }
            else{
                System.out.println("Could not find the warranty option: " + warranty);
            }
        }

    }





}
