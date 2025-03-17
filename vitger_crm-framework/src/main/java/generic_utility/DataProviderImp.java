package generic_utility;

import org.testng.Reporter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

 public class DataProviderImp {
	
	@Test(dataProvider = "add")
	public void createAccount(String firstName, String LastName) {
		Reporter.log(firstName + " " + LastName,true);
	}

	@DataProvider
	public Object[][] add() {
		Object[][] arr1 = new Object[3][2];
		
		arr1[0][0] = "admin";
		arr1[0][1] = "admin";
		
		arr1[1][0] = "admin";
		arr1[1][1] = "admin1";

		arr1[2][0] = "admin";
		arr1[2][1] = "admin";
		
		return arr1;
	}
	
	
}
