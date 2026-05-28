package utils;

import java.io.File;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import constants.FrameworkConstants;


public class ExtentManager {
	
	private static ExtentReports extent;

    public static ExtentReports getInstance() {

        if (extent == null) {

            File directory =
                    new File(
                            FrameworkConstants.REPORT_PATH
                    );

            if (!directory.exists()) {

                directory.mkdirs();
            }

            String reportFile =
                    FrameworkConstants.REPORT_PATH
                    + "ExtentReport_"
                    + System.currentTimeMillis()
                    + ".html";

            ExtentSparkReporter sparkReporter =
                    new ExtentSparkReporter(reportFile);

            sparkReporter.config().setReportName(
                    FrameworkConstants.REPORT_NAME
            );
            
            sparkReporter.config().setDocumentTitle(
                    FrameworkConstants.DOCUMENT_TITLE
            );

            extent = new ExtentReports();

            extent.attachReporter(sparkReporter);

            extent.setSystemInfo(
                    "Tester",
                    FrameworkConstants.TESTER
            );

            extent.setSystemInfo(
                    "Environment",
                    FrameworkConstants.ENVIRONMENT
            );
        }

        return extent;
    }

}
