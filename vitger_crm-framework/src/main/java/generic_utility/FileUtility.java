package generic_utility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.WebDriver;

public class FileUtility {
	WebDriver driver;

	public String getDataFromProp(String keys) throws IOException {
		FileInputStream fis = new FileInputStream("C:\\Users\\asjad\\git\\Selenium_project\\vitger_crm-framework\\src\\test\\resources\\commonData.properties");
		Properties pObj = new Properties();
		pObj.load(fis);
		return (pObj.getProperty(keys));
	}

	public String getDataFromExcel(String sheetname, int rownum, int cellnum) throws IOException {
		FileInputStream excelFile = new FileInputStream("C:\\Users\\asjad\\git\\Selenium_project\\vitger_crm-framework\\src\\test\\resources\\TestData.xlsx");
		Workbook wb = WorkbookFactory.create(excelFile);
		Sheet sh = wb.getSheet(sheetname);
		Row row = sh.getRow(rownum);
		Cell cell = row.getCell(cellnum);
		return cell.getStringCellValue();
	}
	
	public String DataFromExcel(String sheetName, int rowNum,int cellNum) throws EncryptedDocumentException, IOException {
		FileInputStream fis2 = new FileInputStream("C:\\Users\\User\\Desktop\\testData.xlsx");
		Workbook wb = WorkbookFactory.create(fis2);
		Sheet sh = wb.getSheet(sheetName);
		Row row = sh.getRow(rowNum);
		Cell cell = row.createCell(cellNum);
		cell.setCellValue("pass");
		return cell.getStringCellValue();
	}


}
