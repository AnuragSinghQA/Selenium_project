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

	public CreateContactsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// WebElement

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
	
	
	// Getter Methods

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
	
	


}
