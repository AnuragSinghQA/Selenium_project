package generic_utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class MouseAndKeyboard {
	WebDriver driver;
	Actions acc = new Actions(driver);
	
	public MouseAndKeyboard(WebDriver driver) {
		
		this.driver = driver;	
	} 
	
	public void moveToElement(WebElement we) 
	{
		acc.moveToElement(we).build().perform();	
	}
	public void click(WebElement we) 
	{
		acc.click(we).build().perform();	
	}
	
	public void doubleClick(WebElement we) 
	{
		acc.doubleClick(we).build().perform();	
	}
	public void rightClick(WebElement we) 
	{
		acc.contextClick(we).build().perform();	
	}
	
	public void scrollToElement(WebElement we) 
	{
		acc.scrollToElement(we).build().perform();	
	}
	
	public void scrollToNewPostion(int x, int y) 
	{
		acc.scrollByAmount(x,y).build().perform();	
	}
	public void dragAndDrop(WebElement source, WebElement dist ) 
	{
		acc.dragAndDrop(source, dist).build().perform();	
	}
	
}
