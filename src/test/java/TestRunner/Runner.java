package TestRunner;


import io.cucumber.testng.AbstractTestNGCucumberTests;

import io.cucumber.testng.CucumberOptions;
@CucumberOptions(
        features = "src/test/resources/Features",
        glue = {"StepDefinitions"},
        plugin = {"pretty", "html:target/cucumber-reports.html", "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},
        monochrome = true,
        tags = "@validLogin"
)

public class Runner extends AbstractTestNGCucumberTests {
}
