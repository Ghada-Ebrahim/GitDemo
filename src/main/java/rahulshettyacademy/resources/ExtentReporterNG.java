package rahulshettyacademy.resources;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReporterNG {
	public static ExtentReports getReportObject()
	{
		String path=System.getProperty("user.dir")+"\\reports\\IndexOutOfBoundsException.html";
		//The next statement is responsible to create configuration and create report
		ExtentSparkReporter reporter=new ExtentSparkReporter(path);
		reporter.config().setReportName("Web Automation Results");
		reporter.config().setDocumentTitle("Test Results");
		
		//to add the report to main class
		ExtentReports extent= new ExtentReports();
		extent.attachReporter(reporter);
		//To add the tester name.
		extent.setSystemInfo("Tester", "Ghada");
		return extent;
	}

}
