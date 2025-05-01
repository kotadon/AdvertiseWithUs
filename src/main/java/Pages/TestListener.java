package Pages;

import java.io.IOException;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListener extends BaseTest implements ITestListener {

	private static ExtentReports extent = GenerateReport.getInstance();
	public static ThreadLocal<ExtentTest> test = new ThreadLocal<>();

	@Override
	public void onTestStart(ITestResult result) {
		ExtentTest extentTest = extent.createTest(result.getMethod().getMethodName());
		test.set(extentTest);
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		String testCaseName = getTestCaseName(result);
		System.out.println("✅ Test Passed: " + testCaseName);
		test.get().pass("Test passed");
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
			test.get().addScreenCaptureFromPath(screenshotPath);
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
		writeResultToExcel(testCaseName, "Skipped");
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
	}
}
