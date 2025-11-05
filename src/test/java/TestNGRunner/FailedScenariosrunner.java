package TestNGRunner;
//"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
import org.testng.annotations.DataProvider;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features="@target/failedsc.txt",glue="StepDefination",monochrome=true,dryRun=false,tags="@place",plugin= {"html:target/cucumber.html",
		"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
		"rerun:target/failedsc.txt"
		})
public class FailedScenariosrunner extends AbstractTestNGCucumberTests {
	
	@Override
	@DataProvider(parallel=true)
	public Object[][] scenarios(){
		return super.scenarios();
	}

}
