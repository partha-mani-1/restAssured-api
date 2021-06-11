package operations;

import com.paulhammant.ngwebdriver.NgWebDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.safari.SafariDriver;

import static org.openqa.selenium.remote.BrowserType.*;

public class DriverGenerator {

    private DriverGenerator(){

    }

    private static NgWebDriver ngWebDriver;

    public static void setNgWebDriver(NgWebDriver ngWebDriver) {
        DriverGenerator.ngWebDriver = ngWebDriver;
    }

    public static NgWebDriver getNgWebDriver() {
        return ngWebDriver;
    }

    public static WebDriver newDriver(String driverType) {

        Object driver;
        switch (driverType) {
            case FIREFOX:
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                driver = new FirefoxDriver(firefoxOptions);
                break;
            case EDGE:
                EdgeOptions edgeOptions = new EdgeOptions();
                driver = new EdgeDriver(edgeOptions);
                break;
            case IEXPLORE:
                InternetExplorerOptions internetExplorerOptions = new InternetExplorerOptions();
                driver = new InternetExplorerDriver(internetExplorerOptions);
                break;
            case SAFARI:
                driver = new SafariDriver();
                break;
            default:
                ChromeOptions options = new ChromeOptions();
                driver = new ChromeDriver(options);
        }


        return (WebDriver) driver;
    }

}
