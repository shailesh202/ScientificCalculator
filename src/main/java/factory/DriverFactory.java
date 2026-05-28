package factory;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import utils.ConfigReader;

import java.time.Duration;

public class DriverFactory {
	
	private static ThreadLocal<WebDriver> driver =
            new ThreadLocal<>();

    public static void initDriver() {

        WebDriverManager.chromedriver().setup();

        driver.set(new ChromeDriver());

        getDriver().manage().window().maximize();

        /*
            Keep implicit wait low
         */
        getDriver().manage().timeouts()
                .implicitlyWait(
                        Duration.ofSeconds(2)
                );

        getDriver().get(
                ConfigReader.getProperty("url")
        );
    }

    public static WebDriver getDriver() {

        return driver.get();
    }

    public static void quitDriver() {

        if (getDriver() != null) {

            getDriver().quit();

            driver.remove();
        }
    }

}
