package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.TestBase;

public class SearchResultPage extends TestBase {

	@FindBy(xpath = "//button[text()='Add to cart']")
	WebElement addToCartBtn;
	
	@FindBy(css = "ul li.preview")
	WebElement itemIcon;

	public SearchResultPage() {
		PageFactory.initElements(driver, this);
	}
	
	public void viewItem() {
		itemIcon.isDisplayed();
		
	}
	
	public void viewItemDetail() {
		itemIcon.click();
	}

	public void addToCart() {
		addToCartBtn.click();
	}
}
