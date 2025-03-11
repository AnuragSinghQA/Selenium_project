package contacts;

import java.io.IOException;

import org.testng.annotations.Test;

import generic_utility.BaseClass;
import generic_utility.FileUtility;
import object_repository.ContactsPage;
import object_repository.CreateContactsPage;
import object_repository.CreateOrganizationsPage;
import object_repository.HomePage;
import object_repository.OrganizationsPage;

public class CreateContactTest extends BaseClass {

	@Test(groups = "SmokeTest")
	public void createContactTest() throws IOException, InterruptedException {
		FileUtility fu = new FileUtility();
		String orgname = fu.getDataFromExcel("Organizations", 1, 0) + (int) (Math.random() * 1000);

		// Creating Contact without industry

		CreateContactsPage ccp = new CreateContactsPage(driver);
		ContactsPage cp = new ContactsPage(driver);
		
		// Create Organization
		
		HomePage hp = new HomePage(driver);
		hp.getOrganizations().click();
	
		OrganizationsPage op = new OrganizationsPage(driver);
		op.getAddOrganization().click();
		CreateOrganizationsPage cop = new CreateOrganizationsPage(driver);
		cop.getOrganizationsName().sendKeys(orgname);
		cop.getSave();
		Thread.sleep(3000);
		hp.getContacts().click();
		cp.getCreateContact().click();

		ccp.getLastname().sendKeys(fu.getDataFromExcel("Contacts", 1, 0));
		ccp.getSave().click();

	}

}
