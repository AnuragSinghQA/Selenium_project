package object_repository;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import generic_utility.FileUtility;

public class CreateOrganizationsPage {
	WebDriver driver;
	
	public CreateOrganizationsPage(WebDriver driver) {
		
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name = "accountname")
	private WebElement organizationsName;
	
	@FindBy(xpath = "//b[text()='Organization Information']/../../preceding-sibling::tr//input[@title='Save [Alt+S]']")
	private WebElement save;


	public WebElement getOrganizationsName() {
		return organizationsName;
	}

	public WebElement getSave() {
		return save;
	}
	
	public String createOrganizationsWithName() throws IOException
	{ FileUtility fu = new FileUtility();
	
	String orgname = fu.getDataFromExcel("Organizations", 1, 0)+(int)(Math.random()*1000);
	getOrganizationsName().sendKeys(orgname);
	getSave().click();
	return orgname;	
	}
	
	
	

}
