package Page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;



public class LoginPage {

	private WebDriver driver;
	//Properties1 property = new Properties1();
	public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
	
	@FindBy(id = "user-name")
	WebElement username;
	
	@FindBy(id = "password")
	WebElement password;
	
	
	@FindBy(id = "login-button")
	WebElement loginbutton;
	
	public void login() {
		username.sendKeys("standard_user");
		password.sendKeys("secret_sauce");
		loginbutton.click();
		
		System.out.println("Loggedin with standard_user ");
	}
}
