package contacts;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.Set;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import generic_utility.FileUtility;
import generic_utility.WebDriverUtility;

public class CreateContact {

	public static void main(String[] args) throws IOException, InterruptedException {
		FileUtility fu = new FileUtility();
		String URL = fu.getDataFromProp("url");
		String USERNAME = fu.getDataFromProp("un");
		String PASSWORD = fu.getDataFromProp("pass");
		
		String orgname = fu.getDataFromExcel("Organizations", 1, 0)+ (int) (Math.random() * 1000);
		//String industry = fu.getDataFromExcel("Organizations", 1, 1);
		//String phone_no = fu.getDataFromExcel("Organizations", 1, 2);
		
		WebDriver driver = fu.selectBrowser();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		// LoginPage 
		
		driver.get(URL);
		driver.findElement(By.xpath("//input[@name='user_name']")).sendKeys(USERNAME);
		driver.findElement(By.xpath("//input[@name='user_password']")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click();

		// Create Organization 
		
		driver.findElement(By.linkText("Organizations")).click();
		driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
		driver.findElement(By.name("accountname")).sendKeys(orgname);
		driver.findElement(By.xpath("//b[text()='Organization Information']/../../preceding-sibling::tr//input[@title=\"Save [Alt+S]\"]")).click();
		// Click on Contact
		Thread.sleep(1000);
		driver.findElement(By.linkText("Contacts")).click();

		// Creating Contact
		
		driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();
		Thread.sleep(1000);
		driver.findElement(By.name("lastname")).sendKeys(fu.getDataFromExcel("Contacts", 1, 0));
		
		driver.findElement(By.xpath("//img[@title='Select']")).click();

		 WebDriverUtility wdu =  new WebDriverUtility(driver);
		 wdu.switchTo("module=Accounts&action=Popup");
		 
		Thread.sleep(2000);
		driver.findElement(By.id("search_txt")).sendKeys(orgname);
		driver.findElement(By.name("search")).click();
		Thread.sleep(3000);
		String s3 = driver.findElement(By.xpath("//a[@id='1']")).getText();

		if (s3.equals(orgname))
		{System.out.println("Records Found!!!!!!!");
			driver.findElement(By.xpath("//a[@id='1']")).click();}
		else
			System.out.println("Records Not Found!!!!!!!");
		
		wdu.switchTo("module=Accounts&action=Edit");
		driver.findElement(By.xpath("//input[@type='submit']")).click();

		Thread.sleep(1000);
		driver.quit();

	}

}
