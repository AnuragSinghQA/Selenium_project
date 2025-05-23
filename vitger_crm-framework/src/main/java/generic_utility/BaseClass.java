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
import org.testng.annotations.Parameters;

import object_repository.LoginPage;
import object_repository.LogoutPage;

public class BaseClass {

	private static ThreadLocal<WebDriver> sdriver = new ThreadLocal<WebDriver>();

	FileUtility fu = new FileUtility();
	public WebDriver driver;
//	public static WebDriver driver;

	@Parameters("Browser")
	@BeforeClass(groups = { "SmokeTest", "RegressionTest" })
	public void selectBrowser(String Browser) throws IOException {

		if (Browser.equalsIgnoreCase("Chrome"))
			driver = new ChromeDriver();
		else if (Browser.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();
		} else if (Browser.equalsIgnoreCase("safari"))
			driver = new SafariDriver();
		else if (Browser.equalsIgnoreCase("Firefox"))
			driver = new FirefoxDriver();
		else
			driver = new ChromeDriver();

		sdriver.set(driver);
		driver = getDriver();

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
	}

	public static WebDriver getDriver() {

		return sdriver.get();
	}

	@BeforeMethod(groups = { "SmokeTest", "RegressionTest" })
	public void login() throws IOException {
		String name = fu.getDataFromProp("un");
		String pass = fu.getDataFromProp("pass");
		LoginPage lp = new LoginPage(driver);
		driver.get(fu.getDataFromProp("url"));
		lp.getUsername().sendKeys(name);
		lp.getPassword().sendKeys(pass);
		lp.getSubmit().click();
	}

	@AfterMethod(groups = { "SmokeTest", "RegressionTest" })
	public void logout() throws InterruptedException {
		LogoutPage lg = new LogoutPage(driver);
		Actions acc = new Actions(driver);
		acc.moveToElement(lg.getProfile()).click().perform();
		Thread.sleep(2000);
		acc.moveToElement(lg.getSignout()).click().perform();
	}

	@AfterClass(groups = { "SmokeTest", "RegressionTest" })
	public void closeBrowser() {
		driver.quit();
	}

}
