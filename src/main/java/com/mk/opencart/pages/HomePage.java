package com.mk.opencart.pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class HomePage {

    private final Page page;

    //1. String locators - OR
    private String search = "input[name='search']";
    private String searchIcon = "div#search button";
    private String searchpageHeader="div#content h1";
    private String loginLink = "a:text('Login')";
    private String myAccountLink = "a[title='My Account']";


    // 2. page constructor
    public HomePage(Page page)
    {
        this.page = page;
    }


    //3. Page actions/methods

    public String getHomePageTitle()
    {

        String title = page.title();
        System.out.println("Title of the page is: "+title);
        return title;
    }

    public String getHomePageURL()
    {

     String url = page.url();
     System.out.println("Page URL is: "+url);
     return url;
    }
    public String doSearch(String productName)
    {
    page.fill(search,productName);
    page.click(searchIcon);
    String header = page.textContent(searchpageHeader);
        System.out.println("Search header is: "+header);
        return  header;
    }

    public LoginPage navigateToLoginpage()
    {
        page.click(myAccountLink);
        page.click(loginLink);
        return new LoginPage(page);
    }
}
