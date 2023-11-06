package pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.TestBase;

public class ShoppingCartPage extends TestBase {

	@FindAll(value = { @FindBy(css = "ul li") })
	List<WebElement> items;

	@FindBy(id = "billing-coupon")
	WebElement coupounCheckbox;

	@FindBy(xpath = "//button[contains(text(),'Checkout')]")
	WebElement checkoutBtn;

	@FindBy(xpath = "//button[contains(text(),'Empty Cart')]")
	WebElement emptyCartBtn;

	public ShoppingCartPage() {
		PageFactory.initElements(driver, this);

	}

	public boolean isItemAdded() {

		if (items.size() > 0) {
			return true;
		} else {
			return false;
		}
	}

	public void includeCheckbox() {
		coupounCheckbox.click();
	}

	public void doCheckout() {
		checkoutBtn.click();
	}

	public void emptyTheCart() {
		emptyCartBtn.click();
	}

}
