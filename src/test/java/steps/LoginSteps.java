package steps;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;


import io.cucumber.java.en.Given;
import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginSteps {

	Page.LoginPage loginPage;
    
    @Given("User is on Ecomm home page")
    public void user_is_on_ecomm_home_page() {

    	System.out.println("############started############");
    	WebDriverManager.edgedriver().setup();
    	WebDriver driver;
		driver = new EdgeDriver();
		
		loginPage = new Page.LoginPage(driver);
		
		driver.manage().window().maximize();
		driver.get("https://www.saucedemo.com/");
		
    	
    	loginPage.login();
       
    }
    
    
}
