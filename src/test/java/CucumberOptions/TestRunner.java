package CucumberOptions;

import io.cucumber.core.internal.com.fasterxml.jackson.annotation.JsonFormat;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/java/Features",
        glue = "StepDefinitions"
)
public class TestRunner extends AbstractTestNGCucumberTests {


}


