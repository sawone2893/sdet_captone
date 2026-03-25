package sdet_capstone.pages;

import sdet_capstone.base.BaseClass;

public class Guru99BankMangerHomePage {
	
	private static String welcomeMsg="//marquee[@class='heading3']";

	public static String getBankMangerHomePageTitle() {
		return BaseClass.getPageTitle();
	}
	
	public static String getWelcomeMessageText() {
		return BaseClass.getElementText("XPATH", welcomeMsg);
	}

	public static boolean isManagerHyperLinkDisplayed() {
		return BaseClass.isElementPresent("linktext", "Manager");
	}

	public static boolean isNewCustomerHyperLinkDisplayed() {
		return BaseClass.isElementPresent("linktext", "New Customer");
	}

}
