package runnerClass;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/Features", glue="stepDefinitions",
monochrome = true, plugin = {"pretty","html:cucumberReport/htmlReport.html"})

public class Runner {

}
