package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.TestBase;

public class HomePage extends TestBase {

	@FindBy(name = "searchbar")
	WebElement searchInputBox;

	@FindBy(id = "button-search")
	WebElement searchButton;

	@FindBy(id = "cart")
	WebElement cartButton;

	public HomePage() {
		PageFactory.initElements(driver, this);
	}

	public void naviagteToCartPage() {
		cartButton.click();
	}

	public void searchItem(String strItem) {
		searchInputBox.sendKeys(strItem);
		searchButton.click();
	}
}
