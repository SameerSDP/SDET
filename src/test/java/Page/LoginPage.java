package Page;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Utility.BaseMethod;
import junit.framework.Assert;

public class LoginPage {

	private WebDriver driver;
	BaseMethod base;
	private WebDriverWait wait;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		this.wait = new WebDriverWait(driver, 10);
	}

	@FindBy(id = "userId")
	WebElement username;

	@FindBy(id = "password")
	WebElement password;

	@FindBy(id = "confirm-password")
	WebElement confirm_password;

	@FindBy(id = "firstName")
	WebElement firstName;

	@FindBy(id = "lastName")
	WebElement lastName;

	@FindBy(id = "logonId")
	WebElement logonId;

	@FindBy(xpath = "//span[text()='Sign In']")
	WebElement SigInIcon;

	@FindBy(xpath = "//button[text()='Sign In']")
	WebElement SigInClick;

	@FindBy(xpath = "//a[@href='/registration']")
	WebElement CreateAccount;

	@FindBy(xpath = "//button[text()='Create Account']")
	WebElement btnCreateAccount;

	@FindBy(xpath = "//span[text()='Account Info']")
	WebElement accountInfo;

	@FindBy(xpath = "//div[@class='onetrust-banner-options accept-btn-only']//button")
	WebElement btnAcceptCookies;

	public void acceptCookiePopUp() {
		wait.until(ExpectedConditions.visibilityOf(btnAcceptCookies));
		btnAcceptCookies.click();
	}

	public void enterSignInCredential(String userName, String pwd) {

		username.sendKeys(userName);
		password.sendKeys(pwd);
		SigInClick.click();
	}

	public void ClickOnSigninIcon() {
		SigInIcon.click();
	}

	public void ClickOnSignUpbutton() {
		SigInIcon.click();
		CreateAccount.click();
	}

	public void EnterRegistrationdetails(String firstName, String lastName, String email, String password) {
		this.firstName.sendKeys(firstName);
		this.lastName.sendKeys(lastName);
		this.logonId.sendKeys(email);
		this.password.sendKeys(password);
		this.confirm_password.sendKeys(password);

		base.clickElementWithJavaScript(btnCreateAccount, driver);
	}

	public boolean isUserCreatedMessageDisplayed() {

		return accountInfo.isDisplayed();
	}
}
