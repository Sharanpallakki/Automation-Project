package PageObjects;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import StepDefination.AddProduct;
import Utils.GenericUtil;

public class CartPage {
	public WebDriver driver;
	JavascriptExecutor js;
	AddProduct sp;
	public static int amo = 0;

	public CartPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		this.js = (JavascriptExecutor) driver;
	}

	@FindBy(xpath = "//div[@class='cartSection']//h3")
	List<WebElement> productsaddedlist;
	@FindBy(xpath = "//ul[@class='cartWrap ng-star-inserted']")
	List<WebElement> addedproducts;
	@FindBy(xpath = "(//li[@class='totalRow'])[2]/span[2]")
	WebElement tolamounttxt;

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

	public int deleteProductOnCartPage(String productToDelete) {
		GenericUtil gen = new GenericUtil(driver);
		JavascriptExecutor js = (JavascriptExecutor) driver;

		// Use a loop that refetches elements each time
		List<WebElement> addedProducts = driver.findElements(By.xpath("//ul[@class='cartWrap ng-star-inserted']")); // adjust
																													// selector

		for (int i = 0; i < addedProducts.size(); i++) {
			try {
				// Re-fetch elements every iteration (important!)
				addedProducts = driver.findElements(By.xpath("//ul[@class='cartWrap ng-star-inserted']"));

				WebElement el = addedProducts.get(i);
				WebElement productNameElement = el.findElement(By.xpath(".//div[@class='infoWrap']//h3"));
				String productName = productNameElement.getText().trim();

				if (productName.equalsIgnoreCase(productToDelete)) {
					WebElement amountinstring = el.findElement(By.xpath(".//div[@class='prodTotal cartSection']/p"));
					String amount = amountinstring.getText().trim().split(" ")[1];
					Integer am = Integer.parseInt(amount);
					amo = amo + am;
					WebElement removeBtn = el
							.findElement(By.xpath(".//div[@class='cartSection removeWrap']//button[2]"));

					try {
						gen.waitForElementClickable(driver, removeBtn, 20);
						removeBtn.click();
					} catch (StaleElementReferenceException e) {
						// Try again by re-finding the element and clicking with JS
						addedProducts = driver.findElements(By.cssSelector(".cartSection"));
						el = addedProducts.get(i);
						removeBtn = el.findElement(By.xpath(".//div[@class='cartSection removeWrap']//button[2]"));

						gen.waitForElementClickable(driver, removeBtn, 20);
						js.executeScript("arguments[0].click();", removeBtn);
					}
					break; // stop after deleting
				}
			} catch (StaleElementReferenceException e) {
				// Re-fetch list if the DOM changed before finishing iteration
				addedProducts = driver.findElements(By.cssSelector(".cartSection"));
				i--; // retry current index
			}
		}
		return amo;
	}

	public int getfinalvalue() {
		String t = tolamounttxt.getText();
		String cleanAmount = t.replace("$", "");
		Integer ammm = Integer.parseInt(cleanAmount);
		return ammm;

	}

	public void refersh() {
		driver.navigate().refresh();
	}
}
