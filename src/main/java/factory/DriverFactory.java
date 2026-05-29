package factory;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import utils.ConfigReader;

import java.time.Duration;

public class DriverFactory {

	private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

	public static void initDriver() {

		WebDriverManager.chromedriver().setup();

		ChromeOptions options = new ChromeOptions();

		options.addArguments("--headless=new");

		options.addArguments("--disable-gpu");

		options.addArguments("--no-sandbox");

		options.addArguments("--disable-dev-shm-usage");

		options.addArguments("--window-size=1920,1080");

		driver.set(new ChromeDriver(options));

		getDriver().manage().window().maximize();

		getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(2));

		getDriver().get(ConfigReader.getProperty("applicationUrl"));
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
