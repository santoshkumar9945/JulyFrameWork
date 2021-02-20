package com.QA.Base;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.QA.Pages.DashBoardPage;
import com.QA.Pages.HouseHoldPage;
import com.QA.Pages.loginPage;

public class baseTest {
	
	WebDriver driver;
	protected basePage bpage;
	protected Properties prop;
	protected loginPage lpage;
	protected DashBoardPage dashboard;
	protected HouseHoldPage householdpage;
	
	
	@Parameters({"browser"})
	@BeforeTest
	public void setup(String browserName) 
	{
	 bpage = new basePage();
	 prop= bpage.init_properties();
	 prop.setProperty("browser", browserName);
	 driver=bpage.init_browser(prop);
	 lpage = new loginPage(driver);
	  
	}
	
	@AfterTest
	public void tearDown()
	{
		driver.quit();
	}

}
