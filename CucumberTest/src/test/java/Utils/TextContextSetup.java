package Utils;

import java.io.IOException;

import org.openqa.selenium.WebDriver;

import PageObjects.PageObjectManager;

public class TextContextSetup {
	public WebDriver driver;
	public String productlandingpage;
	public PageObjectManager pageobjectmanager;
	public GenericUtil genericutil;
	public TestBase testbase;
	
	public TextContextSetup() throws IOException {
		testbase=new TestBase();
		pageobjectmanager=new PageObjectManager(testbase.WebDriverManager());
		
		genericutil=new GenericUtil(testbase.WebDriverManager());
	}
	

}
