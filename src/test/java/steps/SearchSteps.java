package steps;

import io.cucumber.java.en.When;
import junit.framework.Assert;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import Page.CheckoutPage;
import Page.LoginPage;
import Page.PDPage;
import Page.SearchPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

import java.util.Iterator;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class SearchSteps {
	WebDriver driver;
	Page.SearchPage search;
	Page.PDPage pdp ;
	Page.CheckoutPage checkout;
	WebElement product;
	WebElement firstProduct;
	private static final Logger LOGGER = LogManager.getLogger(SearchSteps.class);

	public SearchSteps() {
		driver = Hooks.getDriver();
		search = new SearchPage(driver);
		pdp = new PDPage(driver);
		checkout = new CheckoutPage(driver);
	}

	@When("User clicks search icon")
	public void userClicksSearchIcon() {
		search.clickSearchIcon();
		LOGGER.info("In Logger, clicking on search");
	}

	@When("User enters search input {string}")
	public void userEntersSearchInput(String search) {
		this.search.enterSearchText(search);
	}

	@Then("User able to see search result")
	public void userAbleToSeeSearchResult() {

		if (search.isSearchShowingProduct() == true) {
			Assert.assertTrue(true);

		}

		else if (search.isSearchShowingNoProduct() == true) {
			Assert.assertTrue(false);
			System.out.println("No Product found");
		}
	}

	@Then("the user selects a specific product from the search results with {string}")
	public void selectSpecificProduct(String productName) {

		product = search.getProductFromProductName(productName);

		if (product == null) {
			Assert.assertTrue(false);

		}
	}

	@And("navigates to the product details page")
	public void navigateToProductDetailsPage() {
		search.navigatetoProductDetailsPage(product);
	}
	
	@And("navigates to the first product details page")
	public void navigateToFirstProductDetailsPage() {
		search.navigatetoProductDetailsPage(firstProduct);
	}
	
    @And("the user selects {string} and {string} of product")
    public void userSelectsColorAndSize(String color, String size) {
        WebElement colorElement = pdp.getColorSwatchFromColor(color);
        WebElement sizeElement = pdp.getSizeSwatchFromSizeString(size);
        
        pdp.selectColorAndSize(colorElement, sizeElement);
    }

    @And("the user adds the selected product to the shopping cart")
    public void userAddsProductToShoppingCart() {
    	pdp.clickAddToBag();
    	
    }
    
    @And("the user adds the updated product to the shopping cart")
    public void userAddsUpdatedProductToShoppingCart() throws InterruptedException {
    	checkout.clickOnUpdate();
    	Thread.sleep(5000);
    	
    }

    @Then("user able to see Add to Bag confirmation pop up")
    public void userSeesAddToBagConfirmationPopup() {
        pdp.verifyAddedToBagConfirmation();
    }

    @When("User clicks on Checkout")
    public void userClicksOnCheckout() {
        pdp.clickCheckoutFromSlider();
    }

    @Then("User able to see Cart page with product {string}")
    public void userSeesCartPageWithProduct(String productName) {
       
       
       org.testng.Assert.assertEquals(checkout.getSKUName(), productName);
       
    }
    
    @Then("the user selects first product from the search results")
    public void selectFirstProduct() {
    	 firstProduct = search.getFirstProductFromSearch();
    	 
		if (firstProduct == null) {
			Assert.assertTrue(false);

		}
    	
    }
    
    @And("User increase Quantity and updates {string}")
    public void increaseAndUpdateQuantity(String newQuantity) {
        int Quantity = Integer.parseInt(newQuantity);
    	
        if (Quantity==1) {
        	pdp.increaseQuanity();
		}
        else {
        	for(int qty = 1; qty<Quantity; qty++) {
        		pdp.increaseQuanity();
        	}
		}
        
        
    }
    
    @Then("User validate quantity {string} of product {string} added")
    public void userValidateQuantityOfProductAdded(String quantity, String SKU) {
       int count = checkout.getProductCountinCart(SKU);
        
       System.out.println("count is " +count);
       System.out.println("quantity  is " +quantity);
       
       org.testng.Assert.assertEquals(count, Integer.parseInt(quantity));
    }
}
