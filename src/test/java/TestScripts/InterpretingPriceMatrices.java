package TestScripts;

import java.util.ArrayList;
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

public class InterpretingPriceMatrices extends BaseExtentReport	{
	
	

	
	WebDriver obrw;
	NewExcelConfig nec=new NewExcelConfig();
	ObjInfo oInfo=new ObjInfo();
	functionLibs fun = new functionLibs();
	JavascriptExecutor js = (JavascriptExecutor) obrw;
	
	@Test
	public void AddPriceMatrix() throws Exception {
		test=report.createTest("TC# 1:: AddInterpreterPriceMatrix");
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
		obrw.findElement(By.xpath("//a[contains(text(),'View Interpreting Price Matrices')]")).click();
		
		obrw.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		obrw.findElement(By.xpath("//a[@id='phContent_hlAddNewMatrix']")).click();
		
		ArrayList<String> tabs = new ArrayList<String>(obrw.getWindowHandles());
		obrw.switchTo().window(tabs.get(1));
		
		obrw.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		obrw.findElement(By.xpath("//input[@id='phContent_txtMatrixDescritpion']")).sendKeys("Interpreting");
		
		Select currency=new Select(obrw.findElement(By.xpath("//select[@id='phContent_ddlCurrencies']")));
		currency.selectByVisibleText(nec.GetData(1, 1, 13));
		
		obrw.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		obrw.findElement(By.xpath("//input[@id='phContent_btnSave']")).click();
		
		obrw.switchTo().window(tabs.get(1)).close();
		
		obrw.switchTo().window(tabs.get(0));
		
		obrw.close();

}
}