package com.eBay.appiumsetup;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class Setup {

	public static AndroidDriver<AndroidElement> driver;
	 
	@BeforeSuite
	
	public void setUp() throws MalformedURLException {
		
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("appium-version", "1.8.1");
		capabilities.setCapability("deviceName", AppiumConstants.devicename);
		capabilities.setCapability("platformVersion", AppiumConstants.platformversion);
		capabilities.setCapability("platformName", AppiumConstants.platformname);
		capabilities.setCapability("appPackage", AppiumConstants.packagename);
		capabilities.setCapability("noReset", "true");
		capabilities.setCapability("appActivity", AppiumConstants.activityname);
		driver = new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);	
	}
	

	@AfterSuite
	public void tearDown() {
		driver.quit();
	}

}