package StepDefination;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;

import PageObjects.CartPage;
import PageObjects.LetsShopLandingPage;
import Utils.GenericUtil;
import Utils.TextContextSetup;
import io.cucumber.java.en.*;

public class AddProduct {
	TextContextSetup textcontextsetup;
	
	LetsShopLandingPage lslp;
	GenericUtil gn;
	CartPage scp;
	public AddProduct(TextContextSetup textcontextsetup) {
		this.textcontextsetup=textcontextsetup;
	//	this.lsp=textcontextsetup.pageobjectmanager.getletsshoplogin();
		this.lslp=textcontextsetup.pageobjectmanager.getletsshoplandingpage();
		this.scp=textcontextsetup.pageobjectmanager.getcartpage();
		
	}
	
	
	
	
	@When("user adds the following products to the cart")
	public void user_adds_the_following_products_to_the_cart(io.cucumber.datatable.DataTable dataTable) {
		List<String> productList = dataTable.asList();
		  for (String product : productList) {
	            lslp.selectproduct(product);
	        }
		int curentsize=lslp.getsize();
		Assert.assertEquals(curentsize, 3);
//		List<WebElement>addeditems=scp.getproductdetails();
		
	    
	   
	}
	@Then("the cart should contain the following products:")
	public void the_cart_should_contain_the_following_products(List<String> expectedProducts) {
		Assert.assertTrue(scp.verifyProducts(expectedProducts));
	    
	}
}
