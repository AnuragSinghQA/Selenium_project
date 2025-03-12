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

public class TestList implements ITestListener, ISuiteListener {
	public ExtentReports report;
	public ExtentTest test;
	public String methodname;

	public void onStart(ISuite suite) {

		ExtentSparkReporter spark = new ExtentSparkReporter("./AdvanceReport1/report.html");
		spark.config().setDocumentTitle("Reports");
		spark.config().setReportName("Smoke_Report");
		spark.config().setTheme(Theme.DARK);

		report = new ExtentReports();
		report.attachReporter(spark);
		report.setSystemInfo("Browser", "Chrome");
		report.setSystemInfo("Windows", "11");

	}

	public void onFinish(ISuite suite) {

		report.flush();
	}

	public void onTestStart(ITestResult result) {
		String methodname = result.getMethod().getMethodName();
		System.out.println("======START=====" + methodname + "========");
		test = report.createTest(methodname);
		test.log(Status.INFO, "======START=====" + methodname + "========");
	}

	public void onTestSuccess(ITestResult result) {

	}

	public void onTestFailure(ITestResult result) {
		String methodName = result.getMethod().getMethodName();
		//test = report.createTest(methodName);
		test.log(Status.FAIL, "======FAILURE=====" + methodName);
		WebDriver driver = BaseClass.getDriver();
		TakesScreenshot tks = (TakesScreenshot)driver;
		String src = tks.getScreenshotAs(OutputType.BASE64);
		test.addScreenCaptureFromBase64String(src,"ErrorFile");
		test.log(Status.FAIL, methodName+ "is failed");
		
	}
	public void onTestSkipped(ITestResult result) {

	}

}
