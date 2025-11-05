package Utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
// this class belongs for inizatlzation of browser
public class TestBase {
	public WebDriver driver;
	
	public WebDriver WebDriverManager() throws IOException {
		
		Properties prop=new Properties();
		//C:\\Users\\user\\Desktop\\Sharan Documemnts\\
		 System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"//Driver//chromedriver.exe");
		FileInputStream fis=new FileInputStream(System.getProperty("user.dir")+"//src//test//Resources//Global.properties");
		prop.load(fis);
		String browsername=prop.getProperty("browser");
		if(driver==null) {
			if(browsername.equalsIgnoreCase("chrome")) {
			driver=new ChromeDriver();
		}
		else if(browsername.equalsIgnoreCase("edge")) {
			driver=new EdgeDriver();
		}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.get(prop.getProperty("url"));
		
	}

		return driver;

	}
}


