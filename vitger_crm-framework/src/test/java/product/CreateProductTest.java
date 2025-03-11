package product;

import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import generic_utility.BaseClass;
import generic_utility.WebDriverUtility;
import object_repository.CreateProductPage;
import object_repository.HomePage;
import object_repository.ProductCreateConfirmationPage;
import object_repository.ProductPage;
import object_repository.VenderList;

public class CreateProductTest extends BaseClass {

	@Test
	public void createProductwithName() {

		HomePage hp = new HomePage(driver);
		ProductPage pp = new ProductPage(driver);
		CreateProductPage cpp = new CreateProductPage(driver);
		ProductCreateConfirmationPage pccp = new ProductCreateConfirmationPage(driver);
		hp.getProducts().click();
		pp.getcreateProduct().click();
		cpp.getProductName().sendKeys("Product1");
		cpp.getSaveButton().click();
		Assert.assertTrue(pccp.getActualProductName().getText().contains("Product1"));
	}

	@Test
	public void createProductwithNameAndProductCategory() {

		HomePage hp = new HomePage(driver);
		ProductPage pp = new ProductPage(driver);
		CreateProductPage cpp = new CreateProductPage(driver);
		ProductCreateConfirmationPage pccp = new ProductCreateConfirmationPage(driver);
		hp.getProducts().click();
		pp.getcreateProduct().click();
		cpp.getProductName().sendKeys("Product1");
		Select sel = new Select(cpp.getproductcategory());
		sel.selectByValue("Software");
		cpp.getSaveButton().click();
		Assert.assertTrue(pccp.getActualProductName().getText().contains("Product1")
				&& (pccp.getProductCategory().getText().contains("Software")));
	}

	@Test
	public void createProductwithNameAndVender() throws InterruptedException {

		HomePage hp = new HomePage(driver);
		ProductPage pp = new ProductPage(driver);
		CreateProductPage cpp = new CreateProductPage(driver);
		VenderList vl = new VenderList(driver);
		WebDriverUtility wdu = new WebDriverUtility(driver);
		ProductCreateConfirmationPage pccp = new ProductCreateConfirmationPage(driver);

		hp.getProducts().click();
		pp.getcreateProduct().click();
		cpp.getProductName().sendKeys("Product1");
		cpp.getVenderName().click();
		wdu.switchTo("module=Vendors&action=Popup&html=Popup_picker");
		vl.getSearch().sendKeys("Maria");
		vl.getsearchButton().click();
		Thread.sleep(2000);
		vl.getSelectVender().click();
		wdu.switchTo("module=Products&action=EditView");
		cpp.getSaveButton().click();
		Assert.assertTrue(pccp.getActualProductName().getText().contains("Product1111")
				&& (pccp.getVenderName().getText().contains("Maria")));
	}

}
