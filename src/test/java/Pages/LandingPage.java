package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LandingPage {

    WebDriver driver;

    @FindBy(id = "overview-section")
    WebElement overviewSection_id;
    @FindBy (id = "nav-btn-practice")
    WebElement learningMaterialButton_id;
    @FindBy (id = "tab-btn-web")
    WebElement webTabButton_id;
    @FindBy (id = "assessment-instructions")
    WebDriver assessmentInstructions_id;
    public LandingPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickLearningMaterialButton() {
        learningMaterialButton_id.click();
    }
    public void clickWebTabButton() {
        webTabButton_id.click();
    }

}
