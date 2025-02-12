package organizations;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import generic_utility.BaseClass;
import generic_utility.FileUtility;
import object_repository.CreateOrganizationsPage;
import object_repository.HomePage;
import object_repository.OrganizationsPage;

public class CreateOragnizationTest extends BaseClass {

	@Test(groups = "SmokeTest")
	public void createOragnizationTest() throws InterruptedException, IOException {
		FileUtility fu = new FileUtility();
		String orgname = fu.getDataFromExcel("Organizations", 1, 0) + (int) (Math.random() * 1000);

		// Create Organization
		HomePage hp = new HomePage(driver);
		hp.getOrganizations().click();

		OrganizationsPage op = new OrganizationsPage(driver);
		op.getAddOrganization().click();

		CreateOrganizationsPage cop = new CreateOrganizationsPage(driver);
		cop.getOrganizationsName().sendKeys(orgname);
		cop.getSave().click();

		// Thread.sleep(1000);
		String s2 = driver.findElement(By.className("dvHeaderText")).getText();

		// Verification

		Assert.assertTrue(s2.contains(orgname));

		System.out.println("Test-Case Passed");

	}

}
