package generic_utility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

public class FileUtility {
	WebDriver driver;

	public String getDataFromProp(String keys) throws IOException {
		FileInputStream fis = new FileInputStream("E:\\java\\vitger_crm-framework\\src\\test\\resources\\commonData.properties");
		Properties pObj = new Properties();
		pObj.load(fis);
		return (pObj.getProperty(keys));
	}

	public String getDataFromExcel(String sheetname, int rownum, int cellnum) throws IOException {
		FileInputStream excelFile = new FileInputStream("C:\\Users\\asjad\\OneDrive\\Desktop\\TestData.xlsx");
		Workbook wb = WorkbookFactory.create(excelFile);
		Sheet sh = wb.getSheet(sheetname);
		Row row = sh.getRow(rownum);
		Cell cell = row.getCell(cellnum);
		return cell.getStringCellValue();
	}


}
