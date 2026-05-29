package testcases;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pages.CalculatorPage;

public class BugScenarioTest extends BaseTest {
	
	CalculatorPage calculator;

    @BeforeMethod
    public void initPage() {
        calculator = new CalculatorPage();
    }

    @Test(groups = {"bug"}, description =  "verify Divide By Zero")
    public void verifyDivideByZero() throws Exception {

        calculator.performCalculation("10", "÷", "0");

        String result = calculator.getDisplayedValue();

        Assert.assertTrue(result.contains("Infinity")
                        || result.contains("Error") || result.contains("0")); // actual should be Infinity/undefined
    }

    @Test(groups = {"bug"}, description =  "Verify the calculation of two decimal numbers")
    public void verifyDigitThree() throws Exception {

    	calculator.enterNumber("3");

        Assert.assertEquals(calculator.getDisplayedValue(), "0"); // actual should be 3
    }
    
    @Test(groups = {"bug"}, description =  "Verify the division of two numbers")
    public void verifyDivision() throws Exception {

        calculator.performCalculation("18", "÷", "6");

        Assert.assertEquals(calculator.getDisplayedValue(), "0.3333333333333333" ); // actual should be 3
    }

    
    @Test(groups = {"bug"}, description =  "Verify the division of two numbers")
    public void verifyDivision1() throws Exception {

        calculator.performCalculation("8", "÷", "5");

        Assert.assertEquals(calculator.getDisplayedValue(), "0.625" ); // actual should be 1.6
    }
    
    @Test(groups = {"bug"}, description =  "Verify the Subtraction of two numbers")
    public void verifySubtraction() throws Exception {

        calculator.performCalculation("10", "−", "4");

        Assert.assertEquals(calculator.getDisplayedValue(), "0.4"); // actual should be 6 
    }
    
    @Test( groups = {"bug"},description = "Verify division precedence")
    public void verifyDivisionPrecedence() {

        calculator.enterExpression("10÷2+5");

        calculator.clickEquals();

        Assert.assertEquals(calculator.getDisplayedValue(), "5.2" ); //actual should be 10
    }
    
    @Test(groups = {"bug"}, description = "Verify bracket precedence")
    public void verifyBracketPrecedence() {

        calculator.enterExpression("(2+6)×4");

        calculator.clickEquals();

        Assert.assertEquals( calculator.getDisplayedValue(), "8" ); //actual should be 32
    }

    @Test( groups = {"bug"}, description = "Verify mixed BODMAS operations")
    public void verifyMixedOperations() {

        calculator.enterExpression("2+7×4−5");

        calculator.clickEquals();
        
        Assert.assertEquals( calculator.getDisplayedValue(), "2.1785714285714284" ); //Actual should be 25
    }
    
    @Test( groups = {"bug"}, description = "Verify bodmas operation")
    public void verifyPowerOperationPrecedence() {

        calculator.enterExpression("(5+2)×7");

        calculator.clickEquals();

        Assert.assertEquals(calculator.getDisplayedValue(), "7"); // Actual should be 49
    }
}
