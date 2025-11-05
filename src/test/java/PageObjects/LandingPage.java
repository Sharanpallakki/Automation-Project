package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LandingPage {
	public WebDriver driver;
	public LandingPage (WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	//page factory
	@FindBy(xpath="//input[@type='search']")
	WebElement serach_btn;
	@FindBy(css="h4.product-name")
	WebElement product_landing;
	@FindBy(css="a.increment")
	WebElement increment;
	@FindBy(xpath="//button[text()='ADD TO CART']")
	WebElement addtocart_btn;
	
	@FindBy(linkText="Top Deals")
	WebElement top_deals_txt;
	//Action methods
	public void searchproductonlanding(String Productname) {
		serach_btn.sendKeys(Productname);
	}
	
	public String exatactproductlandingpage() {
		return product_landing.getText().split("-")[0].trim();
	}
	public void gotodeals() {
		top_deals_txt.click();
	}
	
	public void addincrement(int quantity) {
		int i=quantity-1;
		while(i>0) {
			increment.click();
			i--;
			
		}
	}
	public void addtocart() {
		addtocart_btn.click();
	}
	
		
	

}
