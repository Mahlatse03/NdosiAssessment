package Utils;

import Pages.LandingPage;
import Pages.LearningMaterialPage;
import Pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class Base {

    BrowserFactory browserFactory = new BrowserFactory();
    protected final WebDriver driver = browserFactory.startBrowser("chrome", "https://www.ndosiautomation.co.za/" +
            "/#practice" );

    // Create class instances
    public LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
    public LearningMaterialPage learningMaterialPage = PageFactory.initElements(driver, LearningMaterialPage.class);
    public LandingPage landingPage = PageFactory.initElements(driver, LandingPage.class);




}
