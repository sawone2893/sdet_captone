package sdet_capstone.listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import sdet_capstone.base.BaseClass;
import sdet_capstone.utils.ExtentManager;
import sdet_capstone.utils.ExtentTestManager;

public class TestListener implements ITestListener {

	private static ExtentReports extent = ExtentManager.createInstance();

	@Override
	public void onTestStart(ITestResult result) {
		System.out.println("Test Started: " + result.getName());

		// Create a new entry in the report for this specific test.
		String testName = result.getMethod().getMethodName();
		String browser = result.getTestContext().getCurrentXmlTest().getParameter("browser");

		ExtentTest test = extent.createTest(testName).assignCategory(browser)
				.assignAuthor("Thread-" + Thread.currentThread().getName());
		// Save this test object into the ThreadLocal Storage,
		ExtentTestManager.setTest(test);
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		System.out.println("Test Passed: " + result.getName());
		passed("Test Passed");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		System.out.println("Test Failed: " + result.getName());
		// Log the error text
		failed(result.getThrowable().getMessage());
		// Capture and attach Screenshot.

		try {
			String base64Screenshot = BaseClass.captureSnap();
			ExtentTestManager.getTest().addScreenCaptureFromBase64String(base64Screenshot, "Failure Screenshot!");
		} catch (Exception e) {
			failed("Failed to capture Screenshot: " + e.getMessage());
		}
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		System.out.println("Test Skipped: " + result.getName());
		if (result.wasRetried() && ExtentTestManager.getTest() != null) {
			extent.removeTest(ExtentTestManager.getTest());
			info("Test Retrying: Removed previous attempt from the report");
		} else {
			if (result.getThrowable() != null) {
				skipped("Test Skipped: " + result.getThrowable());
			} else {
				skipped("Test Skipped");
			}
		}
	}

	public void onFinish(ITestContext context) {
		// Write everything to the HTML file.
		if (extent != null) {
			extent.flush();
			ExtentTestManager.unload();
		}

	}
	
	private void info(String message) {
		ExtentTestManager.getTest().info(message);
	}

	private void passed(String message) {
		ExtentTestManager.getTest().pass(message);
	}

	private void failed(String message) {
		ExtentTestManager.getTest().fail(message);
	}

	private void skipped(String message) {
		ExtentTestManager.getTest().skip(message);
	}

}
