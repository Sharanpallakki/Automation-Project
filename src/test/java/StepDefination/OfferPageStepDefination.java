package StepDefination;

import java.util.Iterator;
import java.util.Set;

import org.testng.Assert;

import PageObjects.OffersPage;
import Utils.TextContextSetup;
import io.cucumber.java.en.Then;

public class OfferPageStepDefination {
	TextContextSetup textcontextsetup;
	OffersPage op;
	String  productofferpage;
	public OfferPageStepDefination(TextContextSetup textcontextsetup) {
		this.textcontextsetup=textcontextsetup;
	}
	@Then("^search the same short text (.+) on offerspage$")
	public void search_the_same_short_text_on_offerspage(String product) {
		
		OffersPage op=textcontextsetup.pageobjectmanager.getOffersPage();
		textcontextsetup.genericutil.Switchto();
		
		op.serachproductonoffer(product);
		 productofferpage=op.getproductonoffer();
	   
	}
	@Then("validate both Text on landingpage and offerspage")
	public void validate_both_text_on_landingpage_and_offerspage() {
		Assert.assertEquals(productofferpage, textcontextsetup.productlandingpage);
	   
	}


}
