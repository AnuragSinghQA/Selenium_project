

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class GetDataFromProperties {

	public static void main(String[] args) throws IOException {
//		get the java representation object of the physical file
		FileInputStream fis = new FileInputStream("E:\\java\\vitger_crm-framework\\src\\test\\resources\\commonData.properties");

//		Load all the keys, Properties class and load()
		Properties pObj = new Properties();
		pObj.load(fis);

//		Fetch the value with the help of getProperty()
		String browser = pObj.getProperty("un");
		System.out.println(browser);
	}
	
	
	

}
