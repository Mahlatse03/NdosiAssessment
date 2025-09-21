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

    @FindBy(id = "deviceType")
    List<WebElement> deviceType_id;

    @FindBy(id = "brand")
    List<WebElement> brand_id;

    @FindBy(name = "Storage")
    List<WebElement> deviceStorageRadios;

    @FindBy(id = "color")
    List<WebElement> color_id;

    @FindBy(id = "quantity")
    WebElement quantity_id;

    @FindBy(id = "address")
    WebElement address_id;

    @FindBy(id = "step1-pricing-summary")
    WebElement pricingSummary_id;

    @FindBy(id = "inventory-next-btn")
    WebElement nextButton_id;

    @FindBy(id = "inventory-title")
    WebElement inventoryTitle_id;



    public LearningMaterialPage(WebDriver driver) {
        this.driver = driver;
    }

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

    public void verifyInventoryTitleIsDisplayed() {
        Select dropdown = new Select(driver.findElement(By.id("deviceType")));
        String selectedValue = dropdown.getFirstSelectedOption().getAttribute("value");
        Assert.assertFalse(selectedValue == null || selectedValue.isEmpty(), "Device is not selected.");
        inventoryTitle_id.isDisplayed();
    }

    public void selectDeviceType(String deviceType) {
        Select dropdown = new Select(driver.findElement(By.id("deviceType")));
        dropdown.selectByVisibleText(deviceType);
    }

    public void verifyNoBrandSelected() {
        Select dropdown = new Select(driver.findElement(By.id("brand")));
        String selectedValue = dropdown.getFirstSelectedOption().getAttribute("value");
        Assert.assertFalse(selectedValue == null || selectedValue.isEmpty(), "Brand is not selected.");
    }

    public void selectBrand(String brand) {
        Select dropdown = new Select(driver.findElement(By.id("brand")));
        dropdown.selectByVisibleText(brand);
    }

    public void verifyNoStorageSelected() {
        boolean isSelected = false;
        for (WebElement radio : deviceStorageRadios) {
            if (radio.isSelected()) {
                isSelected = false;
                break;
            }
        }
        Assert.assertTrue(isSelected, "A storage option must be selected.");
    }
    public void selectDeviceStorage(String deviceStorage) {
        for (WebElement radio : deviceStorageRadios) {
            if (radio.getAttribute("value").equals(deviceStorage)) {
                radio.click();
                break;
            }
        }
    }

    public void selectColor(String color) {
        Select dropdown = new Select(driver.findElement(By.id("color")));
        dropdown.selectByVisibleText(color);
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

    public void confirmMissingFieldsAlert(String deviceErrorMessage) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        String alertText = alert.getText();
        Assert.assertEquals(alertText, deviceErrorMessage);
        alert.accept();
    }

}
