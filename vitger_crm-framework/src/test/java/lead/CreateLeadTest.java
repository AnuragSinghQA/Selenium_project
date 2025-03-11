package lead;

import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import generic_utility.BaseClass;
import object_repository.CreateLeadPage;
import object_repository.HomePage;
import object_repository.LeadCreateConfirmationPage;
import object_repository.LeadPage;

public class CreateLeadTest extends BaseClass {

	@Test
	public void createLeadwithCompany() {
		HomePage hp = new HomePage(driver);
		LeadPage lp = new LeadPage(driver);
		CreateLeadPage clp = new CreateLeadPage(driver);
		LeadCreateConfirmationPage lccp = new LeadCreateConfirmationPage(driver);
		hp.getLeads().click();
		lp.getCreateLead().click();
		clp.getLastName().sendKeys("Jadon");
		clp.getCompany().sendKeys("CompanyName");
		clp.getSave().click();

		String actualLeadName = lccp.getActualLeadName().getText();

		Assert.assertTrue(actualLeadName.contains("Jadon" + 123));

	}

	@Test
	public void createLeadwithCompanyAndLeadSource() {
		HomePage hp = new HomePage(driver);
		LeadPage lp = new LeadPage(driver);
		CreateLeadPage clp = new CreateLeadPage(driver);
		LeadCreateConfirmationPage lccp = new LeadCreateConfirmationPage(driver);
		hp.getLeads().click();
		lp.getCreateLead().click();
		clp.getLastName().sendKeys("Jadon");
		clp.getCompany().sendKeys("CompanyName");
		Select sel = new Select(clp.getLeadSource());
		sel.selectByValue("Employee");
		clp.getSave().click();

		String actualLeadName = lccp.getActualLeadName().getText();

		Assert.assertTrue(actualLeadName.contains("Jadon") && (lccp.getleadsource().getText().contains("Employee")));

	}

	@Test
	public void createLeadwithCompanyAndIndustry() {
		HomePage hp = new HomePage(driver);
		LeadPage lp = new LeadPage(driver);
		CreateLeadPage clp = new CreateLeadPage(driver);
		LeadCreateConfirmationPage lccp = new LeadCreateConfirmationPage(driver);
		hp.getLeads().click();
		lp.getCreateLead().click();
		clp.getLastName().sendKeys("Jadon");
		clp.getCompany().sendKeys("CompanyName");
		Select sel = new Select(clp.getIndustry());
		sel.selectByValue("Energy");
		clp.getSave().click();

		String actualLeadName = lccp.getActualLeadName().getText();

		Assert.assertTrue(actualLeadName.contains("Jadon") && (lccp.getIndustry().getText().contains("Energy")));

	}

}
