package sdet_capstone.base;

import sdet_capstone.core.SeleniumWebActions;
import sdet_capstone.core.WebActions;

public class BaseClass {

	private static WebActions webAction = null;

	public static void launchBrowser(String browserType) {
		webAction = new SeleniumWebActions();
		webAction.initBrowser(browserType);
	}
	
	public static void startApp(String appUrl) {
		webAction.launchUrl(appUrl);
	}
	
	public static void closeAppCurrentTabWindow() {
		webAction.closeCurrentTabWindow();
	}
	
	public static void closeApp() {
		webAction.closeBrowser();
	}

}
