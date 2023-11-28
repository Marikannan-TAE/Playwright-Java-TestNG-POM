package com.mk.opencart.tests;

import com.mk.opencart.base.BaseTest;
import com.mk.opencart.constants.AppConstants;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginPageTest extends BaseTest {

    @Test(priority = 1)
    public void LoginPageNavigationTest()
    {
        loginPage = homePage.navigateToLoginpage();
        String actloginPageTitle = loginPage.getLoginpageTitile();
        System.out.println("The Actual Login page title is: "+actloginPageTitle);
        Assert.assertEquals(actloginPageTitle, AppConstants.LOGIN_PAGE_TITLE);
    }
    @Test(priority = 2)
    public void forgotPwdLinkExistTest()
    {
        Assert.assertTrue(loginPage.isForgotPwdLnkExist());

    }

    @Test(priority = 3)
    public void LoginTest()
    {
    Assert.assertTrue(loginPage.doLogin(prop.getProperty("username").trim(), prop.getProperty("password").trim()));
    }
}
