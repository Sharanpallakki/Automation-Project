package StepDefination;

import java.util.List;

import org.testng.Assert;

import PageObjects.AmazonCart;
import PageObjects.AmazonPageobjectland;
import Utils.TextContextSetup;
import io.cucumber.java.en.*;

public class Amazonstepdeifination {
	
	TextContextSetup textcontextsetup;
	AmazonPageobjectland app;
	AmazonCart ac;
	int total;
	int removedamount;
	int finalamount;
	public Amazonstepdeifination(TextContextSetup textcontextsetup) {
		this.textcontextsetup = textcontextsetup;
		// this.lsp=textcontextsetup.pageobjectmanager.getletsshoplogin();
		//this.lslp = textcontextsetup.pageobjectmanager.getletsshoplandingpage();
		//this.scp = textcontextsetup.pageobjectmanager.getcartpage();
		this.app=textcontextsetup.pageobjectmanager.getamazon();
		this.ac=textcontextsetup.pageobjectmanager.getamazoncart();
		

	}
	@Given("user open the amzon")
	public void user_open_the_amzon() {
		
	    
	}
	@When("user search {string}")
	public void user_search(String string) {
		app.enete(string);
	   
	}
	@When("user serch i phone and add phones which contain {string}")
	public void user_serch_i_phone_and_add_phones_which_contain(String string) {
		 total=app.additems(string);
		
	   
	}
	@Then("user add the phones to cart and get the size")
	public void user_add_the_phones_to_cart_and_get_the_size() {
		app.gotocart();
		int ss=ac.getcartsie();
		System.out.println("cart size"+ss);
		
	    
	}
	@Then("I delete the following products")
	public void i_delete_the_following_products(io.cucumber.datatable.DataTable dataTable) {
		List<String>products=dataTable.asList();
		for(String p:products) {
			 removedamount=ac.deleteproduct(p);
		}
	   
	}
	@When("I calculate the total price")
	public void i_calculate_the_total_price() {
		 finalamount=total-removedamount;
		
	    
	}
	@Then("the calculated price should match")
	public void the_calculated_price_should_match() {
		int grandtotal=ac.getgrantotal();
		Assert.assertEquals(finalamount, grandtotal);
	  
	}

}
