package Page;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import Utility.BaseMethod;
import Utility.ExcelUtility;

public class SearchPage {

	private WebDriver driver;
	private WebDriverWait wait;
	private ExcelUtility excelUtility;
	BaseMethod base;

	public SearchPage(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, 10);
		this.excelUtility = new ExcelUtility();
		this.base = new BaseMethod(driver);
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//i[@title='Search']")
	WebElement searchIcon;

	@FindBy(id = "searchInput")
	WebElement searchText;

	@FindBy(xpath = "//li[@class='productlist']")
	WebElement productList;

	@FindBy(xpath = "//div[@class='product-text']")
	WebElement productText;

	@FindBy(xpath = "//span[contains(text(), 'returned 0 results.')]")
	WebElement noProductFound;

	@FindBy(xpath = "//span[contains(text(), 'Search Results')]")
	WebElement searchResultText;

	@FindBy(xpath = "//div[contains(@class, 'pdp-container')]//*[contains(@id, 'product-name-product-detail') ]")
	WebElement productNameonPDP;

	@FindBy(xpath = "//h2[@class='name shortName'][1]")
	WebElement firstProduct;
	
	

	public void clickSearchIcon() {
		wait.until(ExpectedConditions.elementToBeClickable(searchIcon)).click();

	}

	public void enterSearchText(String searchtext) {
		searchText.sendKeys(searchtext);

		// String searchtextExcel =base.getSearchTextFromExcel();
		// searchText.sendKeys(searchtextExcel);
		searchText.sendKeys(Keys.ENTER);
		// searchIcon.click();
	}

	public boolean isSearchShowingProduct() {
		wait.until(ExpectedConditions.visibilityOf(productList));
		wait.until(ExpectedConditions.visibilityOf(productText));
		wait.until(ExpectedConditions.visibilityOf(searchResultText));
		return (searchResultText.isDisplayed() && productText.isDisplayed());
	}

	public boolean isSearchShowingNoProduct() {
		wait.until(ExpectedConditions.visibilityOf(noProductFound));
		return noProductFound.isDisplayed();
	}

	public void searchProduct(String searchtext) {

		try {
			wait.until(ExpectedConditions.elementToBeClickable(searchIcon)).click();
			searchText.sendKeys(searchtext);
			searchIcon.click();

		} catch (Exception e) {
			// TODO: handle exception
		}

	}

	public WebElement getProductFromProductName(String productName) {

		try {

			String xpath = "//div[text()='" + productName + "']";

			WebElement product = driver.findElement(By.xpath(xpath));
			wait.until(ExpectedConditions.visibilityOf(product));
			return product;

		} catch (NoSuchElementException e) {
			System.out.println("No product found");
			return null;
		}

	}

	public void navigatetoProductDetailsPage(WebElement product) {

		try {
			wait.until(ExpectedConditions.elementToBeClickable(product));
			// product.click();

			base.clickElementWithJavaScript(product, driver);
			wait.until(ExpectedConditions.visibilityOf(productNameonPDP));

			if (!productNameonPDP.isDisplayed()) {
				// Assert.assertTrue(false);
				Assert.assertTrue(false);
			}
		} catch (NoSuchElementException e) {
			System.out.println("PDP nt displayed");
		}

	}

	public WebElement getFirstProductFromSearch() {

		try {

			wait.until(ExpectedConditions.visibilityOf(firstProduct));
			return firstProduct;

		} catch (NoSuchElementException e) {
			System.out.println("No product found");
			return null;
		}
	}

	
}
