package Page;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Utility.BaseMethod;

public class CheckoutPage {

	private WebDriver driver;
	BaseMethod base;
	private WebDriverWait wait;

	public CheckoutPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		this.wait = new WebDriverWait(driver, 10);
		this.base = new BaseMethod(driver);
	}

	@FindBy(xpath = "//div[@class='product-part-number sku-box']/span[@class='sku-text']")
	WebElement skuName;
	
	
	
	@FindBy(xpath = "//span[text()='Edit']")
	WebElement editCart;
	
		
	@FindBy(xpath = "//span[text()='Update']")
	WebElement btnUpdate;

	public String getSKUName() {
		String name = skuName.getText();
		String skuNumber = name.substring(name.indexOf("SKU: ") + "SKU: ".length());
		System.out.println("SSKKKUU name : " + name);
		return skuNumber;
	}

	public int getProductCountinCart(String productSKU) {

		String xpath = "//*[text()='" + productSKU + "']";
		List<WebElement> productInCart = driver.findElements(By.xpath(xpath));
		return productInCart.size();
	}
	
	public void clickOnEdit() {
		wait.until(ExpectedConditions.elementToBeClickable(editCart));
		base.clickElementWithJavaScript(editCart, driver);
	}
	
	public void clickOnUpdate() {
		wait.until(ExpectedConditions.elementToBeClickable(editCart));
		base.clickElementWithJavaScript(btnUpdate, driver);
	}

}
