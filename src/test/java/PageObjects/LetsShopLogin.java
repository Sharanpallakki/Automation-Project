package PageObjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LetsShopLogin {
	
	
		public WebDriver driver;
		 JavascriptExecutor js;
		public LetsShopLogin (WebDriver driver) {
			this.driver=driver;
			PageFactory.initElements(driver, this);
			 this. js = (JavascriptExecutor) driver;
		        
		}
		
		@FindBy(id="userEmail")
		WebElement usename;
		@FindBy(id="userPassword")
		WebElement password;
	public	@FindBy(xpath="(//input[@id='login'])")
		WebElement logib_btn;
		
		public void enterusernameandpassword(String usernam,String Password) {
			usename.sendKeys(usernam);		
			
			password.sendKeys(Password);
			}
		public void clicklogin() {
			js.executeScript("arguments[0].click();", logib_btn);
		//	js.executeScript(null, null)
			//password.click();
			
		}
	

}
