package TestScripts;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import FunctionalData.BaseExtentReport;
import FunctionalData.NewExcelConfig;
import FunctionalData.functionLibs;
import ObjRepo.ObjInfo;

public class Suppliers extends BaseExtentReport{
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
	public void AddNewSupplier() throws Exception {
		
		test=report.createTest("TC# 1 :: AddNewSupplier"); 
		System.setProperty("webdriver.chrome.driver", oInfo.DriverPath);
		obrw=new ChromeDriver();
		obrw.manage().window().maximize();
		//obrw.get("http://www.imicrondev.com/Automation/Enterprise/Portal");
		obrw.get(oInfo.URL);
		//WebDriverWait wait=new WebDriverWait(obrw, 100);
		nec.readExcel(oInfo.ExcelPath,oInfo.ExcelFile,oInfo.SheetName[2]);	

		obrw.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		obrw.findElement(By.xpath("//a[contains(text(),'Suppliers')]")).click();
		
		obrw.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		obrw.findElement(By.xpath("//a[contains(text(),'Add New Supplier')]")).click();
		
		obrw.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		obrw.findElement(By.xpath("//input[@id='phContent_txtCompanyName']")).sendKeys(nec.GetData(2, 1, 0));
		
		obrw.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		obrw.findElement(By.xpath("//input[@id='phContent_txtForename']")).sendKeys(nec.GetData(2, 1, 1));
		
		obrw.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		obrw.findElement(By.xpath("//input[@id='phContent_txtAddress1']")).sendKeys(nec.GetData(2, 1, 2));
		
		obrw.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		obrw.findElement(By.xpath("//input[@id='phContent_txtPostcode']")).sendKeys(nec.GetData(2, 1, 3));
		
		Select Country=new Select(obrw.findElement(By.xpath("//select[@id='phContent_cmbCountry']")));
		Country.selectByVisibleText(nec.GetData(2, 1, 4));
		
		obrw.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		obrw.findElement(By.xpath("//input[@id='phContent_txtEmail']")).sendKeys(nec.GetData(2, 1, 5));
		
		Select Timezone=new Select(obrw.findElement(By.xpath("//select[@id='phContent_ddlTimeZone']")));
		Timezone.selectByVisibleText(nec.GetData(2, 1, 6));
		
		obrw.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		obrw.findElement(By.xpath("//input[@id='phContent_chkLinguisticQAOn']")).click();
		
		obrw.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		obrw.findElement(By.xpath("//input[@id='phContent_chkHasRestrictedLDView']")).click();
		
		obrw.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		obrw.findElement(By.xpath("//input[@id='phContent_cmdSave']")).click();
		
}
}
