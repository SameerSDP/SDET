package Utility;

import java.util.concurrent.TimeUnit;
import io.cucumber.java.Scenario;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserInit {

	static WebDriver driver;
	
	//Open Browser
	
	
	public static WebDriver LaunchBrowser() {
		String browserName = ConfigReader.getBrowser();

			
			if (browserName.equalsIgnoreCase("Edge")) {
				WebDriverManager.edgedriver().setup();
				driver = new EdgeDriver();
				driver.manage().window().maximize();
				driver.manage().deleteAllCookies();
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				return driver;
			}
			
			else if (browserName.equalsIgnoreCase("Chrome")){
				
				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver();
				driver.manage().window().maximize();
				driver.manage().deleteAllCookies();
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				return driver;
			}
			
			else {
				driver = new EdgeDriver();
				driver.manage().window().maximize();
				driver.manage().deleteAllCookies();
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				return driver;
			}
			
		} 
		
		
		
	
	

	public static void CloseBrowser(Scenario scenario) {
		System.out.println("On browser tear down");
		
		if (scenario.isFailed()) {
    		System.out.println("Reached sceanrio failre SS");
           String screenshotName = "Screenshot";
           System.out.println(screenshotName);
           ScreenshotUtils.captureScreenshot(driver, screenshotName);
       }
		if (driver != null) {
            driver.quit();
        }
		
	}
}
