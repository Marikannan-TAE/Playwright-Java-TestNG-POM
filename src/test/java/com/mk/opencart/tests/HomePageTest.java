package com.mk.opencart.tests;

import com.microsoft.playwright.Page;
import com.mk.opencart.factory.PlaywrightFactory;
import com.mk.opencart.pages.HomePage;
import org.testng.Assert;
import org.testng.AssertJUnit;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class HomePageTest {

    PlaywrightFactory pf;
    Page page;
    HomePage homePage;

    @BeforeTest
    public void setup()
    {
    pf = new PlaywrightFactory();
    pf.initBrowser("chromium");
    page = pf.loadPage("https://naveenautomationlabs.com/opencart/");
    homePage = new HomePage(page);
    }

    @Test
    public void homePageTitleTest()
    {
       String actualTitle = homePage.getHomePageTitle();
        Assert.assertEquals(actualTitle,"Your Store");
    }
     @Test
    public void homePageURLTest()
    {
       String actualURL = homePage.getHomePageURL();
       Assert.assertEquals(actualURL,"https://naveenautomationlabs.com/opencart/");
    }

    @DataProvider
    public Object[][] getProductData(){
        return new Object[][]{
                {"Macbook"},
                {"iMac"},
                {"Samsung"},
                {"OnePlus"}

        };
    }

    @Test(dataProvider = "getProductData",priority = 100)
    public void SearchTest(String productName) throws InterruptedException {
       String actualHeaderTest = homePage.doSearch(productName);
       Assert.assertEquals(actualHeaderTest,"Search - "+productName);
    }

    @AfterTest
    public void tearDown()
    {
        page.context().browser().close();
    }
}
