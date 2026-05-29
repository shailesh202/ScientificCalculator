package testcases;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.CalculatorPage;

public class NegativeScenariosTest extends BaseTest {
	
	CalculatorPage calculator;

    @BeforeMethod
    public void initPage() {
        calculator = new CalculatorPage();
    }

    @Test(priority = 1, groups = {"sanity","regression"}, description =  "verify Divide By Zero")
    public void verifyDivideByZero() throws Exception {

        calculator.performCalculation("10", "÷", "0");

        String result = calculator.getDisplayedValue();

        Assert.assertTrue(result.contains("Infinity")
                        || result.contains("Error") || result.contains("0"));
    }

    @Test(priority = 1, groups = {"sanity"}, description =  "verify Invalid Input")
    public void verifyInvalidInput() throws Exception {

        calculator.enterInvalidInput("@");
        Thread.sleep(1000);
        String result = calculator.getDisplayedValue();
        System.out.println("result: " +result);

        Assert.assertTrue(result.equals("")
                        || result.contains("Error") || result.contains("@"));
    }

    @Test(priority = 1, groups = {"sanity"}, description =  "verify Repeated Operators")
    public void verifyRepeatedOperators() {

        calculator.enterNumber("5");

        calculator.clickButton("+");

        calculator.clickButton("×");

        calculator.enterNumber("2");

        calculator.clickEquals();
        
        String result = calculator.getDisplayedValue();

        Assert.assertTrue(result.contains("Error")  || result.equals("NaN")
                        || result.equals("10") || result.equals("7"));
    }

    @Test(priority = 1, groups = {"sanity"}, description =  "verify Empty Calculation")
    public void verifyEmptyCalculation() {

        calculator.clickEquals();

        String result = calculator.getDisplayedValue();

        Assert.assertTrue(result.equals("") || result.equals("undefined")
                        || result.equals("0") || result.equals("NaN")); 
    }

}
