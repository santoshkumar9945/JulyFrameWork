package com.QA.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.QA.Base.basePage;
import com.QA.Utilities.ElementUtil;

public class HouseHoldPage extends basePage{

	WebDriver driver;
	ElementUtil elementutil;
	
	private By coparentaddbutton = By.xpath("//span[text()='Coparents']//following-sibling::button");
	private By addCoparentPopUpHeader = By.xpath("//span[text()='Add Coparent']");
	
	private By coparentName = By.xpath("//input[@placeholder='Enter Name']");
	private By coparentEmailAddress = By.xpath("//input[@placeholder='Email address']");
	private By clickonGenderDropdown = By.xpath("//span[@title='Select Gender']");
	private By genderDropDown = By.xpath("//div[@class='ant-select-item-option-content']");
	private By saveToCoparentButton = By.xpath("//span[text()='Save Co-Parent']");
	private By addCoparentOkButton = By.xpath("//button[@class='ant-btn ant-btn-primary btn fp-button-primary']");
	private By coparentlist = By.xpath("//div[@class='inside-info']/span");
	
	
	public HouseHoldPage(WebDriver driver)
	{
		this.driver=driver;
		elementutil = new ElementUtil(driver);
	}
	
	public void createCoparent(String name,String email, String gender)
	{
		elementutil.doClick(coparentaddbutton);
		if(elementutil.doGetText(addCoparentPopUpHeader).equals("Add Coparent"))
		{
			
			elementutil.waitForElementToBeVisible(coparentName, 10);
			
			elementutil.doSendKeys(coparentName, name);
			elementutil.doSendKeys(coparentEmailAddress, email);
			elementutil.doClick(clickonGenderDropdown);
			elementutil.selectDropDownValueWithoutSelectClass(genderDropDown, gender);
			elementutil.doClick(saveToCoparentButton);
			elementutil.clickWhenReady(addCoparentOkButton, 10);
			elementutil.waitForElementToBeVisible(coparentaddbutton, 10);
			
			
		}
		
	}
	
//	public void gettheCoparent()
//	{
//		List<WebElement> coparentnames=elementutil.getElements(coparentlist);
//		if(coparentnames.equals(do))
//		{
//			elementutil.doGetText(locator)
//		}
//		
//	}
	
	
}
