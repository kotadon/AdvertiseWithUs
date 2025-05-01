package Pages;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class GenerateReport {

    private static ExtentReports extent;
    private static String reportPath;

    public static ExtentReports getInstance() {
        if (extent == null) {
            createInstance();
        }
        return extent;
    }

    public static void createInstance() {
        String timestamp = new java.text.SimpleDateFormat("yyyyMMdd_HHmmss").format(new java.util.Date());
        reportPath = System.getProperty("user.dir") + "\\Report\\test-output\\B2C_Bricks_Report_" + timestamp + ".html";
        createInstance(reportPath);
    }

    public static ExtentReports createInstance(String fileName) {
    	reportPath = fileName;
        ExtentSparkReporter sparkReporter = new ExtentSparkReporter(fileName);
        sparkReporter.config().setReportName("B2C Bricks Sanity Test Report");
        sparkReporter.config().setDocumentTitle("AdvertiseWithUs B2C Automation");
        sparkReporter.config().setEncoding("utf-8");
        sparkReporter.config().setTheme(Theme.DARK);

        extent = new ExtentReports();
        extent.attachReporter(sparkReporter);
        extent.setSystemInfo("QA Engineer", "Deepak Kumar");
        extent.setSystemInfo("QC Environment", "MB Production");

        return extent;
    }

    public static String getReportPath() {
        return reportPath;
    }
}
