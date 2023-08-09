package stepDefinitions;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/Features", glue = {"stepDefinitions"},
       // monochrome = true,
        publish = true,
        plugin = {"pretty", "html:target/cucumber-reports"},
        tags = "@SmokeOne or @SmokeTwo"

)
public class TestRunner {

}
