package com.eBay.TestCases;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.eBay.Supportlib.Database;
import com.eBay.Supportlib.Utility;
import com.eBay.appiumsetup.Setup;

import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidKeyCode;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import junit.framework.Assert;


public class LoginFunctionality extends Setup{

	By hamburgermenu = By.id("com.ebay.mobile:id/home"); 
	By Signinlogo = By.id("com.ebay.mobile:id/home");
	By Username = By.xpath("//*[@class='android.widget.EditText' and @index='1']");
	By Password = By.xpath("//*[@class='android.widget.EditText' and @index='0']");
	By Login = By.xpath("//*[@class='android.widget.Button' and @index='0']");
	By Nothanks = MobileBy.id("com.ebay.mobile:id/button_google_deny");
	
	@BeforeClass
	public void setexcel() throws Exception
	{
		String Path = System.getProperty("user.dir")+"//Datatable//Login.xls";
		Database.setExcelFile(Path,"LoginDetail");
	}
	
	@Test(priority=1)
	public void Loginapp() throws Exception
	{
		driver.findElement(hamburgermenu).click();
		driver.findElement(Signinlogo).click();
		int size = driver.findElements(Login).size();
		System.out.println("Username element"+size);
		driver.findElement(Username).sendKeys(Database.getCellData(1,0));
		driver.findElement(Password).sendKeys(Database.getCellData(1,1));
		driver.pressKeyCode(AndroidKeyCode.ENTER);
		Thread.sleep(5000);
		Utility.Explicitwait(driver, 20, Nothanks);
		//Utility.userdefwait(driver,Nothanks);
		if(driver.findElements(Nothanks).size()>0)
		driver.pressKeyCode(AndroidKeyCode.BACK);
		Assert.assertTrue(driver.findElement(hamburgermenu).isDisplayed());	
	}
	
	@Test(priority=2)
	public void androidgestures()
	{
		Utility.Scroll(driver);
	}
	
	@Test(priority=3)
	 public void performOrientation() throws InterruptedException {
	  //Get and print current screen orientation.
	  System.out.println("Current screen orientation Is : " + driver.getOrientation());
	  System.out.println("Changing screen Orientation to LANDSCAPE.");
	  //Changing screen Orientation to LANDSCAPE.
	  driver.rotate(org.openqa.selenium.ScreenOrientation.LANDSCAPE);
	  //Get and print screen orientation after changing It.
	  System.out.println("Now screen orientation Is : "+ driver.getOrientation());
	  Thread.sleep(5000);
	  System.out.println("Changing screen Orientation to PORTRAIT.");
	  //Changing screen Orientation to PORTRAIT.
	  driver.rotate(org.openqa.selenium.ScreenOrientation.PORTRAIT);
	  //Get and print screen orientation after changing It.
	  System.out.println("Now screen orientation Is : "+ driver.getOrientation());
	  Thread.sleep(5000);
	 }


}
