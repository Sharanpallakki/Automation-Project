package PageObjects;

import org.openqa.selenium.WebDriver;

import StepDefination.LandingPageStepDefination;
// this class used only for craeting a objects for each page object class
public class PageObjectManager {
	public WebDriver driver;
	public LandingPage lp;
	public OffersPage op;
	public CheckOutPage cp;
	public LetsShopLogin lsl;
	public LetsShopLandingPage lslp;
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
	public LetsShopLogin getletsshoplogin() {
		lsl=new LetsShopLogin(driver); 
		return lsl;
		
		
	}
	public LetsShopLandingPage getletsshoplandingpage() {
		lslp=new LetsShopLandingPage(driver); 
		return lslp;
		
		
	}
	

}
