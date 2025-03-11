package generic_utility;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ListenerImplementataion implements ITestListener, ISuiteListener {
	public ExtentReports report;
	public ExtentTest test ;

	public void onStart(ISuite suite) {
		ExtentSparkReporter spark = new ExtentSparkReporter("./AdvanceReport/report.html");
		spark.config().setDocumentTitle("Advance Reporting");
		spark.config().setReportName("Smoke Report");
		spark.config().setTheme(Theme.DARK);
   		
		report = new ExtentReports();
		report.attachReporter(spark);
		report.setSystemInfo("OS", "Windows11");
		report.setSystemInfo("Browser", "Chrome");
	}


	public void onTestStart(ITestResult result) {
		String methodName = result.getMethod().getMethodName();

		System.out.println("======START=====" + methodName + "========");
		report.createTest(methodName);
		test.log(Status.INFO, "======START=====" + methodName + "========");
	}

	public void onTestSuccess(ITestResult result) {
		String methodName = result.getMethod().getMethodName();
		test.log(Status.INFO, "======PASSED=====" + methodName);
	}

	public void onTestFailure(ITestResult result) {
		String methodName = result.getMethod().getMethodName();
		test = report.createTest(methodName);
		test.log(Status.FAIL, "======FAILURE=====" + methodName);
		WebDriver driver = BaseClass.driver;
		TakesScreenshot tks = (TakesScreenshot)driver;
		String src = tks.getScreenshotAs(OutputType.BASE64);
		test.addScreenCaptureFromBase64String(src, "errorfile");
		test.log(Status.FAIL,methodName+"is Failed");
	}

	public void onTestSkipped(ITestResult result) {
	}
	

	public void onFinish(ISuite suite) {
		System.out.println("Report Back-up");
		report.flush();
	}

}