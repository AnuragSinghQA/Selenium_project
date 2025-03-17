package generic_utility;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
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
		else if (Browser.equalsIgnoreCase("edge"))
		{
			System.setProperty("webdriver.edge.driver", "‪C:\\Users\\asjad\\Downloads\\edgedriver_win64\\msedgedriver.exe");

			// Configure EdgeOptions
			EdgeOptions options = new EdgeOptions();
			options.addArguments("--no-sandbox");
			options.addArguments("--disable-dev-shm-usage");
			options.addArguments("--remote-debugging-port=9222");
			options.addArguments("--headless"); // Add this for headless mode

			// Initialize EdgeDriver
			driver = new EdgeDriver(options);
		}
		else if (Browser.equalsIgnoreCase("safari"))
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
		acc.moveToElement(lg.getProfile()).click().build().perform();
		Thread.sleep(1000);
		acc.moveToElement(lg.getSignout()).click().build().perform();
	}

	@AfterClass(groups = { "SmokeTest", "RegressionTest" })
	public void closeBrowser() {
		driver.quit();
	}

}
