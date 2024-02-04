package Utility;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserInit {

	static WebDriver driver;
	
	//Open Browser
	
	
	public static WebDriver LaunchBrowser() {

		
		
		
		WebDriverManager.edgedriver().setup();
		driver = new EdgeDriver();
		System.out.println("On browser in it ");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return driver;
		
	}
	

	public static void CloseBrowser() {
		System.out.println("On browser tear down");
		if (driver != null) {
            driver.quit();
        }
		
	}
}
