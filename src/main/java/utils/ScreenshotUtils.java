package utils;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import baseFactory.DriverFactory;
import constants.FrameworkConstants;

import java.io.File;
import java.io.IOException;

public class ScreenshotUtils {
	
	public static String captureScreenshot(
            String testName) {
		
		  if (DriverFactory.getDriver() == null) {

		        System.out.println( "Driver is null. Screenshot skipped." );

		        return "";
		    }

        File src = ((TakesScreenshot)DriverFactory.getDriver()).getScreenshotAs( OutputType.FILE );


        String path =
                FrameworkConstants.SCREENSHOT_PATH
                + testName
                + ".png";
        
        File dest = new File(path);

        try {

            FileUtils.copyFile(src, dest);

        } catch (IOException e) {

            e.printStackTrace();
        }

        return path;
    }

}
