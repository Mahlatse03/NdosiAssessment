package Utils;

import Pages.LandingPage;
import Pages.LearningMaterialPage;
import Pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

//Used to combine all the classes in the project/framework
public class Base {

    BrowserFactory browserFactory = new BrowserFactory();
    //final = session name will not change throughout the project
    protected final WebDriver driver = browserFactory.startBrowser("chrome", "https://www.ndosiautomation.co.za/" +
            "/#practice" );

    // Create page constructors and instances (e.g.loginPage), link to driver
    public LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
    public LearningMaterialPage learningMaterialPage = PageFactory.initElements(driver, LearningMaterialPage.class);
    public LandingPage landingPage = PageFactory.initElements(driver, LandingPage.class);


}
