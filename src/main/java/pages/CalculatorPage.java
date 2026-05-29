package pages;

import utils.WaitUtils;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import baseFactory.DriverFactory;

public class CalculatorPage {
	
	WebDriver driver = DriverFactory.getDriver();

    private By display = By.id("display");

    public void clickButton(String value) {

        By locator = By.xpath(
                "//button[contains(normalize-space(),'"
                        + value + "')]"
        );

        WaitUtils.waitForClickable(locator).click();
    }

    public void clickEquals() {

        clickButton("=");
    }

    public void clearCalculator() {

        clickButton("C");
    }

    public String getDisplayedValue() {

        By display = By.id("display");

        return WaitUtils
                .waitForVisibility(display).getAttribute("value");
    }

    public void enterNumber(String number) {

        for (char digit : number.toCharArray()) {

            clickButton(String.valueOf(digit));
        }
    }
    
    public void performCalculation(
            String num1,
            String operator,
            String num2) throws Exception {

        enterNumber(num1);
        Thread.sleep(1000);       
        clickButton(operator);
        Thread.sleep(1000); 
        enterNumber(num2);
        Thread.sleep(1000); 

       // clickEquals(); 
        clickButton("=");
        Thread.sleep(10000); 

        System.out.println("Result : " + getDisplayedValue());
    }

    public void performScientificOperation(
            String function,
            String value) {

        clickButton(function);

        enterNumber(value);

        clickEquals();
    }

    public void enterInvalidInput(String value) {

        JavascriptExecutor js =
                (JavascriptExecutor) driver;

        js.executeScript(
                "document.getElementById('display').value='" + value + "';"
        );
    }
    
    public void enterExpression(
            String expression) {

        for (char ch : expression.toCharArray()) {

            clickButton(String.valueOf(ch));
        }
    }


}
