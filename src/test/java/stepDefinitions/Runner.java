package stepDefinitions;
 
import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import io.cucumber.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(plugin = {"pretty","html:target/cucumber-report"}, monochrome = true,dryRun = false, tags = {"@Test123"}, glue = {"stepDefinitions"},features = {"src/test/resources"} )
public class Runner {  
}