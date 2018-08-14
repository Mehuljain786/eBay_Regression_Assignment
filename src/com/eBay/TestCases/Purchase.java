package com.eBay.TestCases;

import org.openqa.selenium.By;
import org.testng.Reporter;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.eBay.Supportlib.Database;
import com.eBay.Supportlib.Utility;
import com.eBay.appiumsetup.Setup;

import io.appium.java_client.android.AndroidKeyCode;
import junit.framework.Assert;

public class Purchase extends Setup{

	By searchbox = By.id("com.ebay.mobile:id/search_box");
	By searchtext =  By.className("android.widget.EditText");
	By Searchitem = By.id("com.ebay.mobile:id/cell_collection_item");
	By Buyitnow = By.id("com.ebay.mobile:id/button_bin");
	By Review = By.id("com.ebay.mobile:id/take_action");
	By changeisgood = By.xpath("//android.view.View[@content-desc ='Flipkart banner']");
	By Committobuy = By.id("com.ebay.mobile:id/take_action");
	By Paymentoption = By.id("com.ebay.mobile:id/button_payment_options");
	By Errooption= By.id("com.ebay.mobile:id/error_textview");
	
	@BeforeClass
	public void setexcel() throws Exception
	{
		String Path = System.getProperty("user.dir")+"//Datatable//Login.xls";
		Database.setExcelFile(Path,"LoginDetail");
	}
	
	
	@Test(priority=1)
	public void Purchaseproduct() throws Exception{
		SoftAssert softA = new SoftAssert();
		driver.findElement(searchbox).click();
		String Searchcontent = Database.getCellData(1,2);
		driver.findElement(searchtext).sendKeys(Searchcontent);
		driver.pressKeyCode(AndroidKeyCode.ENTER);
		Thread.sleep(5000);
		Utility.Explicitwait(driver, 50, Searchitem);
		if(driver.findElements(Searchitem).size()>0)
		{
			softA.assertTrue(driver.findElement(Searchitem).isDisplayed(), "User is on Product detail page page");
			driver.findElement(Searchitem).click();
			System.out.println("Current screen orientation Is : " + driver.getOrientation());
			if("LANDSCAPE".equalsIgnoreCase(driver.getOrientation().toString()))
					{
					driver.rotate(org.openqa.selenium.ScreenOrientation.PORTRAIT);
					}
			Utility.Explicitwait(driver, 100, Buyitnow);
			driver.findElement(Buyitnow).click();
			softA.assertTrue(driver.findElement(Review).isDisplayed(), "USer is on Enter quantity page");
			if("LANDSCAPE".equalsIgnoreCase(driver.getOrientation().toString()))
			{
			driver.rotate(org.openqa.selenium.ScreenOrientation.PORTRAIT);
			}
			Utility.Explicitwait(driver, 100, Review);
			driver.findElement(Review).click();
			if("LANDSCAPE".equalsIgnoreCase(driver.getOrientation().toString()))
			{
			driver.rotate(org.openqa.selenium.ScreenOrientation.PORTRAIT);
			}
			Utility.Explicitwait(driver, 100, changeisgood);
			if(driver.findElements(changeisgood).size()>0)
			softA.assertTrue(driver.findElement(changeisgood).isDisplayed(), "Puchase sucess or puchase on flipkart page is display");
			else if(driver.findElements(Committobuy).size()>0)
			{
				driver.findElement(Committobuy).click();
				Utility.Explicitwait(driver, 100, Paymentoption);
				driver.findElement(Paymentoption).click();
				String error= driver.findElement(Errooption).getText();
				System.out.println(error);
			}
			
		}
		else
		{
			System.out.println("No iteam found in search");
			Reporter.log("No iteam found in search");
		}
		softA.assertAll();
	}
}
