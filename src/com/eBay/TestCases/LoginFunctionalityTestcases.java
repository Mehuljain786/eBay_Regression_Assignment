package com.eBay.TestCases;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.eBay.ApplicationPages.HomePage;
import com.eBay.ApplicationPages.LoginPage;
import com.eBay.Supportlib.Database;
import com.eBay.appiumsetup.Setup;



public class LoginFunctionalityTestcases extends Setup{

	HomePage homePage = PageFactory.initElements(driver, HomePage.class);
	LoginPage loginpage = PageFactory.initElements(driver, LoginPage.class);
	
	
	@BeforeClass
	public void setexcel() throws Exception
	{
		String Path = System.getProperty("user.dir")+"//Datatable//Login.xls";
		Database.setExcelFile(Path,"LoginDetail");
	}
	
	@Test(priority=1)
	public void HomePageVerify() throws Exception
	{
		homePage.VerifyHomepage();
	}
	
	@Test(priority=2)
	public void appcompatactivityVerify() throws InterruptedException
	{
		homePage.androidgesturesonhome();
		homePage.performOrientation();
	}
	
	@Test(priority=3)
	public void Login() throws Exception
	{
		homePage.ClickonSingin();
		loginpage.VerifyLoginpage();
		loginpage.setUsername();
		loginpage.setPassword();
		loginpage.ClickonLogin();
		homePage.VerifyHomepage();
	}
	
}
