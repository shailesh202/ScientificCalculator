package listeners;


import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import utils.ExtentManager;
import utils.ScreenshotUtils;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;


public class TestListener implements ITestListener {
	
	  ExtentReports extent =
	            ExtentManager.getInstance();

	    ThreadLocal<ExtentTest> test =
	            new ThreadLocal<>();

	    @Override
	    public void onTestStart(ITestResult result) {

	        ExtentTest extentTest =
	                extent.createTest(
	                        result.getMethod()
	                                .getMethodName()
	                );

	        test.set(extentTest);
	    }

	    @Override
	    public void onTestSuccess(ITestResult result) {

	        test.get().pass(
	                "Test Passed"
	        );
	    }
	    
	    @Override
	    public void onTestFailure(ITestResult result) {

	        String screenshotPath =
	                ScreenshotUtils.captureScreenshot(
	                        result.getMethod()
	                                .getMethodName()
	                );

	        test.get().fail(
	                result.getThrowable()
	        );

	        try {

	            test.get().addScreenCaptureFromPath(
	                    screenshotPath
	            );

	        } catch (Exception e) {

	            e.printStackTrace();
	        }
	    }

	    @Override
	    public void onTestSkipped(ITestResult result) {

	        test.get().skip(
	                "Test Skipped"
	        );
	    }
	    
	    @Override
	    public void onFinish(ITestContext context) {

	        extent.flush();
	    }

}
