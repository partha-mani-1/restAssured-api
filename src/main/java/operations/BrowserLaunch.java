package operations;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BrowserLaunch {

    private static WebDriver driver;
    private static final int WAIT_TIME_COUNTER_IN_SEC = 60;
    private static final String DOCUMENT_READY_STATE = "return document.readyState";


    public static WebDriver getDriver1() {
        if (driver == null) {
            String browserType = "chrome";
            driver = DriverGenerator.newDriver(browserType);
        }
        return driver;
    }

    public static WebDriver getDriver() {
        if (driver == null) {
            System.setProperty("webdriver.chrome.driver", "src\\main\\resources\\drivers\\chromedriver.exe");
            driver = new ChromeDriver();
            driver.manage().window().maximize();
        }
        return driver;
    }

    public static void waitForWebItemToLoad(WebDriver driver, WebElement name) {
        WebDriverWait wait = new WebDriverWait(driver, WAIT_TIME_COUNTER_IN_SEC);
        wait.until(d ->
                name.isDisplayed()
        );
    }

    public static void waitForWebElementToLoad(WebDriver driver, String name) {
        WebDriverWait wait = new WebDriverWait(driver, WAIT_TIME_COUNTER_IN_SEC);
        wait.until(d ->
                driver.findElement(By.xpath(name)).isDisplayed()
        );
    }

    public static void waitForPageLoad() {
        Wait<WebDriver> wait = new WebDriverWait(getDriver(), WAIT_TIME_COUNTER_IN_SEC);
        wait.until(d ->
                {
                    JavascriptExecutor executor = (JavascriptExecutor) d;
                    String docReadyResult = (String) executor.executeScript(DOCUMENT_READY_STATE);
                    return (docReadyResult.equals("complete") || docReadyResult.equals("loaded")
                            || !executor.executeScript("return document.mpPageReloaded").equals("notYet"));
                }
        );
    }
}
