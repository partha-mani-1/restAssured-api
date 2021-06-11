package pages;

import operations.BrowserLaunch;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class YahooPages {

    public WebElement findElement(By by) {
        return BrowserLaunch.getDriver().findElement(by);
    }

    public WebElement cookieAcceptAll() {
        return findElement(By.xpath("//button[contains(text(),'Accept all')]"));
    }

    public WebElement clickSignIn() {
        return findElement(By.xpath("//a[text()='Sign in'][@class='_yb_mgks1']"));
    }

    public WebElement loginEmail() {
        return findElement(By.xpath("//div/input[@class='phone-no '][@id='login-username']"));
    }

    public WebElement nextButton() {
        return findElement(By.id("login-signin"));
    }

    public WebElement password() {
        return findElement(By.xpath("//input[@id='login-passwd']"));
    }

    public WebElement financeTab() {
        return findElement(By.xpath("//li/a[@href='https://uk.finance.yahoo.com/']"));
    }

    public WebElement marketDataTab() {
        return findElement(By.xpath("//div[@title='Market Data']"));
    }

    public WebElement calendar() {
        return findElement(By.xpath("//a[@title='Calendar']"));
    }

    public WebElement eventsDisplay() {
        return findElement(By.xpath("//span[text()='Events calendar for:']"));
    }

    public WebElement getEarnings(int a) {
        return findElement(By.xpath(String.format("//div/span[text()=\"11\"]/../span/span[text()=\"Jun\"]/../../../a[%s]", a)));
    }
}
