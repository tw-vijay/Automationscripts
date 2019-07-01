package FunctionalData;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class functionLibs {
	
	
	public Boolean elementExists(WebDriver obrw,By ele)
	{
		boolean exists= true;
		try
		{
			boolean display=obrw.findElements(ele).size()>0;
			exists=display;
			
		}
		catch(Exception e)
		{
			exists=false;
		
		}
		return exists;
		
	}
	
	public boolean isElementPresent(WebDriver obrw,By by) {
		 obrw.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);  
		try {
			boolean display=obrw.findElements(by).size()>0;
		
			return display;
		} catch (NoSuchElementException e) {
			return false;
		}
		 finally {  
		        obrw.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);  
		    }  
	}
}

