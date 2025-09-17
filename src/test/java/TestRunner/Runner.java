package TestRunner;


import io.cucumber.testng.AbstractTestNGCucumberTests;

import io.cucumber.testng.CucumberOptions;
@CucumberOptions(
        features = "src/test/resources/Features",
        glue = {"StepDefinitions"},
        plugin = {"pretty", "html:target/cucumber-reports.html"},
        monochrome = true,
        tags = "@validlogin and @invalidlogin"
)

public class Runner extends AbstractTestNGCucumberTests {
}
