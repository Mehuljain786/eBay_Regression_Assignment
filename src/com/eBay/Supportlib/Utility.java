package com.eBay.Supportlib;



import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.eBay.appiumsetup.Setup;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;


public class Utility extends Setup{

	public static boolean  Explicitwait(AndroidDriver driver,int timeout,AndroidElement element)
	{
		try{
            WebDriverWait wait = new WebDriverWait(driver, timeout);
            wait.until(ExpectedConditions.elementToBeClickable(element));
            return true;
        }catch(Exception e){
            return false;
        }
	}
	
	public static void userdefwait(AndroidElement element) throws InterruptedException
	{
		for(int i=0;i<10;i++)
		{
			if(element.isDisplayed())
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
	   
}
