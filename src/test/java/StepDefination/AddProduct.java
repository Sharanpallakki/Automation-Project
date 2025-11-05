package StepDefination;

import java.util.List;

import org.testng.Assert;

import PageObjects.LetsShopLandingPage;
import Utils.GenericUtil;
import Utils.TextContextSetup;
import io.cucumber.java.en.*;

public class AddProduct {
	TextContextSetup textcontextsetup;
	
	LetsShopLandingPage lslp;
	GenericUtil gn;
	public AddProduct(TextContextSetup textcontextsetup) {
		this.textcontextsetup=textcontextsetup;
	//	this.lsp=textcontextsetup.pageobjectmanager.getletsshoplogin();
		this.lslp=textcontextsetup.pageobjectmanager.getletsshoplandingpage();
		
	}
	
	
	
	
	@When("user adds the following products to the cart")
	public void user_adds_the_following_products_to_the_cart(io.cucumber.datatable.DataTable dataTable) {
		List<String> productList = dataTable.asList();
		  for (String product : productList) {
	            lslp.selectproduct(product);
	        }
		int curentsize=lslp.getsize();
		Assert.assertEquals(curentsize, 2);
	    
	   
	}
	@Then("all selected products should be added successfully")
	public void all_selected_products_should_be_added_successfully() {
	    
	}
}
