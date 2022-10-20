package Bank.xyz;

import org.openqa.selenium.remote.RemoteWebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import projImplementation.GenericWrrappers;

public class CustomerLoginPage extends GenericWrrappers {

	public CustomerLoginPage(RemoteWebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
	}
	
	public CustomerLoginPage selectName(String name) {
		selectVisibileTextById("userSelect", name);
		return this;
	}
	

	public AccountSummaryPage clickLogin() {
		clickByXpath("//button[@type='submit' and text() = 'Login']");
		return new AccountSummaryPage(driver,test);
	}
}
