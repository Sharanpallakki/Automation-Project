package StepDefination;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import PageObjects.CartPage;
import PageObjects.LetsShopLandingPage;
import Utils.GenericUtil;
import Utils.TestBase;
import Utils.TextContextSetup;
import io.cucumber.java.en.Then;

public class CartStepDEfinartion {
	// public WebDriver driver;
	TextContextSetup textcontextsetup;
	LetsShopLandingPage lslp;
	GenericUtil gn;
	CartPage scp;
	public static int amount = 0;

	static int s;
	static int newamount;

	public CartStepDEfinartion(TextContextSetup textcontextsetup) {
		this.textcontextsetup = textcontextsetup;
		// this.lsp=textcontextsetup.pageobjectmanager.getletsshoplogin();
		this.lslp = textcontextsetup.pageobjectmanager.getletsshoplandingpage();
		this.scp = textcontextsetup.pageobjectmanager.getcartpage();

	}

	@Then("delete the follwoing products")
	public void delete_the_follwoing_products(io.cucumber.datatable.DataTable dataTable) throws InterruptedException {
		s = AddProduct.sum;
		System.out.println("total amount" + s);
		lslp.getsize();
		List<String> productList = dataTable.asList();
		for (String product : productList) {
			amount = scp.deleteProductOnCartPage(product);
		}
		System.out.println("productsamountdeleted" + amount);
		newamount = s - amount;
		System.out.println(newamount);
	}

	@Then("The Price should Match correctly {string}")
	public void the_price_should_match_correctly(String string) {
		scp.refersh();
		int sss = scp.getfinalvalue();
		Assert.assertEquals(sss, newamount);
	}

}
