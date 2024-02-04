package Page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Utility.BaseMethod;

public class SearchPage {

	private WebDriver driver;
	private WebDriverWait wait;
	BaseMethod base;
	
	public SearchPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 10);
        PageFactory.initElements(driver, this);
    }
	
	
	
	@FindBy(xpath = "//i[@title='Search']")
	WebElement searchIcon;
	
	@FindBy(id = "searchInput")
	WebElement searchText;
	
	
	@FindBy(xpath = "//li[@class='productlist']")
	WebElement productList;
	
	
	
	@FindBy(xpath = "//span[contains(text(), 'returned 0 results.')]")
	WebElement noProductFound;
	
	
	public void clickSearchIcon() {
		wait.until(ExpectedConditions.elementToBeClickable(searchIcon)).click();

	}
	
	public void enterSearchText(String searchtext) {
		searchText.sendKeys(searchtext);
		searchIcon.click();
	}
	
	 public boolean isSearchShowingProduct() {   
		 	wait.until(ExpectedConditions.visibilityOf(productList));
	        return productList.isDisplayed();
	    }
	 public boolean isSearchShowingNoProduct() { 
		 wait.until(ExpectedConditions.visibilityOf(noProductFound));
	        return noProductFound.isDisplayed();
	    }
}
