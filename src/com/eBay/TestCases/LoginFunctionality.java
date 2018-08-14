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
	
	@Test
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
		element = driver.findElement(Nothanks);
		Utility.Explicitwait(driver, 420, element);
		Utility.userdefwait(element);
		driver.pressKeyCode(AndroidKeyCode.BACK);
		Assert.assertTrue(driver.findElement(hamburgermenu).isDisplayed());	
	}
	

}
