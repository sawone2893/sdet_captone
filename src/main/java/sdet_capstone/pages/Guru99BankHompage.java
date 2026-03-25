package sdet_capstone.pages;

import sdet_capstone.base.BaseClass;

public class Guru99BankHompage {
	
	
	private static String loginBtnName="btnLogin";
	private static String resetBtnName="btnReset";
	private static String usernameTextBoxName="uid";
	private static String passwordTextBoxName="password";
	
	
	
	public static String getHomePageTitle(){
		return BaseClass.getPageTitle();
	}
	
	public static boolean isLoginButtonPresent() {
		return BaseClass.isElementPresent("NAME", loginBtnName);
	}
	public static boolean isResetButtonPresent() {
		return BaseClass.isElementPresent("NAME", resetBtnName);
	}
	public static boolean isUsernameTextBoxPresent() {
		return BaseClass.isElementPresent("NAME", usernameTextBoxName);
	}
	public static boolean isPasswordTextBoxPresent() {
		return BaseClass.isElementPresent("NAME", passwordTextBoxName);
	}
	
	public static void enterLoginCredentials(String userName,String password) {
		BaseClass.typeIntoTextbox("NAME", usernameTextBoxName,userName);
		BaseClass.typeIntoTextbox("NAME", passwordTextBoxName,password);
		BaseClass.clickElement("NAME", loginBtnName);
	}

}
