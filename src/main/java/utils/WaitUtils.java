package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import baseFactory.DriverFactory;

import java.time.Duration;

public class WaitUtils {
	
	private WaitUtils() {
    }

    private static final int WAIT_TIME = 20;

    //    Wait for element visibility
    public static WebElement waitForVisibility(By locator) {

        WebDriverWait wait = new WebDriverWait(DriverFactory.getDriver(),Duration.ofSeconds(WAIT_TIME));

        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
    
    public static WebElement waitForClickable( By locator) {

        WebDriverWait wait = new WebDriverWait( DriverFactory.getDriver(), Duration.ofSeconds(WAIT_TIME));

        return wait.until( ExpectedConditions.elementToBeClickable(locator));
    }
    
    public static boolean waitForText(By locator,String expectedText) {

        WebDriverWait wait = new WebDriverWait(DriverFactory.getDriver(),Duration.ofSeconds(WAIT_TIME));

        return wait.until(ExpectedConditions.textToBePresentInElementLocated(locator,expectedText));
    }

    public static void hardWait(int seconds) {

        try {

            Thread.sleep(seconds * 1000L);

        } catch (InterruptedException e) {

            Thread.currentThread().interrupt();
        }
    }

}
