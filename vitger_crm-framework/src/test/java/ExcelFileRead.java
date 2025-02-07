import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelFileRead {
	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		
		FileInputStream fis = new FileInputStream("C:\\Users\\asjad\\OneDrive\\Desktop\\TestData.xlsx");
		Workbook wb = WorkbookFactory.create (fis);
	Sheet sh =	wb.getSheet("Organizations");
	
	Row ro = sh.getRow(1);
	
	Cell ce = ro.getCell(0);
	
	System.out.println(ce.getStringCellValue());
		
		
	}

}
