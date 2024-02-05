package steps;

import org.openqa.selenium.WebDriver;

import Utility.BrowserInit;
import Utility.ScreenshotUtils;
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
//	    	if (scenario.isFailed()) {
//	    		System.out.println("Reached sceanrio failre SS");
//	            String screenshotName = "Screenshot";
//	            System.out.println(screenshotName);
//	            ScreenshotUtils.captureScreenshot(driver, screenshotName);
//	        }
	    	
	    	System.out.println("Calling closed browser");
	    	BrowserInit.CloseBrowser(scenario);
	    }
	    
	    public static WebDriver getDriver() {
	        return driver;
	    }
}
