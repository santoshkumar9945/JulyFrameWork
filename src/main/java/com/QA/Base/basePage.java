package com.QA.Base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.QA.Utilities.OptionsManager;

import io.github.bonigarcia.wdm.WebDriverManager;

public class basePage {	
	public WebDriver driver;
	public Properties prop;
	public OptionsManager optionsmanger;
	public static String highlight; 
	public static ThreadLocal<WebDriver> tldriver = new ThreadLocal<WebDriver>();
	
	
	/**
	 * This method is used to initialize the webdriver
	 * @param browserName
	 * @return driver object
	 */
	public  WebDriver init_browser(Properties prop)
	{
		String browserName = prop.getProperty("browser");
		System.out.println("name is "+ browserName);
		highlight = prop.getProperty("highlight");
		optionsmanger = new OptionsManager(prop);
		
		
		if(browserName.equals("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			if(Boolean.parseBoolean(prop.getProperty("remote")))
			{
				init_remoteDriver(browserName);
			}else
			{
				//driver = new ChromeDriver(optionsmanger.getChromeOptions());
				tldriver.set(new ChromeDriver(optionsmanger.getChromeOptions()));
			}
			
			
		}else
			if(browserName.equals("firefox"))
			{
				WebDriverManager.firefoxdriver().setup();
				if(Boolean.parseBoolean(prop.getProperty("remote")))
				{
					init_remoteDriver(browserName);
				}else
				{
					//driver = new FirefoxDriver(optionsmanger.getFirefoxOptions());
					tldriver.set(new FirefoxDriver(optionsmanger.getFirefoxOptions()));
				}
				
			}else
				if(browserName.equals("edge"))
				{
					WebDriverManager.edgedriver().setup();
					driver = new EdgeDriver();
					tldriver.set(new EdgeDriver());
				}else
					System.out.println("Please pass the correct browser "+ browserName );
		
		getDriver().manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		getDriver().manage().deleteAllCookies();
		getDriver().manage().window().maximize();
		getDriver().get(prop.getProperty("url"));
		
		return getDriver();
	}
	/**
	 * this method will design capblities and initilize the driver with remotely
	 * @param browsername
	 */
	public void init_remoteDriver(String browsername)
	{
		if(browsername.equals("chrome"))
		{
			DesiredCapabilities cap = DesiredCapabilities.chrome();
			cap.setCapability(ChromeOptions.CAPABILITY, optionsmanger.getChromeOptions());
			try {
				tldriver.set(new RemoteWebDriver(new URL(prop.getProperty("huburl")), cap));
			} catch (MalformedURLException e) {
				
				e.printStackTrace();
			}
		} else
			if(browsername.equals("firefox"))
			{
				DesiredCapabilities cap = DesiredCapabilities.firefox();
				cap.setCapability(FirefoxOptions.FIREFOX_OPTIONS, optionsmanger.getFirefoxOptions());
				try {
					tldriver.set(new RemoteWebDriver(new URL(prop.getProperty("huburl")), cap));
				} catch (MalformedURLException e) {
					
					e.printStackTrace();
				}
			}
	}
	
	/*
	 * Get driver using threadlocal
	 */
	public static synchronized WebDriver getDriver()
	{
		return tldriver.get();
	}

	
	/**
	 * this method is used the read properties file
	 * @return Properties prop object
	 */
	public Properties init_properties()
	{
		prop = new Properties();
		
		try {
			FileInputStream fi= new FileInputStream("./src/main/java/com/QA/Config/config.properties");
			prop.load(fi);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} 
		
		return prop;
		
		
	}
	
	public String getScreenshot()
	{
		File src = ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.FILE);
		String path = System.getProperty("user.dir") + "/screenshots/" + System.currentTimeMillis() + ".png";
		File destination = new File(path);
		try {
			FileUtils.copyFile(src, destination);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return path;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
