package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {

    WebDriver driver;

    @FindBy (id = "signup-toggle")
    WebElement signupToggle_id;

    @FindBy (id = "login-email")
    WebElement emailField_id;

    @FindBy (id = "login-password")
    WebElement passwordField_id;

    @FindBy (id = "login-submit")
    WebElement loginButton_id;

    public void verifyLoginPageIsDisplayed() {
        signupToggle_id.isDisplayed();
    }

    public void enterEmail(String email) {
        emailField_id.sendKeys(email);
    }
    public void enterPassword(String password) {
        passwordField_id.sendKeys(password);
    }
    public void clickLoginButton() {
        loginButton_id.click();
    }
}
