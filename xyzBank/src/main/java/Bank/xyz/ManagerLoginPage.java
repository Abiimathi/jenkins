package Bank.xyz;

import org.openqa.selenium.remote.RemoteWebDriver;

import com.relevantcodes.extentreports.ExtentTest;
import projImplementation.GenericWrrappers;

public class ManagerLoginPage extends GenericWrrappers{
	
	public ManagerLoginPage(RemoteWebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
	}

	public ManagerLoginPage clickAddCustomer() {
		clickByXpath("//button[@ng-click= 'addCust()']");
		return this;
	}
	               
	public ManagerLoginPage enterDetails(String fname, String lname, String pcode) {
		enterByXpath("//input[@placeholder = 'First Name']", fname);
		enterByXpath("//input[@placeholder = 'Last Name']", lname);
		enterByXpath("//input[@placeholder = 'Post Code']", pcode);
		clickByXpathNoSnap("//button[@type= 'submit' and text()= 'Add Customer']");
		acceptAlert(); 
		return this;
		
	}
	/*public ManagerLoginPage enterFirstName(String fname) {
		enterByXpath("//input[@placeholder = 'First Name']", fname);
		return this;
	}
	
	public ManagerLoginPage enterLastName(String lname) {
		enterByXpath("//input[@placeholder = 'Last Name']", lname);
		return this;
	}
	
	public ManagerLoginPage enterPostCode(String pcode) {
		enterByXpath("//input[@placeholder = 'Post Code']", pcode);
		return this;
	}
	
	public ManagerLoginPage clickAddCust() {
		waittime(2000);
		clickByXpathNoSnap("//button[@type= 'submit' and text()= 'Add Customer']");
		return this;
	}
	
	public ManagerLoginPage clickOk() {
		acceptAlert(); 
		return this;
	}*/
	
	public CustomersPage clickCustomersTab() {
		clickByXpath("//button[@ng-click= 'showCust()']");
		return new CustomersPage(driver,test);
	}
	
}
