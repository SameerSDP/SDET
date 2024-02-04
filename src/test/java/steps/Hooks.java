package steps;

import org.openqa.selenium.WebDriver;

import Utility.BrowserInit;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks {
	protected static WebDriver driver;
	   @Before
	    public void setup(Scenario scenario) {
		   driver = BrowserInit.LaunchBrowser();
	
	    }

	    // This method will run after any scenario
	    @After
	    public void tearDown(Scenario scenario) {
	    	BrowserInit.CloseBrowser();
	    }
	    
	    public static WebDriver getDriver() {
	        return driver;
	    }
}
