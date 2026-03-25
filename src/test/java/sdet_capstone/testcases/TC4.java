package sdet_capstone.testcases;

import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.Test;

import sdet_capstone.base.BaseTest;
import sdet_capstone.pages.Guru99BankHompage;
import sdet_capstone.pages.Guru99BankMangerHomePage;
import sdet_capstone.utils.ExcelManager;
import sdet_capstone.utils.PropertyFileManager;

public class TC4 extends BaseTest{
	
	@Test
	public void verifyManagerHomePageTitle() {
		Map<String,String> testcaseData=ExcelManager.getTestCaseData("TC4");
		Assert.assertEquals(Guru99BankHompage.getHomePageTitle(), PropertyFileManager.getPropertyValue("GURU99_BANK_HOME_PAGE_TITLE"));
		Guru99BankHompage.enterLoginCredentials(testcaseData.get("USER_ID"), testcaseData.get("PASSWORD"));
		Assert.assertEquals(Guru99BankMangerHomePage.getBankMangerHomePageTitle(), PropertyFileManager.getPropertyValue("GURU99_BANK_MANAGER_HOME_PAGE_TITLE"));
	}

}
