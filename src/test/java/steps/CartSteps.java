package steps;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import Page.CheckoutPage;
import Page.PDPage;
import Page.SearchPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CartSteps {

	WebDriver driver;
	Page.MainPage main;
	Page.SearchPage search;
	Page.PDPage pdp;
	Page.CheckoutPage checkout;
	WebElement product;
	WebElement firstProduct;
	private static final Logger LOGGER = LogManager.getLogger(SearchSteps.class);

	public CartSteps() {
		driver = Hooks.getDriver();
		search = new SearchPage(driver);
		pdp = new PDPage(driver);
		checkout = new CheckoutPage(driver);
	}

	@When("User click on edit")
	public void userClickOnEdit() {
		checkout.clickOnEdit();
	}

//	@And("User increase Quantity and updates {string}")
//	public void userIncreaseQuantityAndUpdates(String increaseQuantity) {
//		int Quantity = Integer.parseInt(increaseQuantity);
//
//		if (Quantity == 1) {
//			pdp.increaseQuanity();
//		} else {
//			for (int qty = 1; qty < Quantity; qty++) {
//				pdp.increaseQuanity();
//			}
//		}
//		
//	}

	@Then("User verify updated quantity of product {string} in cart as total of {string} and {string}")
	public void userVerifyUpdatedQuantityInCart(String product , String quantity, String increaseQuantity) {
		int updatedQuantity = Integer.parseInt(quantity) + Integer.parseInt(increaseQuantity);
		
		int quantityInCart =  checkout.getProductCountinCart(product);
		
		System.out.println("Addition :" + updatedQuantity );
		System.out.println(quantityInCart);
		Assert.assertEquals(updatedQuantity, quantityInCart);
		
	}
}
