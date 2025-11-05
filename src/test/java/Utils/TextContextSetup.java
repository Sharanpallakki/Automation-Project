package Utils;

import java.io.IOException;

import org.openqa.selenium.WebDriver;

import PageObjects.PageObjectManager;
// this is heart of the framework where we created textcontextsetup class so that the sharing varibales or drivres are declared over here so hat 
public class TextContextSetup {
	public WebDriver driver;
	public String productlandingpage;
	public PageObjectManager pageobjectmanager;
	public GenericUtil genericutil;
	public TestBase testbase;
	
	public TextContextSetup() throws IOException {
		// in testbase we are intilizing the browser so tis driver can be used in stepdefinations files 
		testbase=new TestBase();
		// this is used for pageobject manager will avoid creating a objects in step defination files if u wnat to call call this class with the method
		pageobjectmanager=new PageObjectManager(testbase.WebDriverManager());
		// this is used for generic utils all the reusable methods are de lared in this calss and the methods acn be called by calling genericutil object
		genericutil=new GenericUtil(testbase.WebDriverManager());
	}
	

}
