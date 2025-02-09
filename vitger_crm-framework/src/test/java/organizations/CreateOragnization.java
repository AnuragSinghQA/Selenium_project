package organizations;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import generic_utility.FileUtility;
import object_repository.CreateOrganizationsPage;
import object_repository.HomePage;
import object_repository.LoginPage;
import object_repository.LogoutPage;
import object_repository.OrganizationsPage;

public class CreateOragnization {

	@Test
	
	public void createOragnization() throws InterruptedException, IOException {
		FileUtility fu = new FileUtility();
		String URL = fu.getDataFromProp("url");
		
		WebDriver driver = fu.selectBrowser();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		// LoginPage 
		driver.get(URL);
		LoginPage loginPage = new LoginPage(driver);
		loginPage.login();


		// Create Organization 
		HomePage hp = new HomePage(driver);
		hp.openOrganizations();
		
		OrganizationsPage op = new OrganizationsPage(driver);
		op.getAddOrganization().click();
		
		CreateOrganizationsPage cop = new CreateOrganizationsPage(driver);
		cop.createOrganizationsWithName();
		String orgname =cop.orgname;
		
		String s2 = driver.findElement(By.className("dvHeaderText")).getText();

		// Verification 
		
		if (s2.contains(orgname)) {
			System.out.println("Test-Case Passed");
		} else
			System.out.println("Test-Case Failed");
		
		// LogoutPage
		
		LogoutPage logoutPage = new LogoutPage(driver);
		logoutPage.logout();
		
		System.out.println("LogoutPage");
		
		driver.close();
	}

}
