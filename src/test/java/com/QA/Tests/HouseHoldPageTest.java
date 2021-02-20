package com.QA.Tests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.QA.Base.baseTest;
import com.QA.Utilities.ExcelUtil;

public class HouseHoldPageTest extends baseTest{
	
	
	@BeforeClass
	public void dashBoard_Setup()
	{ 
		dashboard= lpage.doLogin(prop.getProperty("Username").trim(), prop.getProperty("Password").trim());
		householdpage = dashboard.gotoHouseholdPage();
	}
	
	@DataProvider
	public Object[][] getCoparentstestData()
	{
		Object data[][] = ExcelUtil.getTestData("coparent");
		return data;
	}
	
	@Test(dataProvider = "getCoparentstestData")
	public void CreateCoparentTest(String name,String email, String gender )
	{
		householdpage.createCoparent(name,email,gender);
	}

}
