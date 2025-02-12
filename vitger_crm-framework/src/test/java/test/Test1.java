package test;

import org.testng.Reporter;
import org.testng.annotations.Test;

public class Test1{

	@Test 
	public void deleteAccount() {
		Reporter.log("Test Script 3", true);
	}
	
	@Test
	public void modifyAccount() {
		Reporter.log("Test Script 2", true);
	}
	
	@Test (dependsOnMethods = "modifyAccount()")
	public void createAccount() {
		Reporter.log("Test Script 1", true);
	}

}
