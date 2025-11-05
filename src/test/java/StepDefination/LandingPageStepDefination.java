package StepDefination;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import PageObjects.LandingPage;
import PageObjects.LetsShopLandingPage;
import PageObjects.OffersPage;
import PageObjects.PageObjectManager;
import Utils.TextContextSetup;
import io.cucumber.java.en.*;

public class LandingPageStepDefination{
	public WebDriver driver;
	//LandingPage lp;
	String productlandingpage;
	PageObjectManager pageobjectmanager;
	LandingPage lp;
	LetsShopLandingPage lslp;
	
	 TextContextSetup textcontextsetup;
	public LandingPageStepDefination(TextContextSetup textcontextsetup) {
		this.textcontextsetup=textcontextsetup;
		this.lp=textcontextsetup.pageobjectmanager.getLanadingpage();
		
	}
	
	@Given("user landed on the landing page")
	public void user_landed_on_the_landing_page() {
		//textcontextsetup.driver=new ChromeDriver();
	//	textcontextsetup.driver.manage().window().maximize();
		//textcontextsetup.driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
	    
	}
	@When("^user serach the short text (.+) on the landing page and extract the product$")
	public void user_serach_the_short_text_on_the_landing_page_and_extract_the_product(String product) throws InterruptedException {
		
		   lp.searchproductonlanding(product);
		   Thread.sleep(2000);
		   textcontextsetup.productlandingpage=lp.exatactproductlandingpage();
		 //  lp.gotodeals();
	}
	/*@When("^Added (.+) items of the selected product to cart$")
	public void added_items_of_the_selected_product_to_cart(int quantity ) {
		
		lp.addincrement(quantity);
		lp.addtocart();
	}*/
	@When("Added {string} items of the selected product to cart")
	public void added_items_of_the_selected_product_to_cart(String quanity) {
		lp.addincrement(Integer.parseInt(quanity));
		lp.addtocart();
	}
	
}
