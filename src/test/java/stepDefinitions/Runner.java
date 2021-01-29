package stepDefinitions;
 
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(plugin = {"pretty","html:target/cucumber-report.html"}, monochrome = true,dryRun = false, tags = "@Test123", glue = "stepDefinitions",features = "src/test/resources" )
public class Runner {  
}