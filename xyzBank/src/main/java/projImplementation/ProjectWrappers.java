package projImplementation;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

public class ProjectWrappers extends GenericWrrappers{

	public String browserName;
	public String url;
	
	@BeforeSuite
	public void beforeSuite(){
		startReport();
	}
	
	@BeforeTest
	public void beforeTest() {
		
	}
	
	
	@BeforeMethod
	public void beforeMethod() {
		startTest(testCaseName, testCaseDescription);
		invokeApp(browserName, url);
	}
	
	@AfterMethod
	public void afterMethod() {
		closeAllBrowsers();
	}
	
	@AfterClass
	public void afterClass() {
		endTest();
	}
	
	@AfterTest
	public void afterTest() {
		
	}
	
	@AfterSuite
	public void afterSuite() {
		endReport();
	}
	
	
	
}
