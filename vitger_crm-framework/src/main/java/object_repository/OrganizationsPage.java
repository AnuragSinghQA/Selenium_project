package object_repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationsPage {
	WebDriver driver;
	
	public OrganizationsPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//img[@title='Create Organization...']")
	private WebElement addOrganization;
	
	@FindBy(name="search_text")
	private WebElement search;
	
	@FindBy(name="search_field")
	private WebElement dropdown;

	public WebElement getAddOrganization() {
		return addOrganization;
	}

	public WebElement getSearch() {
		return search;
	}

	public WebElement getDropdown() {
		return dropdown;
	}
	
	
	
	

}
