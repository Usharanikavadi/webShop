package commonLib;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentListener implements ITestListener {

	ExtentSparkReporter repoter;
	ExtentReports report;
	private static ThreadLocal<ExtentTest> eTest = new ThreadLocal<ExtentTest>();
	String rootDir = System.getProperty("user.dir");
 
	@Override
	public void onStart(ITestContext context) {
		String extent_file_name = "selenium_test_reports/extent_test_report_"
				+ new SimpleDateFormat("yyyy-MM-dd-hh-mm-ss-SS").format(new Date()) + ".html";
		// @ start repoter
		repoter = new ExtentSparkReporter(extent_file_name);
		// @ repoter config
		repoter.config().setReportName("Selenium Test report");
		repoter.config().setDocumentTitle("Automation report");
		repoter.config().setTheme(Theme.DARK);
 
		report = new ExtentReports();
		report.attachReporter(repoter);
 
		// @ system details
		report.setSystemInfo("User", System.getProperty("os.user"));
		report.setSystemInfo("OS Name", System.getProperty("os.name"));
		report.setSystemInfo("Java version", System.getProperty("java.version"));
	}
 
	@Override
	public void onFinish(ITestContext context) {
		report.flush();
	}
 
	@Override
	public void onTestStart(ITestResult result) {
		String testName = (result.getParameters().length > 0 ? " - " + Arrays.toString(result.getParameters()) : result.getName());
		String BrowserName = Utilities.get_browserDetails().get("browserName");

		ExtentTest extentTest = report.createTest(BrowserName+"-> "+testName);
		eTest.set(extentTest);
		
	}
 
	@Override
	public void onTestSuccess(ITestResult result) {
		try {
			String ss_path = Utilities.take_screenshot(rootDir+"screenshots/ss_" + result.getName() + "_"
					+ new SimpleDateFormat("yyyy-MM-dd-hh-mm-ss-SS").format(new Date()) + ".png");
			eTest.get().pass(result.getName() + " --> PASSED").addScreenCaptureFromPath(ss_path);
 
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
 
	@Override
	public void onTestFailure(ITestResult result) {
		try {
			String ss_path = Utilities.take_screenshot(rootDir+"screenshots/ss_" + result.getName() + "_"
					+ new SimpleDateFormat("yyyy-MM-dd-hh-mm-ss-SS").format(new Date()) + ".png");
			eTest.get().fail(result.getName() + " --> FAILED").info(result.getThrowable());
 
			eTest.get().log(Status.FAIL, result.getThrowable()).addScreenCaptureFromPath(ss_path);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
 
	@Override
	public void onTestSkipped(ITestResult result) {
		try {
			String ss_path = Utilities.take_screenshot(rootDir+"screenshots/ss_" + result.getName() + "_"
					+ new SimpleDateFormat("yyyy-MM-dd-hh-mm-ss-SS").format(new Date()) + ".png");
			eTest.get().skip(result.getName() + " --> SKIPPED").addScreenCaptureFromPath(ss_path);
			eTest.get().info(result.getThrowable());
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static ExtentTest eTest() {
		return eTest.get();
	}
}
