package generic_utility;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class LoginandLogout {
	public static WebDriver  driver;

	public static void login() throws IOException {
		FileUtility fu = new FileUtility();
		String Browser = fu.getDataFromProp("url");
		String name = fu.getDataFromProp("un");
		String pass = fu.getDataFromProp("pass");

		driver = fu.selectBrowser();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.get(Browser);
		driver.findElement(By.xpath("//input[@name='user_name']")).sendKeys(name);
		driver.findElement(By.xpath("//input[@name='user_password']")).sendKeys(pass);
		driver.findElement(By.id("submitButton")).click();

	}
	
	public static void logout() throws InterruptedException {
		
		Actions acc = new Actions(driver);
		acc.moveToElement(driver.findElement(By.xpath("//span[text()=' Administrator']/../following-sibling::td[1]"))).click().build().perform();
		Thread.sleep(1000);
		acc.moveToElement(driver.findElement(By.linkText("Sign Out"))).click().build().perform();
	}

}
