package com.eBay.ApplicationPages;



import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;
import com.eBay.Supportlib.Database;
import com.eBay.Supportlib.Utility;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.AndroidKeyCode;
import junit.framework.Assert;

public class HomePage {
	AndroidDriver driver;

	public HomePage(AndroidDriver dri) {
		// TODO Auto-generated constructor stub
		this.driver = dri;
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(how = How.ID,using = "com.ebay.mobile:id/home")
	@CacheLookup
	AndroidElement hamburgermenu;
	
	@FindBy(how = How.XPATH,using = "//*[contains(text(),'Home')]")
	@CacheLookup
	AndroidElement Home;
	
	@FindBy(how = How.ID,using = "com.ebay.mobile:id/search_box")
	@CacheLookup
	AndroidElement Searchbox;
	
	@FindBy(how = How.ID,using = "com.ebay.mobile:id/home")
	@CacheLookup
	AndroidElement Signinlogo;
	
	
	@FindBy(how = How.ID,using = "com.ebay.mobile:id/logo")
	@CacheLookup
	AndroidElement Ebaylogo;
	
	@FindBy(how = How.CLASS_NAME,using = "android.widget.EditText")
	@CacheLookup
	AndroidElement searchtext;
	
	
	public void VerifyHomepage()
	{
		System.out.println("Welcome to Ebay app");
		Utility.Explicitwait(driver, 20, hamburgermenu);
		Assert.assertTrue(hamburgermenu.isDisplayed());
		hamburgermenu.click();
		Home.click();
		Utility.Explicitwait(driver, 20, Searchbox);
		Assert.assertTrue(Searchbox.isDisplayed());
		Assert.assertTrue(Ebaylogo.isDisplayed());
		System.out.println("Successfully Verified Home page of Ebay");
		Reporter.log("Successfully Verified Home page of Ebay");
	}
	
	public void ClickonSingin()
	{
		Assert.assertTrue(hamburgermenu.isDisplayed());
		hamburgermenu.click();
		Assert.assertTrue(Signinlogo.isDisplayed());
		Signinlogo.click();
		System.out.println("Successfully Clicked on Singin button of Ebay");
		Reporter.log("Successfully Clicked on Signin button of Ebay");
	}
	
	public void Searchproduct() throws Exception
	{
		String Searchcontent = Database.getCellData(1,2);
		searchtext.sendKeys(Searchcontent);
		driver.pressKeyCode(AndroidKeyCode.ENTER);
		Thread.sleep(5000);
	}
	
	public void androidgesturesonhome()
	{
		Utility.Scroll(driver);
	}
	
	
	public void performOrientation() throws InterruptedException 
	{
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
