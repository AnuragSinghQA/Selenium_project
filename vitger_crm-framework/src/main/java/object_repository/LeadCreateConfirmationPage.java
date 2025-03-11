package object_repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LeadCreateConfirmationPage {
	
	WebDriver driver;
	
	public LeadCreateConfirmationPage(WebDriver driver) 
	{
		this.driver = driver;
		PageFactory.initElements(driver,this);
	}

	@FindBy(className = "dvHeaderText")
	private WebElement actualLeadName;
	
	public WebElement getActualLeadName() {
		return actualLeadName;
	}
	
	@FindBy(id="dtlview_Lead Source")
	private WebElement leadsource;
	
	public WebElement getleadsource() {	
		return leadsource;	
	}
	
	@FindBy(id="dtlview_Industry")
	private WebElement industry;
	public WebElement getIndustry() {	
		return industry;
		
	}
	
}
