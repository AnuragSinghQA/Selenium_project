package organizations;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import generic_utility.BaseClass;
import generic_utility.FileUtility;
import object_repository.CreateOrganizationsPage;
import object_repository.HomePage;
import object_repository.OrganizationsPage;

public class Organization_PhoneNoTest extends BaseClass {

	@Test(groups = "RegressionTest")
	public void organization_PhoneNoTest() throws IOException, InterruptedException {

		FileUtility fu = new FileUtility();
		String orgname = fu.getDataFromExcel("Organizations", 1, 0) + (int) (Math.random() * 1000);
		String phone_no = fu.getDataFromExcel("Organizations", 1, 2);

		// Create Organization
		HomePage hp = new HomePage(driver);
		hp.getOrganizations().click();

		OrganizationsPage op = new OrganizationsPage(driver);
		op.getAddOrganization().click();

		CreateOrganizationsPage cop = new CreateOrganizationsPage(driver);
		cop.getOrganizationsName().sendKeys(orgname);
		cop.getPhone().sendKeys(phone_no);
		cop.getSave().click();

		// Thread.sleep(1000);
		String s2 = driver.findElement(By.className("dvHeaderText")).getText();

		// Verification

		if (s2.contains(orgname)) {
			System.out.println("Test-Case Passed");
		} else
			System.out.println("Test-Case Failed");

	}

}
