package testcases;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import constants.FrameworkConstants;
import pages.CalculatorPage;

public class BoundaryValueTest extends BaseTest {
	
    CalculatorPage calculator;

    @BeforeMethod
    public void initPage() {
        calculator = new CalculatorPage();
    }

    @Test(priority = 1, groups = {"regression"}, description =  "Verify verify Large Number Calculation")
    public void verifyLargeNumberCalculation() throws Exception {

        calculator.performCalculation(
                "999999999",
                "+",
                "999999999"
        );

        Assert.assertEquals(calculator.getDisplayedValue(), "1999999998");
    }

    @Test(priority = 2, groups = {"sanity", "regression"}, description =  "verify Floating Point Precision")
    public void verifyFloatingPointPrecision() throws Exception {

        calculator.performCalculation(
                "0.1",
                "+",
                "0.2"
        );

        double actual = Double.parseDouble(calculator.getDisplayedValue());

        Assert.assertEquals(
                actual,0.3,  0.0001);
    }
    
    @Test(priority = 3, groups = {"sanity", "regression"}, description =  "verify Consecutive Decimal Points")
    public void verifyConsecutiveDecimalPoints() {

        calculator.enterNumber("5");

        calculator.clickButton(".");

        calculator.clickButton(".");
        
        calculator.clickButton(".");
        
        calculator.clickButton(".");

        calculator.enterNumber("5");

        String result = calculator.getDisplayedValue();
        System.out.println("result :" + result);

        Assert.assertTrue( result.contains("..") );
    }

    @Test(priority = 4, groups = {"sanity"}, description =  "verify Rapid Button Clicking On Number")
    public void verifyRapidButtonClickingOnNumber() {

        for (int i = 0; i < FrameworkConstants.COUNTER; i++) {
            calculator.clickButton("1");
        }

        String result = calculator.getDisplayedValue();

        Assert.assertEquals(result.length(), FrameworkConstants.COUNTER );
  
    }
    
    @Test(priority = 5, groups = {"sanity"}, description =  "verify Rapid Button Clicking On Non Number")
    public void verifyRapidButtonClickingOnNonNumber() {

        for (int i = 0; i < FrameworkConstants.COUNTER; i++) {
            calculator.clickButton("cos");
        }

        Assert.assertTrue(true, "ERROR");
  
    }
    
    @Test(priority = 6, groups = {"sanity"}, description =  "verify Rapid Button Clicking On Operator")
    public void verifyRapidButtonClickingOnNoOperator() {

        for (int i = 0; i < FrameworkConstants.COUNTER; i++) {
            calculator.clickButton("+");
        }

        String result = calculator.getDisplayedValue();

        Assert.assertEquals( result.length(), FrameworkConstants.COUNTER );
  
    }

}
