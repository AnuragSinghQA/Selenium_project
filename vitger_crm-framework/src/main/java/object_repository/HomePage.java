package object_repository;

import java.time.Duration;
import java.util.NoSuchElementException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.FluentWait;

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
	
	@FindBy(linkText="Leads")
	private WebElement Products;


	public WebElement getLeads() {
		return Leads;
	}

	public WebElement getOrganizations() {
		return Organizations;
	}

	public WebElement getContacts() {
		return Contacts;
	}
	
	public WebElement getProducts() {
		return Products;
	}

	 FluentWait<WebDriver> fluentWait = new FluentWait<WebDriver>(driver)
	            .withTimeout(Duration.ofSeconds(10))  // Maximum wait time
	            .pollingEvery(Duration.ofSeconds(2))  // Polling interval
	            .ignoring(NoSuchElementException.class); 
	 

}
