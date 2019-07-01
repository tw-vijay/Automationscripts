package TestScripts;

import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.core.util.Assert;
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

public class Company extends BaseExtentReport{
	WebDriver obrw;
	NewExcelConfig nec=new NewExcelConfig();
	ObjInfo oInfo=new ObjInfo();
	functionLibs fun = new functionLibs();
	JavascriptExecutor js = (JavascriptExecutor) obrw;
	

	@Test(priority=1)
	public void AddNewCompany() throws Exception {
		
		test=report.createTest("TC# 1 :: AddNewCompany"); 
		System.setProperty("webdriver.chrome.driver", oInfo.DriverPath);
		obrw=new ChromeDriver();
		obrw.manage().window().maximize();
		//obrw.get("http://www.imicrondev.com/Automation/Enterprise/Portal");
		obrw.get(oInfo.URL);
		//WebDriverWait wait=new WebDriverWait(obrw, 100);
		nec.readExcel(oInfo.ExcelPath,oInfo.ExcelFile,oInfo.SheetName[1]);	

		obrw.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		obrw.findElement(By.xpath("//a[contains(text(),'Companies')]")).click();
		obrw.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		obrw.findElement(By.xpath("//a[contains(text(),'Add New Company')]")).click();
		obrw.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		obrw.findElement(By.xpath("//input[@id='phContent_txtCompanyName']")).sendKeys(nec.GetData(1, 1, 0));
		obrw.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		Select Type=new Select(obrw.findElement(By.xpath("//select[@id='phContent_cmbCompanyType']")));
		Type.selectByVisibleText(nec.GetData(1, 1, 1));
		obrw.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		obrw.findElement(By.xpath("//input[@id='phContent_txtAddress1']")).sendKeys(nec.GetData(1, 1, 2));
		obrw.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		obrw.findElement(By.xpath("//input[@id='phContent_txtPostcode']")).sendKeys(nec.GetData(1, 1, 3));
		obrw.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		Select Country=new Select(obrw.findElement(By.xpath("//select[@id='phContent_cmbCountry']")));
		Country.selectByVisibleText(nec.GetData(1, 1, 4));
		obrw.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		obrw.findElement(By.xpath("//input[@id='phContent_txtSwitchboardPhone']")).sendKeys(nec.GetData(1, 1, 5));
		
		obrw.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		Select Currency=new Select(obrw.findElement(By.xpath("//select[@id='phContent_cmbOperaCurrency']")));
		Currency.selectByVisibleText(nec.GetData(1, 1, 6));
		
		
		obrw.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		obrw.findElement(By.xpath("//input[@id='phContent_chkEstablished3Years']")).click();
		
		obrw.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		obrw.findElement(By.xpath("//input[@id='phContent_txtAccCompanyName']")).sendKeys(nec.GetData(1, 1, 0));
		
		obrw.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		obrw.findElement(By.xpath("//input[@id='phContent_txtAccPostcode']")).sendKeys(nec.GetData(1, 1, 3));
		obrw.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		obrw.findElement(By.xpath("//input[@id='phContent_txtEmailSuffix']")).sendKeys(nec.GetData(1, 1, 7));
		
		obrw.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		Select Businesstype=new Select(obrw.findElement(By.xpath("//select[@id='phContent_cmbBusinessType']")));
		Businesstype.selectByVisibleText(nec.GetData(1, 1, 8));
		
		obrw.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		Select Salesreg=new Select(obrw.findElement(By.xpath("//select[@id='phContent_ddlSalesRegion']")));
		Salesreg.selectByVisibleText(nec.GetData(1, 1, 9));
		
		obrw.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		Select SalesClsssification=new Select(obrw.findElement(By.xpath("//select[@id='phContent_ddlSalesClassification']")));
		SalesClsssification.selectByVisibleText(nec.GetData(1, 1, 10));
		
		obrw.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		obrw.findElement(By.xpath("//input[@id='phContent_txtAccCompanyName']")).sendKeys(nec.GetData(1, 1, 0));
		
		obrw.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		obrw.findElement(By.xpath("//input[@id='phContent_txtAccAddress1']")).sendKeys(nec.GetData(1, 1, 2));
		
	    Select AccCountry=new Select(obrw.findElement(By.xpath("//select[@id='phContent_ddlAccCountry']")));
		AccCountry.selectByVisibleText(nec.GetData(1, 1, 4));
		
		obrw.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		obrw.findElement(By.xpath("//input[@id='phContent_cmdSave']")).click();
		obrw.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		
		Boolean Errmsg=fun.isElementPresent(obrw,By.xpath("//div[@id='phContent_ValidationSummary2']"));
		if( Errmsg)
		{
			String fail = obrw.findElement(By.xpath("//div[@id='phContent_ValidationSummary2']")).getText();
			test.fail(fail);
		}
		
		obrw.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		String compcode = obrw.findElement(By.xpath("//td[@id='AddressInformationCompanyCode']")).getText();
		//System.out.println(compcode);
		nec.setCellData(1, 1, 11, compcode);
		
		
	}
	
	@Test(priority=2)
	public void Companysearch() throws Exception {
		test=report.createTest("TC# 1.1 :: Companysearch"); 
		System.setProperty("webdriver.chrome.driver", oInfo.DriverPath);
		obrw=new ChromeDriver();
		obrw.manage().window().maximize();
		//obrw.get("http://www.imicrondev.com/Automation/Enterprise/Portal");
		obrw.get(oInfo.URL);
		//WebDriverWait wait=new WebDriverWait(obrw, 100);
		nec.readExcel(oInfo.ExcelPath,oInfo.ExcelFile,oInfo.SheetName[1]);
		
		obrw.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		obrw.findElement(By.xpath("//a[contains(text(),'Companies')]")).click();
		
		obrw.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		obrw.findElement(By.xpath("//input[@id='phContent_txtClientCode']")).sendKeys(nec.GetData(1, 1, 11));
		
		obrw.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		obrw.findElement(By.xpath("//input[@id='phContent_cmdSearch']")).click();
		
		obrw.close();
		
	}
	
}