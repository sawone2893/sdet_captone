package sdet_capstone.utils;

import org.openqa.selenium.WebDriver;

import sdet_capstone.driverfactory.BrowserDriverFactory;

public class BrowserDriverManager {

	private static ThreadLocal<WebDriver> tLocal = new ThreadLocal<>();

	public static void initDriver(String browserType, boolean isHeadless) {
		tLocal.set(BrowserDriverFactory.getBrowserDriver(browserType).launchBrowser(isHeadless));
	}

	public static WebDriver getDriver() {
		return tLocal.get();
	}

	public static void unloadDriver() {
		if (tLocal.get() != null) {
			tLocal.get().quit();
			tLocal.remove();
		}
	}
}
