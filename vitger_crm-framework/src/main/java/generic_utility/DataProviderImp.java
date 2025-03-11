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
		Object[][] arr = new Object[3][2];
		
		arr[0][0] = "admin";
		arr[0][1] = "admin";
		
		arr[1][0] = "admin";
		arr[1][1] = "admin1";

		arr[2][0] = "admin";
		arr[2][1] = "admin";
		
		return arr;
	}
	
	
}
