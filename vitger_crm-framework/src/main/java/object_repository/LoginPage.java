package object_repository;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import generic_utility.FileUtility;

public class LoginPage {
	WebDriver driver;

	public LoginPage(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(name = "user_name")
	private WebElement Username;
	
	@FindBy(name = "user_password")
	private WebElement password;

	@FindBy(id = "submitButton")
	private WebElement submit;

	public WebElement getUsername() {
		return Username;
	}

	public WebElement getPassword() {
		return password;
	}

	public WebElement getSubmit() {
		return submit;
	}

	public void login() throws IOException {
		FileUtility fu = new FileUtility();
		String name = fu.getDataFromProp("un");
		String pass = fu.getDataFromProp("pass");

		getUsername().sendKeys(name);
		getPassword().sendKeys(pass);
		getSubmit().click();
	}
}
