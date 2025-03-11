package object_repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateProductPage {
	WebDriver driver;
	
	public CreateProductPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);	
	}
	
	@FindBy(name="productname")
	private WebElement productName;
	
	public WebElement getProductName() {
		return productName;
	}
	
	@FindBy(name="productcategory")
	private WebElement productCategory;
	
	public WebElement getproductcategory() {
		return productCategory;
	}
	
	@FindBy(xpath = "//img[@title='Select']")
	private WebElement venderName;
	
	public WebElement getVenderName() {
		return venderName;
	}
	
	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement saveButton;
	
	public WebElement getSaveButton() {
		return saveButton;
		
	}
	
}
