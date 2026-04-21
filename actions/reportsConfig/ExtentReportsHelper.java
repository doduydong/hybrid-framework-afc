package reportsConfig;

import com.aventstack.extentreports.Status;

public class ExtentReportsHelper {

    public static void step(String message) {
        ExtentTestManager.getTest().log(Status.INFO, message);
    }

    public static void pass(String message) {
        ExtentTestManager.getTest().pass(message);
    }

    public static void fail(String message) {
        ExtentTestManager.getTest().fail(message);
    }
}
