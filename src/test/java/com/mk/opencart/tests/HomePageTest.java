package com.mk.opencart.tests;

import com.mk.opencart.base.BaseTest;
import com.mk.opencart.constants.AppConstants;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/*
* @Author - Marikannan Mariappan
* */
public class HomePageTest extends BaseTest {

   // Properties prop;    - no need to create object instance again, Hence it;s declared as 'protected' in parent class
    //PlaywrightFactory pf;

    @Test(priority = 1)
    public void homePageTitleTest()
    {
       String actualTitle = homePage.getHomePageTitle();
        Assert.assertEquals(actualTitle, AppConstants.HOME_PAGE_TITLE);
    }
     @Test(priority = 2)
    public void homePageURLTest()
    {

       String actualURL = homePage.getHomePageURL();
       Assert.assertEquals(actualURL,prop.getProperty("url"));
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

    @Test(dataProvider = "getProductData",priority = 3)
    public void SearchTest(String productName) {
       String actualHeaderTest = homePage.doSearch(productName);
       Assert.assertEquals(actualHeaderTest,"Search - "+productName);
    }


}
