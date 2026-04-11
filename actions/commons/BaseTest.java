package commons;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.Reporter;

import java.time.Duration;
import java.util.Random;

public class BaseTest {
    private WebDriver driver;
    protected final Logger log;

    public BaseTest() {
        log = LogManager.getLogger(getClass());
    }

    public WebDriver getDriver() {
        return driver;
    }

    protected WebDriver createWebDriver(String browserName, String url) {
        BrowserList browser = BrowserList.valueOf(browserName.toUpperCase());
        switch (browser) {
            case FIREFOX:
                driver = new FirefoxDriver();
                break;
            case CHROME:
                driver = new ChromeDriver();
                break;
            case EDGE:
                driver = new EdgeDriver();
                break;
            default:
                throw new RuntimeException("'" + browserName + "' is not valid!");
        }
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(GlobalConstants.LONG_TIMEOUT));
        driver.manage().window().maximize();
        driver.get(url);
        return driver;
    }

    protected int getRandomNumber() {
        return new Random().nextInt(10000);
    }

    protected void verifyTrue(boolean condition) {
        boolean verify = true;
        try {
            Assert.assertTrue(condition);
            log.info("---------------------- PASSED ----------------------");
        } catch (Throwable e) {
            verify = false;
            log.info("---------------------- FAILED ----------------------");
            VerificationFailureStore.getFailures().addFailureForTest(Reporter.getCurrentTestResult(), e);
            Reporter.getCurrentTestResult().setThrowable(e);
        }
    }

    protected void verifyFalse(boolean condition) {
        boolean verify = true;
        try {
            Assert.assertFalse(condition);
            log.info("---------------------- PASSED ----------------------");
        } catch (Throwable e) {
            verify = false;
            log.info("---------------------- FAILED ----------------------");
            VerificationFailureStore.getFailures().addFailureForTest(Reporter.getCurrentTestResult(), e);
            Reporter.getCurrentTestResult().setThrowable(e);
        }
    }

    protected void verifyEqual(Object actual, Object expected) {
        boolean verify = true;
        try {
            Assert.assertEquals(actual, expected);
            log.info("---------------------- PASSED ----------------------");
        } catch (Throwable e) {
            verify = false;
            log.info("---------------------- FAILED ----------------------");
            VerificationFailureStore.getFailures().addFailureForTest(Reporter.getCurrentTestResult(), e);
            Reporter.getCurrentTestResult().setThrowable(e);
        }
    }
}
