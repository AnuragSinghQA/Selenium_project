package object_repository;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import generic_utility.FileUtility;

public class CreateOrganizationsPage {
	WebDriver driver;
	public CreateOrganizationsPage(WebDriver driver) throws IOException 
	{	
		this.driver = driver;
		PageFactory.initElements(driver, this);	
	}
	
	// WebElemnt 
	
	@FindBy(name = "accountname")
	private WebElement organizationsName;
	
	@FindBy(id ="phone")
	private WebElement phone;
	
	@FindBy(name = "industry")
	private WebElement industryDropdown;

	@FindBy(xpath = "//b[text()='Organization Information']/../../preceding-sibling::tr//input[@title='Save [Alt+S]']")
	private WebElement save;

	// Getter Methods

	public WebElement getOrganizationsName() {
		return organizationsName;
	}
	
	public WebElement getPhone() {
		return phone;
	}

	public WebElement getIndustry() {
		return industryDropdown;
	}


	public WebElement getSave() {
		return save;
	}
	
}
