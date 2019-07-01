package TestScripts;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import FunctionalData.BaseExtentReport;
import FunctionalData.NewExcelConfig;
import FunctionalData.functionLibs;
import ObjRepo.ObjInfo;

public class Employees extends BaseExtentReport{
	
	WebDriver obrw;
	NewExcelConfig nec=new NewExcelConfig();
	ObjInfo oInfo=new ObjInfo();
	functionLibs fun = new functionLibs();
	JavascriptExecutor js = (JavascriptExecutor) obrw;
	//BasePage chr = new BasePage();
	//readExcelData oExcelcon = new readExcelData();

	/*String ExcelPath="C:\\Users\\10504\\eclipse-workspace\\unity\\src\\test\\java\\TestData\\";
	String FileName="UnityTestData.xlsx";
	String SheetName="UsersPage";*/

	@Test(priority=1)
	public void AddNewEmployee() throws Exception {
		
		test=report.createTest("TC# 2 :: AddNewEmployee"); 
		System.setProperty("webdriver.chrome.driver", oInfo.DriverPath);
		obrw=new ChromeDriver();
		obrw.manage().window().maximize();
		//obrw.get("http://www.imicrondev.com/Automation/Enterprise/Portal");
		obrw.get(oInfo.URL);
		//WebDriverWait wait=new WebDriverWait(obrw, 100);
		nec.readExcel(oInfo.ExcelPath,oInfo.ExcelFile,oInfo.SheetName[2]);	

		obrw.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		obrw.findElement(By.xpath("//a[contains(text(),'Employees')]")).click();
		
		obrw.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		obrw.findElement(By.xpath("//a[contains(text(),'Add New Employee')]")).click();
	}

}
