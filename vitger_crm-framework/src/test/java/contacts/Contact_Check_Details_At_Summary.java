package contacts;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import object_repository.ContactsPage;

public class Contact_Check_Details_At_Summary {

	public static void main(String[] args) throws IOException, InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

		// Files (Property File)
		FileInputStream fis = new FileInputStream("E:\\java\\vitger_crm-framework\\src\\test\\resources\\commonData.properties");
		Properties pObj = new Properties();
		pObj.load(fis);

		// Files (Excel File)
		FileInputStream excelFile = new FileInputStream("C:\\Users\\asjad\\OneDrive\\Desktop\\TestData.xlsx");
		Workbook wb = WorkbookFactory.create(excelFile);
		Sheet sh = wb.getSheet("Contacts");
		Row row = sh.getRow(1);
		Cell cell = row.getCell(0);

		// Opening URL and LoginandLogout
		driver.get(pObj.getProperty("url"));
		driver.findElement(By.xpath("//input[@name='user_name']")).sendKeys(pObj.getProperty("un"));
		driver.findElement(By.xpath("//input[@name='user_password']")).sendKeys(pObj.getProperty("pass"));
		driver.findElement(By.id("submitButton")).click();

		// Click on Contact
		driver.findElement(By.linkText("Contacts")).click();

		// Creating Contact
		ContactsPage cp = new ContactsPage(driver);
		cp.getCreateContact().click();
		
		// Check Records At summary page
		driver.findElement(By.linkText("Contacts")).click();
	//	driver.findElement(By.name("search_text")).sendKeys(s1);
		Select sel = new Select(driver.findElement(By.id("bas_searchfield")));
		sel.selectByValue("lastname");
		driver.findElement(By.name("submit")).click();
		Thread.sleep(3000);
		
		String s5 = driver.findElement(By.xpath("//a[@title='Contacts']/../following-sibling::td/a[@title='Contacts']")).getText();
		Thread.sleep(2000);
	//	if(s5.equals(s1))
			System.out.println("Last Name matches");
	//	else
			System.out.println("Last Name not matching");
		
		driver.quit();

	}

}