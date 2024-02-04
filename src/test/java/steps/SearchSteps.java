package steps;

import io.cucumber.java.en.When;
import junit.framework.Assert;

import org.openqa.selenium.WebDriver;

import Page.LoginPage;
import Page.SearchPage;
import io.cucumber.java.en.Then;

public class SearchSteps {
	WebDriver driver;
	Page.MainPage main;
	Page.SearchPage search;

	public SearchSteps() {
		driver = Hooks.getDriver();
		search = new SearchPage(driver);
	}

	@When("User clicks search icon")
	public void userClicksSearchIcon() {
		search.clickSearchIcon();
	}

	@When("User enters search input {string}")
	public void userEntersSearchInput(String search) {
		this.search.enterSearchText(search);
	}

	@Then("User able to see search result")
	public void userAbleToSeeSearchResult() {
		
		if (search.isSearchShowingProduct()==true) {
			Assert.assertTrue(true);
			
		}
		
		else if(search.isSearchShowingNoProduct()==true) {
			Assert.assertTrue(false);
			System.out.println("No Produc found");
		}
	}
}
