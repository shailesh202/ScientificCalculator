package factory;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import utils.ConfigReader;

import java.time.Duration;

public class DriverFactory {
	
    private static ThreadLocal<WebDriver> driver =
            new ThreadLocal<>();

    public static void initDriver() {

        String browser =
                ConfigReader.getProperty("browser");

        if (browser.equalsIgnoreCase("chrome")) {

            WebDriverManager.chromedriver().setup();

            ChromeOptions options =
                    new ChromeOptions();

            options.addArguments("--start-maximized");

            driver.set(new ChromeDriver(options));
        }

        getDriver().manage().timeouts()
                .implicitlyWait(
                        Duration.ofSeconds(
                                Integer.parseInt(
                                        ConfigReader.getProperty(
                                                "implicitWait"
                                        )
                                )
                        )
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
