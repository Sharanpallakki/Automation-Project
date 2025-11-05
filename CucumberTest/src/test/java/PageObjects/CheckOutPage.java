package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckOutPage {
	public WebDriver driver;
	public CheckOutPage (WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(xpath="//img[@alt='Cart']")
	WebElement cart_btn;
	@FindBy(xpath="//button[text()='PROCEED TO CHECKOUT']")
	WebElement checkout_btn;
	@FindBy(css=".promoBtn")
	WebElement promo_btn;
	@FindBy(xpath="//button[text()='Place Order']")
	WebElement place_ordr_btn;
	@FindBy(css=" td:nth-child(2) p")
	WebElement producton_checkout;
	
	public void cliclcart() {
		cart_btn.click();		
	}
	public void cliclcheckout() {
		checkout_btn.click();		
	}
	public boolean promobuttonisaviliable() {
		return promo_btn.isDisplayed();
	}
	public boolean placeorderbuttonisaviliable() {
		return place_ordr_btn.isDisplayed();
	}
	public String getproductoncheckout() {
		return producton_checkout.getText().split("-")[0].trim();
	}

}
