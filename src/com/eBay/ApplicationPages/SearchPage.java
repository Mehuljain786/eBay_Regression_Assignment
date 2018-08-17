package com.eBay.ApplicationPages;

import java.util.List;

import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.Reporter;
import org.testng.asserts.SoftAssert;

import com.eBay.Supportlib.Utility;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import junit.framework.Assert;

public class SearchPage {
	AndroidDriver driver;

	public SearchPage(AndroidDriver dri) {
		// TODO Auto-generated constructor stub
		this.driver = dri;
	}
	
	
	@FindBy(how = How.ID,using = "com.ebay.mobile:id/cell_collection_item")
	@CacheLookup
	List<AndroidElement> Searchitem;
	
	@FindBy(how = How.ID,using = "com.ebay.mobile:id/button_filter")
	@CacheLookup
	AndroidElement Searchpagefilter;
	
	
	public void VerifySerachPage()
	{
		System.out.println("Welcome to Search page in Ebay app");
		Utility.Explicitwait(driver, 20, Searchpagefilter);
		Assert.assertTrue(Searchpagefilter.isDisplayed());
	}
	
	public void SearchitemVerify()
	{
		Utility.Explicitwait(driver, 50, Searchitem.get(0));
		SoftAssert softA = new SoftAssert();
		if(Searchitem.size()>0)
		{
			softA.assertTrue(Searchitem.get(0).isDisplayed(), "Yes,Product is Available in Ebay");
		}
		else
		{
			System.out.println("No iteam found in search");
			Reporter.log("No iteam found in search");
		}
		softA.assertAll();
	}

	public void clickonproduct()
	{
		Utility.Explicitwait(driver, 50, Searchitem.get(0));
		System.out.println("Current screen orientation Is : " + driver.getOrientation());
		if("LANDSCAPE".equalsIgnoreCase(driver.getOrientation().toString()))
				{
				driver.rotate(org.openqa.selenium.ScreenOrientation.PORTRAIT);
				}
		Searchitem.get(0).click();
	}
	
}
