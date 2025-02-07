package organizations;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import generic_utility.FileUtility;
import object_repository.CreateOrganizationsPage;
import object_repository.HomePage;
import object_repository.LoginPage;
import object_repository.LogoutPage;
import object_repository.OrganizationsPage;

public class CreateOragnization {

	public static void main(String[] args) throws InterruptedException, IOException {
		FileUtility fu = new FileUtility();
		String URL = fu.getDataFromProp("url");
		//String industry = fu.getDataFromExcel("Organizations", 1, 1);
		//String phone_no = fu.getDataFromExcel("Organizations", 1, 2);
		
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
		op.openCeateorganization();
		
		CreateOrganizationsPage cop = new CreateOrganizationsPage(driver);
		String orgname = cop.createOrganizationsWithName();
		
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
