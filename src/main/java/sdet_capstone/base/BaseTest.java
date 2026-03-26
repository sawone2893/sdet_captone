package sdet_capstone.base;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import sdet_capstone.utils.PropertyFileManager;

public class BaseTest {

	@BeforeClass
	public void browserSetup() {
		BaseClass.launchBrowser(PropertyFileManager.getPropertyValue("BROWSER_TYPE"));
		BaseClass.startApp(PropertyFileManager.getPropertyValue("APP_URL"));
		BaseClass.implicitWait(Integer.parseInt(PropertyFileManager.getPropertyValue("DEFAULT_IMPLICIT_WAIT")));
	}

	@AfterClass
	public void closeApp() {
		BaseClass.closeAppCurrentTabWindow();
		BaseClass.closeApp();
	}

}
