package PageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utils.GenericUtil;

public class AmazonCart {
	
	public WebDriver driver;
	JavascriptExecutor js;
	static int  removedamount=0;
	
	
	public AmazonCart(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		this.js = (JavascriptExecutor) driver;
	}
	//div[@class='sc-item-content-group']-> list of 
	
	//div[@class='sc-item-content-group']//h4--heading
	//div[@class='sc-item-content-group']//div[@class='sc-item-price-block']//div//div--> amount
	//div[@class='sc-item-content-group']//div[@class='a-row sc-action-links']//button---> button
	@FindBy(xpath="//div[@class='sc-item-content-group']")
	List<WebElement> listofitems;
	@FindBy(xpath="(//div[@data-name='Subtotals'])[1]//span//span")
	WebElement grandtotal;
	WebElement Productnamepricedelete;
	GenericUtil gen=new GenericUtil(driver);
	
	public int deleteproduct(String productname) {
		
		for(WebElement items:listofitems) {
			
			WebElement Productname=items.findElement(By.xpath(".//li[@class='sc-item-product-title-cont']//h4"));
			gen.waitForElementVisible(driver, Productname, 20);
			String pp=Productname.getText().trim();
			if(pp.equalsIgnoreCase(productname)) {
				WebElement Productnameprice=items.findElement(By.xpath(".//div[@class='sc-item-price-block']//div//div"));
				String price=Productnameprice.getText();
				price = price.replaceAll("[^0-9.]", "");   // "65990.00"

				// If there's a decimal part, remove it (we only want integer)
				if (price.contains(".")) {
				    price = price.substring(0, price.indexOf("."));  // "65990"
				}

				// Now parse it as integer
				int priceInt = Integer.parseInt(price);

				System.out.println("Final price: " + priceInt);
				removedamount=removedamount+priceInt;
				System.out.println(removedamount);
				
				try {
					 Productnamepricedelete=items.findElement(By.xpath(".//div[@class='a-row sc-action-links']//button"));
					
					 Productnamepricedelete.click();
					 break;
					
				}catch(Exception e) {
					gen.waitForElementClickable(driver, Productnamepricedelete, 20);
					js.executeScript("arguments[0].click();", Productnamepricedelete);
					break;
					
				}
				
			}
			
		}
		return removedamount;
	}
	public int getcartsie() {
		return listofitems.size();
	}
	public int getgrantotal() {
		String price=grandtotal.getText();
		
		price = price.replaceAll("[^0-9.]", "");

		// 2️⃣ Remove the decimal part (anything after the dot)
		price = price.replaceAll("\\.\\d+", "");

		// 3️⃣ Convert to integer
		int priceInt = Integer.parseInt(price);

		return priceInt;
	}
	

}
