package com.QA.Tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.QA.Base.baseTest;
import com.QA.Utilities.Constants;

public class loginPageTest extends baseTest {
	
	@Test(priority = 1)
	public void verifyLoginPageTitle()
	{
		String loginPageTitle = lpage.getLoginPageTitle();
		System.out.println(loginPageTitle);
		Assert.assertEquals(loginPageTitle, Constants.LOGIN_PAGE_TITLE, Constants.TITLE_ERORO_MESSAGE);
	}
	
	@Test(priority = 2)
	public void verifytheForgotPasswordButton()
	{
		Assert.assertTrue(lpage.isforgotpassworButtonExist());
	}
	
	@Test(priority = 3)
	public void verifyLogin()
	{
		lpage.doLogin(prop.getProperty("Username").trim(), prop.getProperty("Password").trim());
	}

}
