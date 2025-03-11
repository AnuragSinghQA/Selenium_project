package object_repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class VenderList {
	 WebDriver driver;
	public VenderList(WebDriver driver) {
		
		this.driver = driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(id="search_txt")
	private WebElement search;
	
	public WebElement getSearch() {
		return search;
	}
	
	@FindBy(name="search_field")
	private WebElement in;
	
	public WebElement getIn() {
		return in;
	}
	
	@FindBy(name="search")
	private WebElement searchButton;
	
	public WebElement getsearchButton() {
		return searchButton;
	}
	
	@FindBy(id="1")
	private WebElement SelectVender;
	
	public WebElement getSelectVender() {
		return SelectVender;
	}
	

}
