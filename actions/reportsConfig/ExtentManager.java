package reportsConfig;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import commons.GlobalConstants;

public class ExtentManager {
    private static ExtentReports extent;

    public static synchronized ExtentReports getInstance() {
        if (extent == null) {
            ExtentSparkReporter reporter = new ExtentSparkReporter(GlobalConstants.EXTENTREPORTS_OUTPUT + "extent.html");

            reporter.config().setReportName("Automation Test Report");
            reporter.config().setDocumentTitle("Test Results");
            reporter.config().setTheme(Theme.DARK);
            reporter.config().setEncoding("utf-8");
            reporter.config().setTimelineEnabled(true);

            extent = new ExtentReports();
            extent.attachReporter(reporter);

            extent.setSystemInfo("Project", "Magento");
            extent.setSystemInfo("Env", "QA");
            extent.setSystemInfo("OS", GlobalConstants.OS_NAME);
            extent.setSystemInfo("Java", GlobalConstants.JAVA_VERSION);
        }
        return extent;
    }
}
