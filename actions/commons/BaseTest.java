package commons;

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

    protected boolean verifyTrue(boolean condition) {
        boolean verify = true;
        try {
            Assert.assertTrue(condition);
        } catch (Throwable e) {
            verify = false;
            VerificationFailureStore.getFailures().addFailureForTest(Reporter.getCurrentTestResult(), e);
            Reporter.getCurrentTestResult().setThrowable(e);
        }
        return verify;
    }

    protected boolean verifyFalse(boolean condition) {
        boolean verify = true;
        try {
            Assert.assertFalse(condition);
        } catch (Throwable e) {
            verify = false;
            VerificationFailureStore.getFailures().addFailureForTest(Reporter.getCurrentTestResult(), e);
            Reporter.getCurrentTestResult().setThrowable(e);
        }
        return verify;
    }

    protected boolean verifyEqual(Object actual, Object expected) {
        boolean verify = true;
        try {
            Assert.assertEquals(actual, expected);
        } catch (Throwable e) {
            verify = false;
            VerificationFailureStore.getFailures().addFailureForTest(Reporter.getCurrentTestResult(), e);
            Reporter.getCurrentTestResult().setThrowable(e);
        }
        return verify;
    }
}
