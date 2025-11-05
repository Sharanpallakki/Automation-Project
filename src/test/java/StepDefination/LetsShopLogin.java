package StepDefination;

import org.testng.Assert;

import PageObjects.LetsShopLandingPage;
import Utils.GenericUtil;
import Utils.TextContextSetup;
import io.cucumber.java.en.*;

public class LetsShopLogin {
	TextContextSetup textcontextsetup;
	PageObjects.LetsShopLogin lsp;
	LetsShopLandingPage lslp;
	GenericUtil gn;
	
	public LetsShopLogin(TextContextSetup textcontextsetup) {
		this.textcontextsetup=textcontextsetup;
		this.lsp=textcontextsetup.pageobjectmanager.getletsshoplogin();
		this.lslp=textcontextsetup.pageobjectmanager.getletsshoplandingpage();
		
	}
	
	
	
	
	
	@Given("launch the browser")
	public void launch_the_browser() {
	    
	}
	@When("user enters {string} and {string}")
	public void user_enters_and(String username, String pass) throws InterruptedException {
		lsp.enterusernameandpassword(username, pass);
		Thread.sleep(3000);
	    
	}

		
	    
	

	
	@Then("user is able to login to appliaction")
	public void user_is_able_to_login_to_appliaction() throws InterruptedException {
		gn.waitForElementClickable(textcontextsetup.driver,textcontextsetup.pageobjectmanager.getletsshoplogin().logib_btn , 30);
		lsp.clicklogin();
		Thread.sleep(3000);
		boolean status=lslp.homeiconvisible();
		Assert.assertEquals(status, true);
	    
	}
	@Then("verify the title should be {string}")
	public void verify_the_title_should_be(String url) {
		String currenturl=lslp.getcurrenturl();
		Assert.assertEquals(url, currenturl);
		
	   
	}

}
