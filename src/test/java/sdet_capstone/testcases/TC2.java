package sdet_capstone.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import sdet_capstone.base.BaseTest;
import sdet_capstone.pages.Guru99BankHompage;
import sdet_capstone.utils.PropertyFileManager;

public class TC2 extends BaseTest{
	
	@Test
	public void verifyUIEleemntsPresence() {
		Assert.assertEquals(Guru99BankHompage.getHomePageTitle(), PropertyFileManager.getPropertyValue("GURU99_BANK_HOME_PAGE_TITLE"));
		Assert.assertTrue(Guru99BankHompage.isLoginButtonPresent());
		Assert.assertTrue(Guru99BankHompage.isResetButtonPresent());
		Assert.assertTrue(Guru99BankHompage.isUsernameTextBoxPresent());
		Assert.assertTrue(Guru99BankHompage.isPasswordTextBoxPresent());
	}

}
