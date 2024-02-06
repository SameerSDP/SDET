package steps;

import static org.testng.Assert.assertTrue;
import io.cucumber.java.Scenario;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.PageFactory;

import Page.LoginPage;
import Utility.BrowserInit;
import Utility.ConfigReader;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import junit.framework.Assert;


public class LoginSteps extends BaseStep {

	
	WebDriver driver;
	Page.MainPage main;
	Page.LoginPage login;
	//private LoginPage login = new LoginPage(driver);
	 //private static final Logger logger = Logger.getLogger(LoginSteps.class);
	
	public LoginSteps() {
	  	driver = Hooks.getDriver();
    	login = new LoginPage(driver);
	}

    @Given("the user is on the website page")
    public void givenTheUserIsOnTheWebsitePage() {
    	String url = ConfigReader.getUrl();
        driver.get(url);
        login.acceptCookiePopUp();
       
    }

    @When("User clicks sign in button")
    public void whenUserClicksSignInButton() {
    	//this.login = new LoginPage(driver);
    	System.out.println("sign in ");
    	login.ClickOnSigninIcon();
    	
    }

    @Then("User enters username {string} and password {string} and click login")
    public void thenUserEntersUsernameAndPasswordAndClickLogin(String username, String password) {
       System.out.println("user pwd");
       login.enterSignInCredential(username,password);
    }

    @SuppressWarnings("deprecation")
	@And("user should be logged in successfully")
    public void andUserShouldBeLoggedInSuccessfully() {
      System.out.println("Assert login");
     String title=  driver.getTitle();
     Assert.assertEquals(title, "Shop Men's Clothing | Best In Men's fashion | Moores Clothing");
     
    }
    
 
    @When("User clicks sign up button")
    public void whenUserClicksSignUpButton() {
      login.ClickOnSignUpbutton();
    }

    @Then("User enters valid registration details with Firstname {string}, Lastname {string}, email {string}, and password {string}")
    public void thenUserEntersValidRegistrationDetails(String firstName, String lastName,  String email, String password) {
       login.EnterRegistrationdetails(firstName, lastName, email, password);
    }

    @And("User should see User created")
    public void andUserShouldSeeUserCreated() {
        
        assertTrue(login.isUserCreatedMessageDisplayed());
    }
    
   
   
    
    
}
