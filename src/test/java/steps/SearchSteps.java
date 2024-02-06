package steps;

import io.cucumber.java.en.When;
import junit.framework.Assert;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import Page.LoginPage;
import Page.PDPage;
import Page.SearchPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class SearchSteps {
	WebDriver driver;
	Page.MainPage main;
	Page.SearchPage search;
	Page.PDPage pdp ;
	WebElement product;
	private static final Logger LOGGER = LogManager.getLogger(SearchSteps.class);

	public SearchSteps() {
		driver = Hooks.getDriver();
		search = new SearchPage(driver);
		pdp = new PDPage(driver);

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

    @Then("user able to see Add to Bag confirmation pop up")
    public void userSeesAddToBagConfirmationPopup() {
        // Implementation to verify the presence of the Add to Bag confirmation popup
    }

    @When("User clicks on Checkout")
    public void userClicksOnCheckout() {
        // Implementation for clicking on the Checkout button
    }

    @Then("User able to see Cart page with product {string}")
    public void userSeesCartPageWithProduct(String productName) {
        // Implementation to verify that the Cart page displays the specified product
    }
}
