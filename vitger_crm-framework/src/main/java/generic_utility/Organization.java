package generic_utility;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class Organization {
	public static String phone_no;
	public static String industry;
	public static String orgname;
	public static  void create_organization() throws IOException, InterruptedException 
	{
		FileUtility fu = new FileUtility();
		LoginandLogout.login();
		WebDriver driver = LoginandLogout.driver;
		orgname = fu.getDataFromExcel("Organizations", 1, 0)+ (int) (Math.random() * 1000);
		industry = fu.getDataFromExcel("Organizations", 1, 1);
		phone_no = fu.getDataFromExcel("Organizations", 1, 2);
		
		driver.findElement(By.linkText("Organizations")).click();
		driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
		WebElement dropdown = driver.findElement(By.xpath("//select[@name='industry']"));
		Select sel = new Select(dropdown);
		Thread.sleep(1000);
		sel.selectByValue(industry);
		Thread.sleep(1000);
		driver.findElement(By.id("phone")).sendKeys(phone_no);
		
		
		driver.findElement(By.name("accountname")).sendKeys(orgname);
		
		driver.findElement(By.xpath("//b[text()='Organization Information']/../../preceding-sibling::tr//input[@title=\"Save [Alt+S]\"]")).click();

		
		
	}


}
