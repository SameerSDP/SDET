package steps;

import org.openqa.selenium.WebDriver;

import Utility.BrowserInit;
import Utility.ScreenshotUtils;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class Hooks {
	protected static WebDriver driver;
	private static final Logger logger = Logger.getLogger(Hooks.class);
	
	@Before
	public void setup(Scenario scenario) {
		driver = BrowserInit.LaunchBrowser();
		PropertyConfigurator.configure("src/test/resources/log4j.properties");
	}

	// This method will run after any scenario
	@After
	public void tearDown(Scenario scenario) {

		System.out.println("Calling closed browser");
		BrowserInit.CloseBrowser(scenario);
	}

	public static WebDriver getDriver() {
		return driver;
	}
}
