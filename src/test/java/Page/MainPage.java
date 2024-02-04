package Page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import Utility.BrowserInit;
import io.cucumber.java.After;
import io.cucumber.java.Before;


import steps.BaseStep;



public class MainPage extends BaseStep {
	
	WebDriver driver;
	MainPage main;
	
	@Before
	public void setup() {

		//driver = GetDriver();
		main = PageFactory.initElements(driver, MainPage.class);
		
	}
	
	@After
	public void tearDown() {
		BrowserInit.CloseBrowser();
	}
}
