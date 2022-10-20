package testcases;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import Bank.xyz.AccountSummaryPage;
import Bank.xyz.HomePage;
import projImplementation.ProjectWrappers;
import utils.Excel;

public class TC002 extends ProjectWrappers{

	AccountSummaryPage asp;
	
	@BeforeClass
	public void beforeClass() {
		
		testCaseName = "TC002";
		testCaseDescription = "To verify the Customer Transactions";
		author = "Abimathi";
		category = "SmokeTest";
		browserName = "chrome";
		url = "https://www.globalsqa.com/angularJs-protractor/BankingProject/#/login";
	}
	
	@Test
	public void customerLogin() {
		new HomePage(driver, test)
		.clickCustomerLogin()
		.selectName("Hermoine Granger")
		.clickLogin()
		.selectAccount(2)
		.verifyInitBalance("0");
		
		 String xl = "./testdata/TC002.xlsx";

         String Sheet = "Sheet1";

         int rowCount = Excel.getRowCount(xl, Sheet);
         int sum=0;
         for (int i=1;i<=rowCount;i++)

         {
        	 String amount=Excel.getCellValue(xl, Sheet, i, 0);
             String transaction=Excel.getCellValue(xl, Sheet, i, 1);
             //Perform Debit and Credit Transactions
             asp = new AccountSummaryPage(driver, test);
             asp.performTransaction(amount, transaction);
             int amt = Integer.parseInt(amount);
     		
     		if(transaction.equalsIgnoreCase("Credit")) {
     			sum=sum+amt;
     		}
     		else if(transaction.equalsIgnoreCase("Debit")) {
     			sum = sum-amt;
     		}
     		Excel.setCellValue(xl, Sheet, i, 2, sum);
     		
     		asp.verifyBalance(sum);
         }
         
		
	}
}
