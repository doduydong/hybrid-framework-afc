package reportsConfig;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import commons.BaseTest;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ExtentListener implements ITestListener {

    @Override
    public void onTestStart(ITestResult result) {
        String testName = result.getMethod().getMethodName();

        ExtentTest test = ExtentManager.getInstance().createTest(testName, result.getMethod().getDescription());

        ExtentTestManager.setTest(test);
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        ExtentTestManager.getTest().pass("TEST PASSED");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        // ExtentTestManager.getTest().fail(result.getThrowable());

        WebDriver driver = getDriver(result);
        if (driver != null) {
            String base64 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BASE64);
            // ExtentTestManager.getTest().addScreenCaptureFromBase64String(base64, "Failure Screenshot");
            ExtentTestManager.getTest().fail(result.getThrowable(), MediaEntityBuilder.createScreenCaptureFromBase64String(base64, "Failure Screenshot").build());
        } else {
            ExtentTestManager.getTest().fail(result.getThrowable());
        }
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        ExtentTestManager.getTest().skip(result.getThrowable());
    }

    @Override
    public void onFinish(ITestContext context) {
        ExtentManager.getInstance().flush();
    }

    private WebDriver getDriver(ITestResult result) {
        try {
            return ((BaseTest) result.getInstance()).getDriver();
        } catch (Exception e) {
            return null;
        }
    }
}
