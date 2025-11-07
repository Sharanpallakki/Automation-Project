package PageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utils.GenericUtil;

public class AmazonPageobjectland {
	public WebDriver driver;
	JavascriptExecutor js;
	
	public AmazonPageobjectland(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		this.js = (JavascriptExecutor) driver;
	}
	GenericUtil gen=new GenericUtil(driver);
	WebElement btn;
	static int sum=0;
	@FindBy(xpath="//input[@id='twotabsearchtextbox']")
	WebElement input_bx;
	@FindBy(xpath="//input[@id='nav-search-submit-button']")
	WebElement input_bx_search;
	@FindBy(xpath="//div[@class='a-row a-spacing-base a-spacing-top-small ewc-go-to-cart celwidget']//a")
	WebElement addtocart_btn;
	//div[@data-cy='price-recipe']//div//a//span//span-->amount
	//div[@class='puisg-col puisg-col-4-of-4 puisg-col-4-of-8 puisg-col-8-of-12 puisg-col-8-of-16 puisg-col-12-of-20 puisg-col-12-of-24 puis-list-col-right']//a[@class='a-link-normal s-line-clamp-2 s-line-clamp-3-for-col-12 s-link-style a-text-normal']//span
	@FindBy(xpath="//div[@class='puisg-col puisg-col-4-of-4 puisg-col-4-of-8 puisg-col-8-of-12 puisg-col-8-of-16 puisg-col-12-of-20 puisg-col-12-of-24 puis-list-col-right']")
	List<WebElement> items;
	public int additems(String itenmae) {
		for(WebElement element:items) {
			WebElement elementname=element.findElement(By.xpath(".//a[@class='a-link-normal s-line-clamp-2 s-line-clamp-3-for-col-12 s-link-style a-text-normal']//span"));
			String name=elementname.getText().trim();
			if(name.contains(itenmae)) {
				
				WebElement price_txt=element.findElement(By.xpath(".//div[@data-cy='price-recipe']//a//span"));
				String price=price_txt.getText();
				price = price.replaceAll("[^0-9]", "");
				Integer price1=Integer.parseInt(price);
				System.out.println(price);
				sum=sum+price1;
				System.out.println("total sum"+sum);
				try {
					 btn=element.findElement(By.xpath(".//button"));
					btn.click();
					
				}catch(Exception e) {
					gen.waitForElementClickable(driver, btn, 20);
					js.executeScript("arguments[0].click();", btn);
					
				}
				}
			}
		return sum;
		}
	
	public void enete(String name) {
		input_bx.sendKeys(name);
		input_bx_search.click();
	}
	public void gotocart() {
		addtocart_btn.click();
	}
	}

