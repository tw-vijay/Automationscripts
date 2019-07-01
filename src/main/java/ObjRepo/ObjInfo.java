package ObjRepo;

public class ObjInfo {
	
	public String ExcelPath=System.getProperty("user.dir") +"/src/main/java/TestData";			
	public String ExcelFile="LittlewordTestData.xlsx";
	public String DriverPath=System.getProperty("user.dir") +"/src/main/java/Driver/chromedriver.exe";
	public String URL ="http://dev.thelittleword.com";
	//public String URL ="http://unity.imicroncloud.com/techwave/Home/Signin";
	public String XMLPath =System.getProperty("user.dir") +"/src/test/resources/Unity.xml";
	public String HtmlPath=System.getProperty("user.dir") +"/test-output/LittlewordReport.html";				
	public String[] SheetName = new String[]{"TestScripts","Company","Suppliers"};
	
	
	
	//Login Page
	public String Email="//input[@type='email']";
	public String Password="//input[@type='password']";
	public String Submit="//input[@type='submit']";
	
	
	
}
