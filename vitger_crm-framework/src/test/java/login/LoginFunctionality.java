package login;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import generic_utility.DataProviderImp;
import object_repository.LoginPage;

public class LoginFunctionality {
	WebDriver driver = new ChromeDriver();

	
	@Test(dataProvider = "add", dataProviderClass = DataProviderImp.class)
	public void loginFunctionality(String userId, String Password) throws InterruptedException {
		driver.get("http://localhost:8888/");
		LoginPage lp = new LoginPage(driver);
		lp.getUsername().sendKeys(userId);
		lp.getPassword().sendKeys(Password);
		
		lp.getSubmit().click();
		Thread.sleep(10000);
	}

}
