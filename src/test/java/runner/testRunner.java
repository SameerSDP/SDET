package runner;



import io.cucumber.junit.Cucumber;
//import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
    features = "src/test/resources",
    glue = "steps",
    plugin = {"pretty", "html:target/cucumber-reports"}
)
public class testRunner extends AbstractTestNGCucumberTests{
	
}
