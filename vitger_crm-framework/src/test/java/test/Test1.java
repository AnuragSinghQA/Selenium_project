package test;

import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Test1{

	@Test (priority = 2)
	public void deleteAccount() {
		Reporter.log("Test Script 1", true);
	}
	
	@Test (priority = 1)
	public void modifyAccount() {
		Reporter.log("Test Script 3", true);
	}
	
	@Test(priority = 0)
	public void createAccount() {
		Reporter.log("Test Script 2", true);
	}

}
