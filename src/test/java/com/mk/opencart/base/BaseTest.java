package com.mk.opencart.base;

import com.microsoft.playwright.Page;
import com.mk.opencart.factory.PlaywrightFactory;
import com.mk.opencart.pages.HomePage;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.util.Properties;

/*
* @Author - Marikannan Mariappan
* */
public class BaseTest {
    PlaywrightFactory pf;
    Page page;
    protected Properties prop;
    protected HomePage homePage;

    @BeforeTest
    public void setup()
    {
        pf = new PlaywrightFactory();
        prop = pf.init_prop();
        pf.initBrowser(prop);
        page = pf.loadPage(prop);
        homePage = new HomePage(page);
    }

    @AfterTest
    public void tearDown()
    {
        page.context().browser().close();
    }
}
