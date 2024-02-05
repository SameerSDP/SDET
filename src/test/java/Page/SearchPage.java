package Page;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

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
	
	
	
	
	public void clickSearchIcon() {
		wait.until(ExpectedConditions.elementToBeClickable(searchIcon)).click();

	}
	
	public void enterSearchText(String searchtext) {
		searchText.sendKeys(searchtext);
		
		//String searchtextExcel =base.getSearchTextFromExcel();
		//searchText.sendKeys(searchtextExcel);
		searchText.sendKeys(Keys.ENTER);
		//searchIcon.click();
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
}
