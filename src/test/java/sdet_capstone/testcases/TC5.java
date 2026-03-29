package sdet_capstone.testcases;

import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.Test;

import sdet_capstone.base.BaseTest;
import sdet_capstone.pages.Guru99BankHompage;
import sdet_capstone.pages.Guru99BankMangerHomePage;
import sdet_capstone.utils.Config;
import sdet_capstone.utils.ExcelManager;

public class TC5 extends BaseTest{
	
	@Test
	public void verifyUIElementManagerNewCustomer() {
		Map<String,String> testcaseData=ExcelManager.getTestCaseData("TC5");
		Assert.assertEquals(Guru99BankHompage.getHomePageTitle(), Config.get("GURU99_BANK_HOME_PAGE_TITLE"));
		Guru99BankHompage.enterLoginCredentials(testcaseData.get("USER_ID"), testcaseData.get("PASSWORD"));
		Assert.assertEquals(Guru99BankMangerHomePage.getBankMangerHomePageTitle(), Config.get("GURU99_BANK_MANAGER_HOME_PAGE_TITLE"));
		Assert.assertTrue(Guru99BankMangerHomePage.isManagerHyperLinkDisplayed());
		Assert.assertTrue(Guru99BankMangerHomePage.isNewCustomerHyperLinkDisplayed());
	}

}
