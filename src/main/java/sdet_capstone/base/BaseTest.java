package sdet_capstone.base;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import sdet_capstone.utils.PropertyFileManager;

public class BaseTest {
	
	@BeforeTest
	public void browserSetup() {
		BaseClass.launchBrowser(PropertyFileManager.getPropertyValue("BROWSER_TYPE"));
	}
	
	@BeforeMethod
	public void appLaunch() {
		BaseClass.startApp(PropertyFileManager.getPropertyValue("APP_URL"));
		BaseClass.implicitWait(Integer.parseInt(PropertyFileManager.getPropertyValue("DEFAULT_IMPLICIT_WAIT")));
	}
	
	@AfterMethod
	public void closeApp() {
		BaseClass.closeAppCurrentTabWindow();
	}
	
	@AfterTest
	public void terminateBrowser() {
		BaseClass.closeApp();
	}
	

}
