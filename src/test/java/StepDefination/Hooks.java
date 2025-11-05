package StepDefination;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import Utils.TextContextSetup;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Scenario;

public class Hooks {
	TextContextSetup textcontextsetup;
	public Hooks(TextContextSetup textcontextsetup) {
		this.textcontextsetup=textcontextsetup;
	}
	@After
	public void teardown() throws IOException {
	//	textcontextsetup.testbase.WebDriverManager().quit();
	
	}
	@AfterStep
	public void addScreenshot(Scenario scenario) throws IOException {
		WebDriver driver=textcontextsetup.testbase.WebDriverManager();
		if(scenario.isFailed()) {
		File src=	((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		byte[]content =FileUtils.readFileToByteArray(src);
		scenario.attach(content, "image/jpg", "image");
		}
		
	}
}
