package generic_utility;

import java.util.Set;

import org.openqa.selenium.WebDriver;

public class WebDriverUtility {
	WebDriver driver;

	public WebDriverUtility(WebDriver driver) {
		this.driver = driver;
	}
	public void switchTo(String url) {
		Set<String> ids = driver.getWindowHandles();
		for (String id : ids) {
			driver.switchTo().window(id);
			if (driver.getCurrentUrl().contains(url))
				break;
		}
	}
	
}
