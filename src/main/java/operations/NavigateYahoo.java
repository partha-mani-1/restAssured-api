package operations;

import org.openqa.selenium.WebDriver;
import pages.YahooPages;

import java.util.ArrayList;
import java.util.List;

public class NavigateYahoo {
    public static String WEB_PAGE = "https://uk.yahoo.com/";
    private YahooPages yahooPages = new YahooPages();
    private String EMAIL = "FirstTestLogin_12";
    private String PASSWORD = "TestAbc_12!";
    private int EARNINGS = 1;
    private int STOCKS = 2;
    private int IPO = 3;
    private int ECONOMIC_EVENTS = 3;


    public void logonSuccessfully() {
        WebDriver chrome = BrowserLaunch.getDriver();
        chrome.get(WEB_PAGE);
        BrowserLaunch.waitForWebItemToLoad(chrome, yahooPages.cookieAcceptAll());
        yahooPages.cookieAcceptAll().click();
        BrowserLaunch.waitForWebItemToLoad(chrome, yahooPages.clickSignIn());
        yahooPages.clickSignIn().click();
        yahooPages.loginEmail().sendKeys(EMAIL);
        yahooPages.nextButton().click();
        BrowserLaunch.waitForWebElementToLoad(chrome, "//input[@id='login-passwd']");
        yahooPages.password().sendKeys(PASSWORD);
        yahooPages.nextButton().click();

    }

    public void navigateToCalendar() {
        WebDriver chrome = BrowserLaunch.getDriver();
        yahooPages.financeTab().click();
        BrowserLaunch.waitForWebItemToLoad(chrome, yahooPages.marketDataTab());
        yahooPages.marketDataTab().click();
        yahooPages.calendar().click();
        BrowserLaunch.waitForWebElementToLoad(chrome, "//span[text()='Events calendar for:']");
    }


    public List<String> getData() {
        List<String> data = new ArrayList<>();
        data.add(getEarnings());
        data.add(getStock());
        data.add(getIPO());
        data.add(getEconomics());
        return data;
    }

    public String getEarnings() {
        String earnings = yahooPages.getEarnings(EARNINGS).getText();
        return earnings;
    }

    public String getStock() {
        String stock = yahooPages.getEarnings(STOCKS).getText();
        return stock;
    }

    public String getIPO() {
        String ipo = yahooPages.getEarnings(IPO).getText();
        return ipo;
    }

    public String getEconomics() {
        String economics = yahooPages.getEarnings(ECONOMIC_EVENTS).getText();
        return economics;
    }
}
