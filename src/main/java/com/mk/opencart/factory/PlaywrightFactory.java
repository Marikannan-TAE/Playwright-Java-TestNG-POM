package com.mk.opencart.factory;

import com.microsoft.playwright.*;

public class PlaywrightFactory {

    Playwright playwright;
    Browser browser;
    BrowserContext browserContext;
    Page page;

    public Browser initBrowser(String browserName) {
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

    public Page loadPage(String url)
    {
        browserContext = browser.newContext();
        page = browserContext.newPage();
        page.navigate(url);
        return page;
    }


}
