package com.mk.opencart.factory;

import com.microsoft.playwright.*;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PlaywrightFactory {

    Playwright playwright;
    Browser browser;
    BrowserContext browserContext;
    Page page;
    Properties prop;

    public Browser initBrowser(Properties prop) {
        String browserName = prop.getProperty("browser").trim();
        System.out.println("Browser name is: " + browserName);
        playwright = Playwright.create();

        switch (browserName.toLowerCase()) {
            case "chromium":
                browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
                break;

            case "firefox":
                browser = playwright.firefox().launch(new BrowserType.LaunchOptions().setHeadless(false));
                break;

            case "webkit":
                browser = playwright.webkit().launch(new BrowserType.LaunchOptions().setHeadless(false));
                break;

            case "chrome":
                browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setChannel("chrome").setHeadless(false));
                break;

            default:
                System.out.println("Please pass the valid browser name....");
                break;
        }
        return browser;
    }

    public Page loadPage(Properties prop)
    {
        String url = prop.getProperty("url").trim();
        browserContext = browser.newContext();
        page = browserContext.newPage();
        page.navigate(url);
        return page;
    }

    /*
    * This method is used to initialize the properties from config file
    * */
    public Properties init_prop()
    {
        try {
            FileInputStream fi = new FileInputStream("./src/test/resources/config/config.properties");
            prop = new Properties();
            prop.load(fi);
        } catch (FileNotFoundException e)
        {
            e.printStackTrace();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    return prop;
    }

}
