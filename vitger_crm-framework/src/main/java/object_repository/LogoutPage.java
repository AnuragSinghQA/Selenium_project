package object_repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogoutPage {
	WebDriver driver;
	
public LogoutPage(WebDriver driver){
		
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

@FindBy(xpath = "//span[text()=' Administrator']/../following-sibling::td[1]")
private WebElement profile;

@FindBy(linkText = "Sign Out")
private WebElement signout;

public WebElement getProfile() {
	return profile;
}
public WebElement getSignout() {
	return signout;
}



	public void logout() throws InterruptedException {
		
		Actions acc = new Actions(driver);
		acc.moveToElement(getProfile()).click().build().perform();
		Thread.sleep(1000);
		acc.moveToElement(getSignout()).click().build().perform();
	}

}
