package com.QA.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.QA.Utilities.ElementUtil;

public class DashBoardPage {
	
	WebDriver driver;
	ElementUtil elementutil;
	
	private By logo_kincrew = By.xpath("//span[@class= 'logo-item']");
	private By calendar = By.xpath("(//a[@href ='/calendar'])[position()=1]");
	private By payment = By.xpath("//a[@href ='/payment']");
	private By profilelist = By.xpath("//img[@src='/static/media/user.f916bd52.svg']");
	private By primaryprofile = By.xpath("//img[@src='/static/media/user.f916bd52.svg']");
	private By householdProfile = By.xpath("//a[@href='/household']/p[text()='Profile']");
	
	
	public DashBoardPage(WebDriver driver)
	{
		this.driver=driver;
		elementutil = new ElementUtil(driver);
	}
	
	public boolean isexistKincrewlogo()
	{
		return elementutil.isDisplayed(logo_kincrew);
	}
	
	public boolean isexistcalendarlink()
	{
		return elementutil.isDisplayed(calendar);
	}
	
	public boolean isexistpaymentlink()
	{
		return elementutil.isDisplayed(payment);
	}
	
	public boolean isexistprofilelistlink()
	{
		return elementutil.isDisplayed(profilelist);
	}
	
	public HouseHoldPage gotoHouseholdPage()
	{
		elementutil.clickWhenReady(primaryprofile, 10);
		elementutil.clickWhenReady(householdProfile, 10);
		return new HouseHoldPage(driver);
	}
	
	

}
