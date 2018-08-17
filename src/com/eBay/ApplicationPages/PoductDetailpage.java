package com.eBay.ApplicationPages;

import java.util.List;

import org.openqa.selenium.Point;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;
import org.testng.asserts.SoftAssert;

import com.eBay.Supportlib.Utility;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import junit.framework.Assert;

public class PoductDetailpage {
	AndroidDriver driver;

	public PoductDetailpage(AndroidDriver dri) {
		// TODO Auto-generated constructor stub
		this.driver = dri;
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(how = How.ID,using = "com.ebay.mobile:id/imageview_image")
	@CacheLookup
	AndroidElement Productimage;
	
	@FindBy(how = How.ID,using = "com.ebay.mobile:id/button_bin")
	@CacheLookup
	AndroidElement Buyitnow;
	
	
	public void VerifyProductDetailpage()
	{
		System.out.println("Welcome to Product detail page in Ebay app");
		Utility.Explicitwait(driver, 50, Productimage);
		Assert.assertTrue(Productimage.isDisplayed());
	}
	
	
	public void ProductSliderSwip()
	{
		Point sliderLocation = Productimage.getCenter();
		driver.swipe(sliderLocation.getX(), sliderLocation.getY(), sliderLocation.getX()-100, sliderLocation.getY(), 3000);
	}

	public void ClickonBuyit()
	{
		if("LANDSCAPE".equalsIgnoreCase(driver.getOrientation().toString()))
		{
		driver.rotate(org.openqa.selenium.ScreenOrientation.PORTRAIT);
		}
		Buyitnow.click();
	}
	
}
