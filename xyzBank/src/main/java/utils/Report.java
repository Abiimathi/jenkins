package utils;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public abstract class Report {

	public static ExtentReports report;
	public  ExtentTest test;
	
	public String testCaseName, testCaseDescription;
	public String author, category;
	
	public void startReport() {
		report = new ExtentReports("./report/result.html");
	}
	
	public void startTest(String testname, String description) {
		test = report.startTest(testname, description);
		test.assignAuthor(author);
		test.assignCategory(category);
	}
	
	public abstract long takeSnap();
	
	public void reportStep(String details, String status) {
		
		long snapnumber = takeSnap();
		
		if(status.equalsIgnoreCase("pass")) {
			test.log(LogStatus.PASS, details + test.addScreenCapture(".././report/screenshot/"+snapnumber+".png"));
		}
		else if(status.equalsIgnoreCase("fail")) {
			test.log(LogStatus.FAIL, details + test.addScreenCapture(".././report/screenshot/"+snapnumber+".png"));
		}
		else if(status.equalsIgnoreCase("info")) {
			test.log(LogStatus.INFO, details + test.addScreenCapture(".././report/screenshot/"+snapnumber+".png"));
		}
		else if(status.equalsIgnoreCase("warning")) {
			test.log(LogStatus.WARNING, details + test.addScreenCapture(".././report/screenshot/"+snapnumber+".png"));
		}
	}
	
	public void reportStep(String details, String status, boolean snap) {
	
			if(!snap) {
				
				if(status.equalsIgnoreCase("pass")) {
					test.log(LogStatus.PASS, details);
				}
				else if(status.equalsIgnoreCase("fail")) {
					test.log(LogStatus.FAIL, details);
				}
				else if(status.equalsIgnoreCase("info")) {
					test.log(LogStatus.INFO, details);
				}
				else if(status.equalsIgnoreCase("warning")) {
					test.log(LogStatus.WARNING, details);
				}
			}	
	}
	
	public void endTest() {
		report.endTest(test);
	}
	
	public void endReport() {
		report.flush();
	}
}

