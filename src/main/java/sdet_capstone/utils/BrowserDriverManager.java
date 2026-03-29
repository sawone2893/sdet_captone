package sdet_capstone.utils;

import org.openqa.selenium.WebDriver;

import sdet_capstone.driverfactory.BrowserDriverFactory;

public class BrowserDriverManager {

	private static volatile BrowserDriverManager dManager;
	private static ThreadLocal<WebDriver> tLocal = new ThreadLocal<>();

	private BrowserDriverManager() {
		if (dManager != null) {
			throw new IllegalStateException("Driver instance already created!");
		}
	}

	public static BrowserDriverManager getInstance(String browserType, boolean isHeadless) {
		if (dManager == null) {
			synchronized (BrowserDriverManager.class) {
				if (dManager == null) {
					dManager = new BrowserDriverManager();
				}
			}
		}
		if (tLocal.get() == null) {
			tLocal.set(BrowserDriverFactory.getBrowserDriver(browserType).launchBrowser(isHeadless));
		}
		return dManager;

	}

	public WebDriver getDriver() {
		return tLocal.get();
	}

	public void unloadDriver() {
		if (tLocal.get() != null) {
			tLocal.get().quit();
			tLocal.remove();
		}
	}
}
