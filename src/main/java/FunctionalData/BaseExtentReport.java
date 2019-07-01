package FunctionalData;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestClass;
import org.testng.ITestClassFinder;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import ObjRepo.ObjInfo;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class BaseExtentReport {

	public static ExtentHtmlReporter htmlReporter;
	public static ExtentReports report;
	public static ExtentTest test;
	WebDriver obrw;
	ObjInfo oInfo=new ObjInfo();
	ScreenRecording scrRecording=new ScreenRecording();

	public void starRec() throws Exception
	{

	}

	@BeforeSuite
	public void setUp() throws Exception
	{
		scrRecording.startRecord();

		htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") +"/test-output/LittlewordReport.html");
		report = new ExtentReports();
		report.attachReporter(htmlReporter);



		htmlReporter.config().setChartVisibilityOnOpen(true);
		htmlReporter.config().setDocumentTitle("Techwave.net Reports");
		htmlReporter.config().setReportName("Littleword Report");
		htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP);
		htmlReporter.config().setTheme(Theme.DARK);
	}


	@AfterMethod
	public void getResult(ITestResult result)
	{
		if(result.getStatus() == ITestResult.FAILURE)
		{
			test.log(Status.FAIL, MarkupHelper.createLabel(result.getName()+" Test case FAILED due to below issues:", ExtentColor.RED));
			test.fail(result.getThrowable());

		}
		else if(result.getStatus() == ITestResult.SUCCESS)
		{
			//String screenShotPath=GetScreenShot.capture(driver,"ScreenshotName");
			test.log(Status.PASS, MarkupHelper.createLabel(result.getName()+" Test Case PASSED", ExtentColor.GREEN));


		}
		else
		{
			test.log(Status.SKIP, MarkupHelper.createLabel(result.getName()+" Test Case SKIPPED", ExtentColor.ORANGE));
			test.skip(result.getThrowable());
		}
	}

@AfterSuite
public void teardown() throws InterruptedException{
	report.flush();
	System.setProperty("webdriver.chrome.driver", oInfo.DriverPath);
	obrw=new ChromeDriver();
	obrw.manage().window().maximize();
	obrw.get("file:///"+oInfo.HtmlPath);
	Thread.sleep(2000);
	
}

/*		@AfterSuite
		public void tearDown() throws Exception
		{

			scrRecording.stopRecord();
		}*/

		/*                
                public void stopRec() throws Exception
                {
                                scrRecording.stopRecord();
                }
		 */

	}








