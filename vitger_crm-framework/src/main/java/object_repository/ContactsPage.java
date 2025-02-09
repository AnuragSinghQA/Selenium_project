package object_repository;

import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import generic_utility.FileUtility;
import generic_utility.WebDriverUtility;

public class ContactsPage {
	WebDriver driver;
	FileUtility fu = new FileUtility();
	WebDriverUtility wdu = new WebDriverUtility(driver);

	public ContactsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//img[@title='Create Contact...']")
	private WebElement createContact;

	@FindBy(name = "lastname")
	private WebElement lastname;

	@FindBy(xpath = "//img[@title='Select']")
	private WebElement clickSelectOrganization;

	@FindBy(id = "search_txt")
	private WebElement searchfield;

	@FindBy(id = "search")
	private WebElement searchbutton;

	@FindBy(xpath = "//a[@id='1']")
	private WebElement selectOrganization;
	
	@FindBy(xpath = "//input[@type='submit']")
	private WebElement save;

//	String s4 = driver.findElement(By.xpath("//a[@id='1']")).getText();
	
	public WebElement getCreateContact() {
		return createContact;
	}

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

	public void createOrginization() throws IOException, InterruptedException {
		Thread.sleep(3000);
		getCreateContact();
		getLastname();
		getClickSelectOrganization();
		Thread.sleep(3000);
		wdu.switchTo("module=Accounts&action=Popup");
		getSearchfield().sendKeys(fu.getDataFromExcel("Contacts", 1, 1));
		getSearchbutton();
		getSelectOrganization();
		wdu.switchTo("module=Accounts&action=Edit");
		getSave().click();
		

	}

}
