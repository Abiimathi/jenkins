package testcases;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import Bank.xyz.CustomersPage;
import Bank.xyz.HomePage;
import Bank.xyz.ManagerLoginPage;
import projImplementation.ProjectWrappers;
import utils.Excel;


public class TC001 extends ProjectWrappers{
	
	ManagerLoginPage mgp;
	CustomersPage cp;
	
	@BeforeClass
	public void beforeClass() {
		
		testCaseName = "TC001";
		testCaseDescription = "To verify Bank Manager add new customers";
		author = "Abimathi";
		category = "SmokeTest";
		browserName = "chrome";
		url = "https://www.globalsqa.com/angularJs-protractor/BankingProject/#/login";
	}
	
	@Test
	public void CustomerDetails() {
		
		new HomePage(driver,test)
	    .clickBankManagerLogin()
		.clickAddCustomer();
		
		 String xl = "./testdata/TC001.xlsx";

         String Sheet = "Sheet1";

         int rowCount = Excel.getRowCount(xl, Sheet);

         for (int i=1;i<=rowCount;i++)

         {
        	 String fname=Excel.getCellValue(xl, Sheet, i, 0);
             String lname=Excel.getCellValue(xl, Sheet, i, 1);                     
             String pcode = Excel.getCellValue(xl, Sheet, i, 2);
             //Adding the Customer details
              mgp = new ManagerLoginPage(driver,test);
              mgp.enterDetails(fname, lname, pcode);
              //Again clicking on Add Customer button to continue the loop
              mgp.clickAddCustomer();
         }
         
         mgp.clickCustomersTab();
 
         for (int i=1;i<=rowCount;i++)

         {
        	 String fname=Excel.getCellValue(xl, Sheet, i, 0);
             String lname=Excel.getCellValue(xl, Sheet, i, 1);                     
             String cname = fname+lname;
             System.out.println("Excel: "+cname);
             //Verifying the added Customer in the Customer tab
             cp = new CustomersPage(driver,test);
             cp.verifyCustomer(cname);
         }
         
         String Sheet1 = "Sheet2";
         int rowCount1 = Excel.getRowCount(xl, Sheet1);
         for (int i=1;i<=rowCount1;i++)

         {
        	 String fname=Excel.getCellValue(xl, Sheet1, i, 0);
        	 String lname=Excel.getCellValue(xl, Sheet1, i, 1);                     
             String cname = fname+lname;
             //Deleting the Customer
             cp = new CustomersPage(driver,test);
             cp.deleteCustomer(cname);
         }
 		
	
	}
}
