
package Bank.xyz;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import com.relevantcodes.extentreports.ExtentTest;
import projImplementation.GenericWrrappers;

public class CustomersPage extends GenericWrrappers{
	
	public CustomersPage(RemoteWebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
	}
	
	
	public CustomersPage verifyCustomer(String cname) {
		
		List<WebElement> tag = driver.findElementsByXPath("//tr[contains(@ng-repeat, 'cust in Customers')]");
		List<String> list=new ArrayList<String>(); 
		
		for(int i=1;i<=tag.size();i++) {	
			String fname = getTextByXpath("(//tr[contains(@ng-repeat, 'cust in Customers')]["+i+"])//td[1]");
			String lname = getTextByXpath("(//tr[contains(@ng-repeat, 'cust in Customers')]["+i+"])//td[2]");
			String name = fname+lname;
			list.add(name);
		}
		if(list.contains(cname))
		{
			reportStep("The Customer "+cname+" is present", "pass");
		}
		else
		{
			reportStep("The Customer is not present", "fail");
		}
		return this;
	}
	
	public CustomersPage deleteCustomer(String cname) {
		enterByXpath("//html/body", Keys.PAGE_DOWN, "PageDown");
		List<WebElement> tag = driver.findElementsByXPath("//tr[contains(@ng-repeat, 'cust in Customers')]");
		int size = tag.size();
		for(int i=1;i<=size;i++) {
			String fname = getTextByXpath("(//tr[contains(@ng-repeat, 'cust in Customers')]["+i+"])//td[1]");
			String lname = getTextByXpath("(//tr[contains(@ng-repeat, 'cust in Customers')]["+i+"])//td[2]");
			if(cname.equalsIgnoreCase(fname+lname)) {
				clickByXpath("(//tr[contains(@ng-repeat, 'cust in Customers')]["+i+"])//td[5]");
				size--;
				reportStep("The Customer "+cname+" is Deleted", "pass");
			}
		}
	
		
		return this;
	}
}
