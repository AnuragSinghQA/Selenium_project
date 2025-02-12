package organizations;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import generic_utility.BaseClass;
import generic_utility.FileUtility;
import object_repository.CreateOrganizationsPage;
import object_repository.HomePage;
import object_repository.OrganizationsPage;

public class Organization_IndustryTest extends BaseClass {

	@Test(groups = "RegressionTest")
	public void organization_IndustryTest() throws IOException, InterruptedException {
		FileUtility fu = new FileUtility();
		String orgname = fu.getDataFromExcel("Organizations", 1, 0) + (int) (Math.random() * 1000);
		String industry = fu.getDataFromExcel("Organizations", 1, 1);

		// Create Organization
		HomePage hp = new HomePage(driver);
		hp.getOrganizations().click();

		OrganizationsPage op = new OrganizationsPage(driver);
		op.getAddOrganization().click();

		CreateOrganizationsPage cop = new CreateOrganizationsPage(driver);
		cop.getOrganizationsName().sendKeys(orgname);
		Select sel = new Select(cop.getIndustry());
		sel.selectByValue(industry);
		cop.getSave().click();

		String s2 = driver.findElement(By.className("dvHeaderText")).getText();

		// Verification

		if (s2.contains(orgname)) {
			System.out.println("Test-Case Passed");
		} else
			System.out.println("Test-Case Failed");

	}

}
