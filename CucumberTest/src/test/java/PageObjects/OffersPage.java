package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OffersPage {
	public WebDriver driver;
	public OffersPage (WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	//page factory
	@FindBy(id="search-field")
	WebElement serach_btn;
	@FindBy(css="tr td:nth-child(1)")
	WebElement product_offer;
	//Action methods
	public void serachproductonoffer(String Productname) {
		serach_btn.sendKeys(Productname);
	}
	public String getproductonoffer() {
		return product_offer.getText();
	}

}
