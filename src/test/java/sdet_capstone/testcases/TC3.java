package sdet_capstone.testcases;

import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.Test;

import sdet_capstone.base.BaseTest;
import sdet_capstone.pages.Guru99BankHompage;
import sdet_capstone.pages.Guru99BankMangerHomePage;
import sdet_capstone.utils.ExcelManager;
import sdet_capstone.utils.PropertyFileManager;

public class TC3 extends BaseTest{
	
	@Test
	public void verifySuccessfulLogin() {
		Map<String,String> testcaseData=ExcelManager.getTestCaseData("TC3");
		Assert.assertEquals(Guru99BankHompage.getHomePageTitle(), PropertyFileManager.getPropertyValue("GURU99_BANK_HOME_PAGE_TITLE"));
		Guru99BankHompage.enterLoginCredentials(testcaseData.get("USER_ID"), testcaseData.get("PASSWORD"));
		Assert.assertEquals(Guru99BankMangerHomePage.getWelcomeMessageText(), PropertyFileManager.getPropertyValue("WELCOME_MSG"));
	}

}
