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

	@FindBy(xpath = "//img[@title='Create Contact...']")
	private WebElement createContact1;
	
	public WebElement getCreateContact() {
		return createContact;
	}


}
