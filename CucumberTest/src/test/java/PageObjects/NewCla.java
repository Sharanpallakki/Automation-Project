package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class NewCla {
WebDriver driver;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
WebDriver driver =new ChromeDriver();
driver.get("https://mvnrepository.com/artifact/org.seleniumhq.selenium/selenium-java/4.28.1");
	}

}
