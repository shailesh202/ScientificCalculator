package testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import factory.DriverFactory;
import utils.ConfigReader;


public class BaseTest {
	
	@BeforeMethod(alwaysRun = true)
    public void setup() {

        DriverFactory.initDriver();

        DriverFactory.getDriver().get(
                ConfigReader.getProperty("applicationUrl"));
    }
    
    @AfterMethod(alwaysRun = true)
    public void tearDown() {

        if (DriverFactory.getDriver() != null) {

            DriverFactory.quitDriver();
        }
    }

}
