package PageObjects;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage {
	public WebDriver driver;
	public CartPage (WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//div[@class='cartSection']//h3")
	List<WebElement> productsaddedlist;
	
	 public List<String> getProductDetails() {
	        List<String> productNames = new ArrayList<>();
	        for (WebElement product : productsaddedlist) {
	            String name = product.getText().trim().toLowerCase();
	            if (!name.isEmpty()) { // Only add non-empty names
	                productNames.add(name);
	            }
	        }
	        return productNames;
	    }

	    // Verify if products match exactly the expected list
	 public boolean verifyProducts(List<String> expectedProducts) {
		    // Get actual product names
		    List<String> actualProducts = getProductDetails();

		    System.out.println("Actual Products: " + actualProducts);
		    System.out.println("Expected Products: " + expectedProducts);

		    // Convert both lists to lowercase for case-insensitive comparison
		  

		    List<String> expectedLower = new ArrayList<>();
		    for (String s : expectedProducts) {
		        expectedLower.add(s.toLowerCase().trim());
		    }

		    // Compare the lists
		    return actualProducts.equals(expectedLower);
		}
	}


