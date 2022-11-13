package ExtentReport;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReport {


	static ExtentReports extent;
	public static ExtentReports gereportObject()
	{
		
		String path = System.getProperty("user.dir")+"\\ExtentReports\\ExtentReport.html";
		ExtentSparkReporter reporter = new ExtentSparkReporter(path);
		
		reporter.config().setReportName("Web Automation Result");
		reporter.config().setDocumentTitle("Test Results");
		
		extent = new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("Tester","Yogesh");
		
		
		return extent;
		
	}

}
