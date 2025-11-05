package Utils;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebDriver;

public class GenericUtil {
	public WebDriver driver;
	public GenericUtil(WebDriver driver) {
		this.driver=driver;
		
	}
	public void Switchto() {
		Set<String>windows=driver.getWindowHandles();
		Iterator<String> it=windows.iterator();
		String parent=it.next();
		String child=it.next();
		driver.switchTo().window(child);
	}

}
