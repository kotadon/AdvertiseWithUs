package Pages;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

import com.aventstack.extentreports.*;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListener extends BaseTest implements ITestListener {

    private static ExtentReports extent = GenerateReport.getInstance();
    public static ThreadLocal<ExtentTest> test = new ThreadLocal<>();

    @Override
    public void onTestStart(ITestResult result) {
        ExtentTest extentTest = extent.createTest(result.getMethod().getMethodName(), result.getMethod().getDescription());
        extentTest.assignCategory("Morning daily Sanity");

        // Optional: log test data if using @DataProvider
        Object[] params = result.getParameters();
        if (params != null && params.length > 0) {
            extentTest.log(Status.INFO, "Test Data: " + Arrays.toString(params));
        }

        test.set(extentTest);
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        String testCaseName = getTestCaseName(result);
        System.out.println("✅ Test Passed: " + testCaseName);

        try {
            String screenshotPath = captureScreenshot(result.getMethod().getMethodName());
            test.get().pass("Test passed with screenshot",
                MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
        } catch (IOException e) {
            e.printStackTrace();
        }

        logExecutionMeta(result);
        writeResultToExcel(testCaseName, "Passed");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        String testCaseName = getTestCaseName(result);
        System.out.println("❌ Test Failed: " + testCaseName);

        try {
            String screenshotPath = captureScreenshot(result.getName());
            test.get().fail("Test failed: " + result.getThrowable().getMessage(),
                MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());

            test.get().log(Status.FAIL, "Exception: " + result.getThrowable());

            // Optional: Failure categorization
            String message = result.getThrowable().getMessage();
            if (message.contains("Timeout")) {
                test.get().log(Status.FAIL, "⏱️ Timeout detected");
            } else if (message.contains("NoSuchElement")) {
                test.get().log(Status.FAIL, "❌ Element not found on page");
            }

            logExecutionMeta(result);

        } catch (IOException e) {
            e.printStackTrace();
        }

        writeResultToExcel(testCaseName, "Failed");
        System.out.println("🔄 Reloading page due to test failure...");
        ReloadPage();
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        String testCaseName = getTestCaseName(result);
        System.out.println("⚠️ Test Skipped: " + testCaseName);
        test.get().skip("Test skipped");
        logExecutionMeta(result);
        writeResultToExcel(testCaseName, "Skipped");
    }

    private void logExecutionMeta(ITestResult result) {
        test.get().log(Status.INFO, "Execution Time: " + (result.getEndMillis() - result.getStartMillis()) + " ms");
        test.get().log(Status.INFO, "Browser: Chrome");
        String endTime = new SimpleDateFormat("HH:mm:ss").format(new Date(result.getEndMillis()));
        test.get().log(Status.INFO, "Finished At: " + endTime);
    }

    private String getTestCaseName(ITestResult result) {
        String description = result.getMethod().getDescription();
        return (description != null && !description.isEmpty()) ? description : result.getName();
    }

    @Override
    public void onFinish(ITestContext context) {
        extent.flush();
        String reportPath = GenerateReport.getReportPath();
        SendReport.sendEmailWithReport("deepak.kumar1@magicbricks.com", reportPath);

        String endTime = new SimpleDateFormat("HH:mm:ss").format(new Date());
        System.out.println("🕓 Test Suite Finished At: " + endTime);
        System.out.println("📊 Total Tests Run: " + context.getAllTestMethods().length);
        System.out.println("✅ Passed: " + context.getPassedTests().size());
        System.out.println("❌ Failed: " + context.getFailedTests().size());
        System.out.println("⚠️ Skipped: " + context.getSkippedTests().size());
    }
}
