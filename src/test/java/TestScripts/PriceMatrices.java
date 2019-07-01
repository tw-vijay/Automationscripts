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

public class PriceMatrices extends BaseExtentReport{
	
	WebDriver obrw;
	NewExcelConfig nec=new NewExcelConfig();
	ObjInfo oInfo=new ObjInfo();
	functionLibs fun = new functionLibs();
	JavascriptExecutor js = (JavascriptExecutor) obrw;
	
	@Test
	public void AddPriceMatrix() throws Exception {
		test=report.createTest("TC# 1.2 :: AddPriceMatrix"); 
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
		obrw.findElement(By.xpath("//a[contains(text(),'View Price Matrices')]")).click();
		
		obrw.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		obrw.findElement(By.xpath("//a[@id='phContent_hlkAddNewMatrix']")).click();
		
		obrw.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		obrw.findElement(By.xpath("//input[@id='phContent_txtMatrixName']")).sendKeys(nec.GetData(1, 1, 12));
		
		Select currency=new Select(obrw.findElement(By.xpath("//select[@id='phContent_cmbCurrency']")));
		currency.selectByVisibleText(nec.GetData(1, 1, 13));
		
		obrw.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		obrw.findElement(By.xpath("//input[@id='phContent_btnAdd']")).click();
		
        Boolean Errmsg=fun.isElementPresent(obrw,By.xpath("//span[@id='phContent_lblErrorMessage']"));
        if(Errmsg){
		String fail = obrw.findElement(By.xpath("//span[@id='phContent_lblErrorMessage']")).getText();
		test.fail(fail);
		
		obrw.close();
		
        }
		
	}


}
