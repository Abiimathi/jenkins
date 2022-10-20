package Bank.xyz;

  import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.ExtentTest;

import projImplementation.GenericWrrappers;

public class AccountSummaryPage  extends GenericWrrappers {

	public AccountSummaryPage(RemoteWebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
	}
	
	public AccountSummaryPage selectAccount(int account) {
		selectIndexById("accountSelect", account);
		return this;
	}
	
	public AccountSummaryPage verifyInitBalance(String value) {
		verifyTextByXpath("//div[@class='center']/strong[2]", value);
		return this;
	}
	
	public AccountSummaryPage performTransaction(String amount, String transaction){
		if(transaction.equalsIgnoreCase("Credit")) {
			clickByXpath("//button[@ng-click = 'deposit()']");
			enterByXpath("//input[@placeholder = 'amount']", amount);
			clickByXpath("//button[@type= 'submit' and text() = 'Deposit']");
		}
		else if(transaction.equalsIgnoreCase("Debit")) {
			clickByXpath("//button[@ng-click = 'withdrawl()']");
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		//	WebDriverWait wait = new WebDriverWait(driver,30);
		//	wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@placeholder = 'amount']")));
			clickByXpath("//input[@placeholder = 'amount']");
			enterByXpath("//input[@placeholder = 'amount']", amount);
			clickByXpath("//button[@type= 'submit' and text() = 'Withdraw']");
		}
		return this;
	}
	
	public AccountSummaryPage verifyBalance(int sum) {
		String balance = Integer.toString(sum);
		verifyTextByXpath("//div[@class='center']/strong[2]", balance);
		return this;
	}
		
}

