package TestRunner;


import io.cucumber.testng.AbstractTestNGCucumberTests;

import io.cucumber.testng.CucumberOptions;

/*
@CucumberOptions(
        features = "src/test/resources/Features/Wizard.feature",
        glue = {"StepDefinitions"},
        plugin = {"pretty", "html:target/cucumber-reports.html", "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},
        monochrome = true
)

 */

@CucumberOptions(
        features = "src/test/resources/Features",
        glue = {"StepDefinitions"},
        plugin = {"pretty", "html:target/cucumber-reports.html", "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},
        monochrome = true,
        tags = "@validLogin or @validPhoneDetails"
)

public class Runner extends AbstractTestNGCucumberTests {
}
