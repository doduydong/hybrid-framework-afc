package reportsConfig;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import com.aventstack.extentreports.reporter.configuration.Theme;
import commons.GlobalConstants;

import java.util.HashMap;
import java.util.Map;

public class ExtentReportsManager {
    public static final ExtentReports extentReports = new ExtentReports();
    public static Map<Integer, ExtentTest> extentTestMap = new HashMap<Integer, ExtentTest>();
    public static ExtentReports extent = ExtentReportsManager.createExtentReports();

    public synchronized static ExtentReports createExtentReports() {
        ExtentSparkReporter reporter = new ExtentSparkReporter(GlobalConstants.EXTENTREPORTS_OUTPUT + "extentReports.html");
        reporter.config().setReportName("Magento Store HTML Reports");
        reporter.config().setDocumentTitle("Magento Store HTML Reports");
        reporter.config().setTimelineEnabled(true);
        reporter.config().setEncoding("utf-8");
        reporter.config().setTheme(Theme.DARK);

        extentReports.attachReporter(reporter);
        extentReports.setSystemInfo("Company", "AFC");
        extentReports.setSystemInfo("Project", "Magento Store");
        extentReports.setSystemInfo("Team", "D-SDET");
        extentReports.setSystemInfo("JDK", GlobalConstants.JAVA_VERSION);
        extentReports.setSystemInfo("OS", GlobalConstants.OS_NAME);
        return extentReports;
    }


    public static synchronized ExtentTest getTest() {
        return extentTestMap.get((int) Thread.currentThread().getId());
    }

    public static synchronized ExtentTest startTest(String testName, String desc) {
        ExtentTest test = extent.createTest(testName, desc);
        extentTestMap.put((int) Thread.currentThread().getId(), test);
        return test;
    }
}
