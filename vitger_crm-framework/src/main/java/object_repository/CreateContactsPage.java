package object_repository;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import generic_utility.FileUtility;
import generic_utility.WebDriverUtility;

public class CreateContactsPage {
	
	WebDriver driver;
	FileUtility fu = new FileUtility();

	public CreateContactsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}


	@FindBy(name = "lastname")
	private WebElement lastname;

	@FindBy(xpath = "//img[@title='Select']")
	private WebElement clickSelectOrganization;

	@FindBy(id = "search_txt")
	private WebElement searchfield;

	@FindBy(name = "search")
	private WebElement searchbutton;

	@FindBy(xpath = "//a[@id='1']")
	private WebElement selectOrganization;
	
	@FindBy(xpath = "//input[@type='submit']")
	private WebElement save;
	

	public WebElement getLastname() {
		return lastname;
	}

	public WebElement getSave() {
		return save;
	}

	public WebElement getClickSelectOrganization() {
		return clickSelectOrganization;
	}

	public WebElement getSearchfield() {
		return searchfield;
	}

	public WebElement getSearchbutton() {
		return searchbutton;
	}

	public WebElement getSelectOrganization() {
		return selectOrganization;
	}

	public void createContactWithoutOrganization() throws IOException, InterruptedException {
		ContactsPage cp = new ContactsPage(driver);
		cp.getCreateContact().click();
		getLastname().sendKeys(fu.getDataFromExcel("Contacts", 1, 0));;
		getSave().click();
		

	}
	
	public void createContactWithOrganization() throws IOException, InterruptedException {
		ContactsPage cp = new ContactsPage(driver);
		// Create Organization
				HomePage hp = new HomePage(driver);
				hp.openOrganizations();
				OrganizationsPage op = new OrganizationsPage(driver);
				op.getAddOrganization().click();
				CreateOrganizationsPage cop = new CreateOrganizationsPage(driver);
				cop.createOrganizationsWithName();
				Thread.sleep(3000);
				hp.openContacts();
				cp.getCreateContact().click();
		getLastname().sendKeys(fu.getDataFromExcel("Contacts", 1, 0));;
		getClickSelectOrganization().click();
		Thread.sleep(3000);
		WebDriverUtility wdu = new WebDriverUtility(driver);
		wdu.switchTo("module=Accounts&action=Popup");
		getSearchfield().sendKeys(cop.orgname);
		getSearchbutton().click();
		getSelectOrganization().click();
		wdu.switchTo("module=Accounts&action=Edit");
		getSave().click();
		

	}


}
