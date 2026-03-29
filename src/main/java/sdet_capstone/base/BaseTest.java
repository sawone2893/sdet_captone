package sdet_capstone.base;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import sdet_capstone.utils.Config;

public class BaseTest {

	@Parameters({ "browserType", "isHeadless" })
	@BeforeClass
	public void browserSetup(@Optional("CHROME") String browserType, @Optional("false") String isHeadless) {
		Config.init();
		BaseClass.launchBrowser(browserType, Boolean.parseBoolean(isHeadless));
		BaseClass.maximizeBrowserMode();
		BaseClass.startApp(Config.get("APP_URL"));
		BaseClass.implicitWait(Integer.parseInt(Config.get("DEFAULT_IMPLICIT_WAIT")));
	}

	@AfterClass
	public void closeApp() {
		BaseClass.closeApp();
	}

}
