package Bank.xyz;

import org.openqa.selenium.remote.RemoteWebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import projImplementation.GenericWrrappers;

public class HomePage extends GenericWrrappers {

	public HomePage(RemoteWebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
	}
	
	public ManagerLoginPage clickBankManagerLogin() {
		clickByXpath("//button[text() = 'Bank Manager Login']");
		return new ManagerLoginPage(driver, test);
	}
	
	public CustomerLoginPage clickCustomerLogin() {
		clickByXpath("//button[text() = 'Customer Login']");
		return new CustomerLoginPage(driver, test);
	}
}
