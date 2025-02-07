package organizations;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import generic_utility.FileUtility;
import generic_utility.LoginandLogout;
import generic_utility.Organization;

public class Organization_PhoneNo_Industry {

	public static void main(String[] args) throws IOException, InterruptedException {
		
		FileUtility fu = new FileUtility();
		Organization.create_organization();
		String orgname = Organization.orgname ;
		WebDriver driver = LoginandLogout.driver;

		//Verify phone no added or not at organization creation confirmation page
		
		String s3 = driver.findElement(By.id("mouseArea_Phone")).getText();
		
		if(s3.contains(Organization.phone_no))
			System.out.println("Phone No added");
		else if(s3.isEmpty())
			System.out.println("No phone no present");
		else
			System.out.println("Number not matching");
		
		
		// Check Phone no at summary page
		
		driver.findElement(By.linkText("Organizations")).click();
		Thread.sleep(1000);
		driver.findElement(By.name("search_text")).sendKeys(orgname);
		WebElement inDropdown = driver.findElement(By.id("bas_searchfield"));
		Select inSel = new Select(inDropdown);
		inSel.selectByValue(fu.getDataFromExcel("Organizations", 1, 3));
		
		driver.findElement(By.name("submit")).click();
		Thread.sleep(2000);
		
		String s4 = driver.findElement(By.xpath("//span[@vtfieldname='phone']")).getText();
		
		if(Organization.phone_no.contains(s4))
			System.out.println("Correct Phone No is present at summary screen");
		else if(s3.isEmpty())
			System.out.println("No phone no present");
		else
			System.out.println("Number not matching");
		
		driver.quit();
		

	}

}
