package com.eBay.TestCases;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.eBay.ApplicationPages.HomePage;
import com.eBay.ApplicationPages.PoductDetailpage;
import com.eBay.ApplicationPages.PurchaseSuccessPage;
import com.eBay.ApplicationPages.SearchPage;
import com.eBay.Supportlib.Database;
import com.eBay.appiumsetup.Setup;


public class PurchaseTestcases extends Setup{
	
	HomePage homePage = PageFactory.initElements(driver, HomePage.class);
	SearchPage searchpage = PageFactory.initElements(driver, SearchPage.class);
	PoductDetailpage proddetailpage = PageFactory.initElements(driver, PoductDetailpage.class);
	PurchaseSuccessPage purchasesucpage = PageFactory.initElements(driver, PurchaseSuccessPage.class);
	
	@BeforeClass
	public void setexcel() throws Exception
	{
		String Path = System.getProperty("user.dir")+"//Datatable//Login.xls";
		Database.setExcelFile(Path,"LoginDetail");
	}
	
	
	@Test(priority=1)
	public void Purchaseproduct() throws Exception
	{
		homePage.VerifyHomepage();
		homePage.Searchproduct();
		searchpage.VerifySerachPage();
		searchpage.SearchitemVerify();
		searchpage.clickonproduct();
		proddetailpage.VerifyProductDetailpage();
		proddetailpage.ProductSliderSwip();
		proddetailpage.ClickonBuyit();
		purchasesucpage.VerifySuccessPage();
	}
}
