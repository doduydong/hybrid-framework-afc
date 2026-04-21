package reportsConfig;

import com.aventstack.extentreports.ExtentTest;

public class ExtentTestManager {
    private static ThreadLocal<ExtentTest> test = new ThreadLocal<>();

    public static synchronized ExtentTest getTest() {
        return test.get();
    }

    public static synchronized void setTest(ExtentTest extentTest) {
        test.set(extentTest);
    }

    public static synchronized void unload() {
        test.remove();
    }
}
