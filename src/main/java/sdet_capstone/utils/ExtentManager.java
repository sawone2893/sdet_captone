package sdet_capstone.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentManager {

	private static ExtentReports extent;

	public static ExtentReports createInstance() {
		if (extent == null) {
			String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
			String reportFilePath = System.getProperty("user.dir") + "/test-output/reports/Report_" + timestamp
					+ ".html";
			// Create the reporter:HTML File location
			ExtentSparkReporter sparkReporter = new ExtentSparkReporter(reportFilePath);

			// Configure the report design
			sparkReporter.config().setTheme(Theme.DARK);
			sparkReporter.config().setDocumentTitle("Automation Execution Report");
			sparkReporter.config().setReportName("Regression Suite Result");

			// Attach reporter to ExtentReports engine
			extent = new ExtentReports();
			extent.attachReporter(sparkReporter);

			// Add System Info
			extent.setSystemInfo("OS", System.getProperty("os.name"));
			extent.setSystemInfo("Java Version", System.getProperty("java.version"));
			extent.setSystemInfo("User", System.getProperty("user.name"));
		}
		return extent;
	}

}
