package steps;

import org.openqa.selenium.WebDriver;

import Utility.BrowserInit;



public class BaseStep {

	protected static WebDriver driver;

	protected WebDriver GetDriver() {
		if (driver == null) {
			driver = BrowserInit.LaunchBrowser();
		}
		return driver;
	}
}
