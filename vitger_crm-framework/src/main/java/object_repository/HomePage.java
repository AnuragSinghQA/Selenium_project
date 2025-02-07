package object_repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	
	WebDriver driver;
	
	public HomePage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(linkText="Leads")
	private WebElement Leads;
	
	@FindBy(linkText="Organizations")
	private WebElement Organizations;
	
	@FindBy(linkText="Contacts")
	private WebElement Contacts;


	public WebElement getLeads() {
		return Leads;
	}

	public WebElement getOrganizations() {
		return Organizations;
	}

	public WebElement getContacts() {
		return Contacts;
	}
	
	public void openOrganizations()
	{
		getOrganizations().click();
	}
	
	public void openContacts()
	{
		getContacts().click();
	}

}
