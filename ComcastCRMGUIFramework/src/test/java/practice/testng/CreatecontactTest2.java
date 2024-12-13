package practice.testng;

import org.junit.experimental.theories.suppliers.TestedOn;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.model.Report;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.comcast.crm.basetest.BaseClass;

public class CreatecontactTest2 {
	public ExtentReports report;

	@BeforeSuite
	public void configBs() { // spark report config
		ExtentSparkReporter spark = new ExtentSparkReporter("./AdvanceReports/reports.html");
		spark.config().setDocumentTitle("CRM Test Sutie Results");
		spark.config().setReportName("CRM Report");
		spark.config().setTheme(Theme.DARK);

		// Add environment info and creatte an object toEntentReports
		report = new ExtentReports();
		report.attachReporter(spark);
		report.setSystemInfo("os", "Windows-10");
		report.setSystemInfo("browser", "chrome");
	}

	@AfterSuite
	public void configAs() {
		report.flush();
	}

	@Test
	public void createContactTest1() {
		
		WebDriver driver=new ChromeDriver();
		driver.get("http://localhost:8888/");
		
		

		ExtentTest test = report.createTest("CreatecontactTest1");
		TakesScreenshot ts=(TakesScreenshot)driver;
		String filepath=ts.getScreenshotAs(OutputType.BASE64);
		test.log(Status.INFO, "login to app");
		test.log(Status.INFO, "navigate to contact module");
		test.log(Status.INFO, "create contact");
		if ("SBI".equals("SBBI")) {
			test.log(Status.PASS, " contact is created");
		} else {
			//test.log(Status.FAIL, "contact is not created");
			
			test.addScreenCaptureFromBase64String(filepath, "Errorfile");
		}
	}

	@Test
	public void createContactewithOrgTest() {
		// Extent Test
		ExtentTest test = report.createTest("createContacteithOrgTest");
		test.log(Status.INFO, "login to app");
		test.log(Status.INFO, "navigate to contact module");
		test.log(Status.INFO, "create contact");
		if ("SBI".equals("SBI")) {
			test.log(Status.PASS, " contact is created");
		} else {
			test.log(Status.FAIL, "contact is not created");
		}
	}

	@Test
	public void createContactewithPhoneTest() {
		// Extent Test
		ExtentTest test = report.createTest("createContactewithPhoneTest");
		test.log(Status.INFO, "login to app");
		test.log(Status.INFO, "navigate to contact module");
		test.log(Status.INFO, "create contact");
		if ("SBI".equals("SBI")) {
			test.log(Status.PASS, " contact is created");
		} else {
			test.log(Status.FAIL, "contact is not created");
		}
	}

}
