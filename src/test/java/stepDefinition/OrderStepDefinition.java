package stepDefinition;

import java.security.DrbgParameters.Reseed;
import java.time.Duration;
import java.util.function.Function;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Window;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import base.TestBase;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.CheckOutPage;
import pages.HomePage;
import pages.SearchResultPage;
import pages.ShoppingCartPage;

public class OrderStepDefinition extends TestBase {
	
	HomePage homePage;
	SearchResultPage resultPage;
	ShoppingCartPage cartPage;
	CheckOutPage checkOutPage;
	
	@Given("User is on Home Page")
	public void user_is_on_home_page() {
	    initialize();
	}
	@When("User search an item {string}")
	public void user_search_an_item(String strItem) {
		homePage = new HomePage();
	    homePage.searchItem(strItem);
	    
	}
	@Then("Item must be listed")
	public void item_must_be_listed() {
		resultPage = new SearchResultPage();
		//Assert.assertTrue(resultPage.viewItem());
	    
	}
	
	@Given("User should be on search result page")
	public void user_should_be_on_search_result_page() throws InterruptedException {
		resultPage = new SearchResultPage();
		Thread.sleep(3000);
		resultPage.viewItemDetail();
	}
	@When("User add item to the cart")
	public void user_add_item_to_the_cart() throws InterruptedException {
		resultPage = new SearchResultPage();
		Thread.sleep(3000);
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
//		wait.until(ExpectedCondition(resultPage.add));
		resultPage.addToCart();
	}
	private Function<? super WebDriver, Object> ExpectedCondition(SearchResultPage resultPage2) {
		// TODO Auto-generated method stub
		return null;
	}
	@Then("Item must be added")
	public void item_must_be_added() {
		cartPage = new ShoppingCartPage();
		Assert.assertTrue(cartPage.isItemAdded());
	}
	
	@When("User do checkout")
	public void user_do_checkout() {
		cartPage = new ShoppingCartPage();
		cartPage.doCheckout();
		
	}
	@Then("should navigate to checkout page")
	public void should_navigate_to_checkout_page() throws InterruptedException {
		checkOutPage = new CheckOutPage();
		Thread.sleep(3000);
		checkOutPage.enterName("testname");
		checkOutPage.enterAddress("testaddress");
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollTo(0, document.body.scrllHeight)");
		checkOutPage.selectSinglepackageRadioBtn();
		checkOutPage.buyTheprodut();
		
	}
}
