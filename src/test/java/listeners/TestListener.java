package listeners;


import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import utils.ConfigReader;
import utils.ExtentManager;
import utils.ScreenshotUtils;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;


public class TestListener implements ITestListener {
	
	private static ExtentReports extent = ExtentManager.getInstance();

    private static ThreadLocal<ExtentTest> test = new ThreadLocal<>();

    @Override
    public void onStart(ITestContext context) {

        System.out.println(
                "Execution Started"
        );
    }

    @Override
    public void onTestStart(ITestResult result) {

        ExtentTest extentTest =
                extent.createTest(
                        result.getMethod()
                                .getMethodName()
                );

        /*
            Assign Groups
         */
        String[] groups =
                result.getMethod()
                        .getGroups();

        for (String group : groups) {

            extentTest.assignCategory(group);
        }

        test.set(extentTest);
    }

    @Override
    public void onTestSuccess(ITestResult result) {

        test.get().log(
                Status.PASS,
                "Test Passed"
        );
    }

    @Override
    public void onTestFailure(ITestResult result) {

        test.get().log(
                Status.FAIL,
                "Test Failed"
        );

        /*
            Log Exception
         */
        test.get().fail(
                result.getThrowable()
        );

        /*
            Capture Screenshot
         */
        String screenshotPath =
                ScreenshotUtils.captureScreenshot(
                        result.getMethod()
                                .getMethodName()
                );

        try {

            if (!screenshotPath.isEmpty()) {

                test.get()
                        .addScreenCaptureFromPath(
                                screenshotPath
                        );
            }

        } catch (Exception e) {

            e.printStackTrace();
        }
    }

    @Override
    public void onTestSkipped(ITestResult result) {

        test.get().log( Status.SKIP, "Test Skipped");
    }

    @Override
    public void onFinish(ITestContext context) {

        extent.flush();

        System.out.println(
                "Execution Completed");
    }

}
