package testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import factory.DriverFactory;
import utils.ConfigReader;


public class BaseTest {
	
    @BeforeMethod
    public void setup() {

        DriverFactory.initDriver();

        DriverFactory.getDriver().get(
                ConfigReader.getProperty("url"));
    }
    
    @AfterMethod
    public void tearDown() {

        DriverFactory.quitDriver();
    }

}
