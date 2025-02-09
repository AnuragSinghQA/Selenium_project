package contacts;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;

import generic_utility.FileUtility;
import object_repository.CreateContactsPage;
import object_repository.LoginPage;

public class CreateContact {

	public static void main(String[] args) throws IOException, InterruptedException {
		FileUtility fu = new FileUtility();
		String URL = fu.getDataFromProp("url");

		WebDriver driver = fu.selectBrowser();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		// LoginPage

		driver.get(URL);
		LoginPage lp = new LoginPage(driver);
		lp.login();
		
		// Creating Contact

		CreateContactsPage ccp = new CreateContactsPage(driver);
		ccp.createContactWithOrganization();
		System.out.println("done");

		Thread.sleep(1000);
		driver.quit();

	}

}
