package PageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utils.GenericUtil;

public class LetsShopLandingPage {
	
	public WebDriver driver;
	JavascriptExecutor js ;
	
	
	public LetsShopLandingPage (WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		this.js = (JavascriptExecutor) driver;
	}
	
	@FindBy(xpath="(//button[@tabindex='0'])[1]")
	WebElement Homeicon;
	@FindBy(xpath="(//button[@tabindex='0'])[3]")
	WebElement carticon;
	@FindBy(xpath="//div[@class='cartSection']")
	List<WebElement> productavilibaleincart;
	
	
	  @FindBy(xpath = "//div[@class='card-body']")
	    private List<WebElement> itemstobeadded;
	  @FindBy(xpath="//div[@class='card-body']//button[@class='btn w-10 rounded']")
	  WebElement add_cart_btn;
	  
	  public  void selectproduct( String productList) {
		  GenericUtil gen=new GenericUtil(driver);
	        

	        for (WebElement element : itemstobeadded) {
	        WebElement nameElement = element.findElement(By.xpath("//b"));
	        String fullText = element.getText().trim();
	     // Split by new line and take the first line
	     String actualtext = fullText.split("\\n")[0].trim();
//	            System.out.println("Checking element text: " + actualtext);

	            if (actualtext.equalsIgnoreCase(productList)) {
	            	WebElement el=element.findElement(By.xpath(".//button[@class='btn w-10 rounded']"));
	            	gen.waitForElementClickable(driver, el, 30);
	            	try {
	            		el.click();
	            	}catch(Exception e) {
	            		js.executeScript("arguments[0].click();", el);
	            	}
	                
	                break;
	            
	        }
	        }
	  }

	   
	  
	public String getcurrenturl() {
		String currenturl=driver.getCurrentUrl();
		return currenturl;
	}
	public boolean homeiconvisible() {
		return Homeicon.isDisplayed();
		
	}
	public int getsize() {
		//carticon.click();
		js.executeScript("arguments[0].click();", carticon);
		 int size = productavilibaleincart.size();
		 return size;
	}
	
	

}
