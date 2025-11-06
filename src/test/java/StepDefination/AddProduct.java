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
	int sum=0;
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
	
		
	    
	   
	}
	@Then("the cart should contain the following products:")
	public void the_cart_should_contain_the_following_products(List<String> expectedProducts) {
		Assert.assertTrue(scp.verifyProducts(expectedProducts));
	    
	}
	@When("user adds the following products to the cart and get the price")
	public void user_adds_the_following_products_to_the_cart_and_get_the_price(io.cucumber.datatable.DataTable dataTable) {
		List<String> productList = dataTable.asList();
		  for (String product : productList) {
	            
			sum= lslp. getproductamount(product);
	        }
	   
	}
	
	@Then("total amount should be {string}")
	public void total_amount_should_be(String string) {
		Integer value=Integer.valueOf(string);
		Assert.assertEquals(sum, value);
	   
	}
}
