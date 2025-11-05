package StepDefination;

import java.io.IOException;

import Utils.TextContextSetup;
import io.cucumber.java.After;

public class Hooks {
	TextContextSetup textcontextsetup;
	public Hooks(TextContextSetup textcontextsetup) {
		this.textcontextsetup=textcontextsetup;
	}
	@After
	public void teardown() throws IOException {
		textcontextsetup.testbase.WebDriverManager().quit();
	
	}

}
