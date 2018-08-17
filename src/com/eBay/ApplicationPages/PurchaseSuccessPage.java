package com.eBay.ApplicationPages;

import java.util.List;

import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;

import com.eBay.Supportlib.Utility;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import junit.framework.Assert;

public class PurchaseSuccessPage {

	AndroidDriver driver;

	public PurchaseSuccessPage(AndroidDriver dri) {
		// TODO Auto-generated constructor stub
		this.driver = dri;
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(how = How.ID,using = "com.ebay.mobile:id/take_action")
	@CacheLookup
	List<AndroidElement> Review;
	
	@FindBy(how = How.XPATH,using = "//android.view.View[@content-desc ='Flipkart banner']")
	@CacheLookup
	List<AndroidElement> changeisgood;
	
	@FindBy(how = How.ID,using = "com.ebay.mobile:id/take_action")
	@CacheLookup
	List<AndroidElement> Committobuy;
	
	@FindBy(how = How.ID,using = "com.ebay.mobile:id/button_payment_options")
	@CacheLookup
	AndroidElement Paymentoption;
	
	@FindBy(how = How.ID,using = "com.ebay.mobile:id/error_textview")
	@CacheLookup
	AndroidElement Errooption;
	
	public void VerifySuccessPage()
	{
		SoftAssert softA = new SoftAssert();
		Utility.Explicitwait(driver, 100, Review.get(0));
		if(Review.size()>0)
		{
		if("LANDSCAPE".equalsIgnoreCase(driver.getOrientation().toString()))
		{
		driver.rotate(org.openqa.selenium.ScreenOrientation.PORTRAIT);
		}
		Review.get(0).click();
		}
		Utility.Explicitwait(driver, 100, changeisgood.get(0));
		if(changeisgood.size()>0)
		softA.assertTrue(changeisgood.get(0).isDisplayed(), "Puchase sucess or puchase on flipkart page is display");
		else if(Committobuy.size()>0)
		{
			Committobuy.get(0).click();
			Utility.Explicitwait(driver, 100, Paymentoption);
			Paymentoption.click();
			String error= Errooption.getText();
			System.out.println(error);
		}
	}
	
}
