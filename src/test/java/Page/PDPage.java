package Page;

import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import Utility.BaseMethod;

public class PDPage {

	private WebDriver driver;
	BaseMethod base;
	private WebDriverWait wait;

	public PDPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		this.wait = new WebDriverWait(driver, 10);
	}

	@FindBy(xpath = "//span[text()='Add to Bag']//parent::button")
	WebElement btnAddToBag;
	
	
	
	@FindBy(xpath = "//span[(contains(text(),'added to bag'))]//parent::h2")
	WebElement AddedToBagConfirmText;

	public WebElement getColorSwatchFromColor(String color) {

		try {
			String xpath = "//input[@type='radio' and @name='Color' and @value = '" + color + "']//parent::label";
			WebElement colorSwatch = driver.findElement(By.xpath(xpath));

			return colorSwatch;
		} catch (NoSuchElementException e) {
			// TODO: handle exception
			return null;
		}

	}

	public WebElement getSizeSwatchFromSizeString(String size) {

		try {
			String xpath = "//input[@type='radio' and @name='PrimarySize' and @value = '" + size + "']//parent::label";
			WebElement sizeSwatch = driver.findElement(By.xpath(xpath));

			return sizeSwatch;
		} catch (NoSuchElementException e) {
			// TODO: handle exception
			return null;
		}
	}

	public void selectColorAndSize(WebElement color, WebElement size) {
		try {
			if (color.isEnabled()) {
				color.click();
			} else {
				System.out.println("color is not available");
			}

			if (size.isEnabled()) {
				size.click();
			} else {
				System.out.println("size is not available");
			}

		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	public void clickAddToBag() {

		try {
			if (btnAddToBag.isEnabled()) {
				btnAddToBag.click();
				
			} else {
				System.out.println("Select size and color");
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public void verifyAddedToBagConfirmation() {
		wait.until(ExpectedConditions.visibilityOf(AddedToBagConfirmText));
		if (AddedToBagConfirmText.isDisplayed()) {
			Assert.assertTrue(true);
		}
		else {
			Assert.assertTrue(false);
		}
	}

}
