package object_repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductCreateConfirmationPage {
	
	WebDriver driver;
	
	public ProductCreateConfirmationPage(WebDriver driver) 
	{
		this.driver = driver;
		PageFactory.initElements(driver,this);
	}

	@FindBy(className = "dvtHeaderText")
	private WebElement actualProductName;
	
	public WebElement getActualProductName() {
		return actualProductName;
	}
	
	@FindBy(id="mouseArea_Product Name")
	private WebElement productName;
	
	public WebElement getProductName() {	
		return productName;	
	}
	
	@FindBy(id="mouseArea_Vendor Name")
	private WebElement venderName;
	
	public WebElement getVenderName() {	
		return venderName;	
	}
	
	@FindBy(id="mouseArea_Product Category")
	private WebElement productCategory;
	
	public WebElement getProductCategory() {	
		return productCategory;	
	}
	
}
