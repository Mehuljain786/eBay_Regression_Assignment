package com.eBay.Supportlib;



import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.eBay.appiumsetup.Setup;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;


public class Utility extends Setup{

	public static boolean  Explicitwait(AndroidDriver driver,int timeout,By element)
	{
		try{
            WebDriverWait wait = new WebDriverWait(driver, timeout);
            wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(element));
            return true;
        }catch(Exception e){
            return false;
        }
	}
	
	public static void userdefwait(AndroidDriver driver,By element) throws InterruptedException
	{
		for(int i=0;i<10;i++)
		{
			if(driver.findElements(element).size()>0)
			{
				Thread.sleep(5000);
				break;
			}
			else
			{
			Thread.sleep(5000);
			}
		}
	}
	
	public boolean testScroll(AndroidDriver driver, By element){ 
			int count=0;
			boolean elementFound = false;
			while((driver.findElements(element)).size()==0)
			{
				Dimension dimensions = driver.manage().window().getSize();
				Double screenHeightStart = dimensions.getHeight() * 0.5;
				int scrollStart = screenHeightStart.intValue();
				Double screenHeightEnd = dimensions.getHeight() * 0.2;
				int scrollEnd = screenHeightEnd.intValue();
				driver.swipe(0,scrollStart,0,scrollEnd,1000);
				count=count+1;
				System.out.println("number of product"+count);
			}
			if(driver.findElements(element).size()>0){
			  elementFound = true;
			}
			System.out.println("number of product"+count);
			return elementFound;
		}
	   
	public static void Scroll(AndroidDriver driver)
	{
		for(int i=0;i<5;i++)
		{
		Dimension dimensions = driver.manage().window().getSize();
		Double screenHeightStart = dimensions.getHeight() * 0.5;
		int scrollStart = screenHeightStart.intValue();
		Double screenHeightEnd = dimensions.getHeight() * 0.2;
		int scrollend = screenHeightEnd.intValue();
		TouchAction action = new TouchAction(driver);
		action.press(20, scrollStart).waitAction(10).moveTo(20, scrollend).release().perform();
		}
	}	
	
}
