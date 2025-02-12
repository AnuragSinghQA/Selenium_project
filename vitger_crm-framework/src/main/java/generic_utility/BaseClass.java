package generic_utility;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import object_repository.LoginPage;
import object_repository.LogoutPage;

public class BaseClass {
	FileUtility fu = new FileUtility();

	public WebDriver driver;

	@BeforeClass (groups = {"SmokeTest","RegresstionTest"})
	public void selectBrowser() throws IOException {

		if (fu.getDataFromProp("bro").equalsIgnoreCase("chrome"))
			driver = new ChromeDriver();
		else if (fu.getDataFromProp("bro").equalsIgnoreCase("edge"))
			driver = new EdgeDriver();
		else if (fu.getDataFromProp("bro").equalsIgnoreCase("safari"))
			driver = new SafariDriver();
		else if (fu.getDataFromProp("bro").equalsIgnoreCase("Firefox"))
			driver = new FirefoxDriver();
		else
			driver = new ChromeDriver();

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
	}

	@BeforeMethod (groups = {"SmokeTest","RegresstionTest"})
	public void login() throws IOException {
		String name = fu.getDataFromProp("un");
		String pass = fu.getDataFromProp("pass");
		LoginPage lp = new LoginPage(driver);
		driver.get(fu.getDataFromProp("url"));
		lp.getUsername().sendKeys(name);
		lp.getPassword().sendKeys(pass);
		lp.getSubmit().click();
	}

	@AfterMethod
	public void logout() throws InterruptedException {
		LogoutPage lg = new LogoutPage(driver);
		Actions acc = new Actions(driver);
		acc.moveToElement(lg.getProfile()).click().build().perform();
		Thread.sleep(1000);
		acc.moveToElement(lg.getSignout()).click().build().perform();
	}

	@AfterClass
	public void closeBrowser() {
		driver.close();
	}

}
