package com.QA.Tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.QA.Base.baseTest;

public class DashBoardTest extends baseTest{
	
	@BeforeClass
	public void dashBoard_Setup()
	{ 
		dashboard = lpage.doLogin(prop.getProperty("Username").trim(), prop.getProperty("Password").trim());
	}
	
	@Test(priority = 1)
	public void kincrewlLogoTest()
	{
		Assert.assertTrue(dashboard.isexistKincrewlogo());
	}
	
	@Test(priority = 2)
	public void calendarIconCheckTest()
	{
		Assert.assertTrue(dashboard.isexistcalendarlink());
	}
	
	@Test(priority = 3)
	public void paymentIconCheckTest()
	{
		Assert.assertTrue(dashboard.isexistcalendarlink());
	}
	
	@Test (priority = 4)
	public void profileIconCheckTest()
	{
		Assert.assertTrue(dashboard.isexistprofilelistlink());
	}
	
	
	@Test
	public void redirectToHouseholdpage()
	{
		dashboard.gotoHouseholdPage();
	}
	
	
	
	
	
	
	
	
	
	
	

}
