package PageObjects;

import org.openqa.selenium.WebDriver;

public class PageObjectManager {
	public WebDriver driver;
	public LandingPage lp;
	public OffersPage op;
	public CheckOutPage cp;
	
	public PageObjectManager(WebDriver driver) {
		this.driver=driver;
	}
	
	public LandingPage getLanadingpage() {
		lp=new LandingPage(driver);
		return lp;
		
		
	}
	public OffersPage getOffersPage() {
		op=new OffersPage(driver);
		return op;
		
		
	}
	public CheckOutPage getcheckoutPage() {
		cp=new CheckOutPage(driver);
		return cp;
		
		
	}

}
