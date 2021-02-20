package com.QA.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.QA.Base.basePage;
import com.QA.Utilities.Constants;
import com.QA.Utilities.ElementUtil;

public class loginPage extends basePage {

	 WebDriver driver;
	 ElementUtil elementutil;
	
	// 1) write the page locators By locators
	
	private By email = By.name("email");
	private By pwd = By.name("password");
	private By login_Button = By.xpath("//span[text()='Login']");
	private By forgot_Password = By.xpath("//a[text() = 'Forgot Password?']");
	
	// 2) create a constructor of the page class
	
	public loginPage(WebDriver driver)
	{
		this.driver=driver;
		elementutil = new ElementUtil(driver);
	}
	
	// 3) Page actions and page methods
	
	public String getLoginPageTitle()
	{
		String pagetitle = elementutil.waitForPageTitlePresent(Constants.LOGIN_PAGE_TITLE, 10);
		return pagetitle;
	}
	
	public boolean isforgotpassworButtonExist()
	{
		return elementutil.isDisplayed(forgot_Password);
	}
	
	public DashBoardPage doLogin(String username, String password)
	{
		System.out.println("Login with "+ username + "and" + password );
		
		elementutil.doSendKeys(email, username);
		elementutil.doSendKeys(pwd, password);
		elementutil.doClick(login_Button);
		return new DashBoardPage(driver);
			
	}
}
