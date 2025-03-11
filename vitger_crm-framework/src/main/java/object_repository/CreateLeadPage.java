package object_repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateLeadPage {
	
	WebDriver driver;
	
	public CreateLeadPage(WebDriver driver) {
		
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// Last Name
	
	@FindBy(name = "lastname")
	private WebElement lastname; 
	
	public WebElement getLastName() {
		return lastname;
		
	}
	
	// Company Name
	
	@FindBy(name = "company")
	private WebElement company;
	
	public WebElement getCompany() {
		return company;
	}
	
	// Save Button
	
	@FindBy(xpath="//input[@title = 'Save [Alt+S]']")
	private WebElement save;
	
	public WebElement getSave() {
		
		return save;
		
	}
	
	@FindBy(name="leadsource")
	private WebElement leadsource;
	
	public WebElement getLeadSource() {
		
		return leadsource;
		
	}
	
	@FindBy(name="industry")
	private WebElement industry;
	
	public WebElement getIndustry() {
		
		return industry;
		
	}
	
}
