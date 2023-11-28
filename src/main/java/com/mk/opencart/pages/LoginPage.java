package com.mk.opencart.pages;

import com.microsoft.playwright.Page;

public class LoginPage {

    private Page page;

    //1. String locators - OR
    private String emailId ="#input-email";
    private String password ="#input-password";
    private String loginBtn = "input[type='submit']";
    private String forgotPwdLnk = "//div[@class='well']//a[text()='Forgotten Password']";
    private String logoutLink = "//a[@class='list-group-item'][normalize-space()='Logout']";

    // 2. page constructor
    public LoginPage(Page page) {
        this.page = page;
    }

    //3. Page actions/methods

    public String getLoginpageTitile()
    {
        return page.title();
    }

    public boolean isForgotPwdLnkExist()
    {
        return page.isVisible(forgotPwdLnk);
    }

    public boolean doLogin(String appuserName, String appPassWord)
    {
        System.out.println("App credentials:" +appuserName +":" +appPassWord);
        page.fill(emailId,appuserName);
        page.fill(password,appPassWord);
        page.click(loginBtn);
        if(page.isVisible(logoutLink)){
            System.out.println("User successfully logged In....");
            return true;
        }
        return false;
    }
}
