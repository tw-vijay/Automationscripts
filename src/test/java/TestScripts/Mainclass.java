package TestScripts;

import java.util.List;

import org.testng.TestListenerAdapter;

import com.beust.jcommander.internal.Lists;
import com.beust.testng.TestNG;

import ObjRepo.ObjInfo;

public class Mainclass {
	
	 
		public static void main(String[] args) {
				ObjInfo oInfo=new ObjInfo();
				TestListenerAdapter tla = new TestListenerAdapter();
				TestNG testng = new TestNG();
				List<String> suites = Lists.newArrayList();
				suites.add(oInfo.XMLPath);//path to xml..
				testng.setTestSuites(suites);
				testng.run();

			} 
		 


}
