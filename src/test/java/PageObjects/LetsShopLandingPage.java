package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LetsShopLandingPage {
	
	public WebDriver driver;
	public LetsShopLandingPage (WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="(//button[@tabindex='0'])[1]")
	WebElement Homeicon;
	
	public String getcurrenturl() {
		String currenturl=driver.getCurrentUrl();
		return currenturl;
	}
	public boolean homeiconvisible() {
		return Homeicon.isDisplayed();
		
	}

}
