package StepDefination;

import org.testng.Assert;

import PageObjects.CheckOutPage;
import PageObjects.PageObjectManager;
import Utils.TextContextSetup;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CheckOutStepDefination {
	PageObjectManager pageobjectmanager;
	
	 TextContextSetup textcontextsetup;
	 CheckOutPage cp;
	public CheckOutStepDefination(TextContextSetup textcontextsetup) {
		this.textcontextsetup=textcontextsetup;
		this.cp=	textcontextsetup.pageobjectmanager.getcheckoutPage();
	}

	
	
	
	
	@Then("User Proceeds to checkout anf validate the <name> items in checkout page")
	public void user_proceeds_to_checkout_anf_validate_the_name_items_in_checkout_page() {
	
	cp.cliclcart();
	cp.cliclcheckout();
	   
	}
	@Then("Verify usrt has ability to enter promo code and place the order")
	public void verify_usrt_has_ability_to_enter_promo_code_and_place_the_order() {
		
		Assert.assertTrue(cp.promobuttonisaviliable());
		Assert.assertTrue(cp.placeorderbuttonisaviliable());
		String check=cp.getproductoncheckout();
		
		System.out.println(check);
		Assert.assertEquals(check, textcontextsetup.productlandingpage);
	   
	}
}
