package runner;



import io.cucumber.junit.Cucumber;
//import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
    features = "src/test/resources/feature",
    glue = {"steps", "steps.hooks"},
    //tags = "@updateCart",
    plugin = {"pretty", "html:target/cucumber-reports/dsalgo.html" , "html:target/html-reports/report.html"}
)
public class testRunner extends AbstractTestNGCucumberTests{
	
}