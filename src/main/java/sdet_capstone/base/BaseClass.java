package sdet_capstone.base;

import java.util.List;

import org.openqa.selenium.WebElement;

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

	public static void implicitWait(int waitInSeconds) {
		webAction.implementImplicitWait(waitInSeconds);
	}

	public static void closeAppCurrentTabWindow() {
		webAction.closeCurrentTabWindow();
	}

	public static void closeApp() {
		webAction.closeBrowser();
	}

	public static WebElement getWebElement(String locatorType, String locator) {
		return webAction.getElement(locatorType, locator);
	}

	public static List<WebElement> getWebElements(String locatorType, String locator) {
		return webAction.getElements(locatorType, locator);
	}

	public static boolean isElementPresent(String locatorType, String locatorValue) {
		boolean status = true;
		try {
			if (getWebElements(locatorType, locatorValue).size() > 0
					&& webAction.isDisplayed(getWebElement(locatorType, locatorValue))) {
				status = true;
			}
		} catch (Exception e) {
			status = false;
			e.printStackTrace();
		}

		return status;
	}

	public static void clickElement(String locatorType, String locatorValue) {
		if (isElementPresent(locatorType, locatorValue)) {
			webAction.click(getWebElement(locatorType, locatorValue));
		}else {
			throw new IllegalArgumentException("Locator Not Present: "+locatorValue);
		}

	}

	public static void typeIntoTextbox(String locatorType, String locatorValue, String textToType) {
		if (isElementPresent(locatorType, locatorValue)) {
			webAction.type(getWebElement(locatorType, locatorValue), textToType);
		}else {
			throw new IllegalArgumentException("Locator Not Present: "+locatorValue);
		}
	}

	public static String getPageTitle() {
		return webAction.fetchTitle();
	}
	
	public static String getElementText(String locatorType, String locatorValue) {
		if (isElementPresent(locatorType, locatorValue)) {
			return webAction.getVisibleText(getWebElement(locatorType, locatorValue));
		}else {
			throw new IllegalArgumentException("Locator Not Present: "+locatorValue);
		}
	}

}
