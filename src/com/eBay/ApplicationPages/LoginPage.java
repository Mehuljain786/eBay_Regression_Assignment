package com.eBay.ApplicationPages;

import java.util.List;

import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.eBay.Supportlib.Database;
import com.eBay.Supportlib.Utility;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.AndroidKeyCode;


public class LoginPage {
	AndroidDriver driver;

	public LoginPage(AndroidDriver dri) {
		// TODO Auto-generated constructor stub
		this.driver = dri;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(how = How.XPATH,using = "//*[@class='android.widget.EditText' and @index='1']")
	@CacheLookup
	AndroidElement Username;
	
	@FindBy(how = How.XPATH,using = "//*[@class='android.widget.EditText' and @index='0']")
	@CacheLookup
	AndroidElement Password;
	
	@FindBy(how = How.XPATH,using = "//*[@class='android.widget.Button' and @index='0']")
	@CacheLookup
	AndroidElement Login;
	
	@FindBy(how = How.ID,using = "com.ebay.mobile:id/button_google_deny")
	@CacheLookup
	List<AndroidElement> Nothanks;
	
	
	public void VerifyLoginpage()
	{
		Assert.assertTrue(Username.isDisplayed());
		System.out.println("Your on Login Page");
	}	
	
	public void setUsername() throws Exception
	{
		String Userid = Database.getCellData(1,0);
		System.out.println("Username= "+Userid);
		Username.sendKeys(Userid);
	}
	
	public void setPassword() throws Exception
	{
		String Pwd = Database.getCellData(1,1);
		System.out.println("Password= "+Pwd);
		Username.sendKeys(Pwd);
	}
	
	public void ClickonLogin() throws InterruptedException
	{
		driver.pressKeyCode(AndroidKeyCode.ENTER);
		Thread.sleep(5000);
		Utility.Explicitwait(driver, 20, Nothanks.get(0));
		if(Nothanks.size()>0)
		driver.pressKeyCode(AndroidKeyCode.BACK);
	}
	


}
