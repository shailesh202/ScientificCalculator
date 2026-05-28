package testcases;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.CalculatorPage;

public class BoundaryValueTest extends BaseTest {
	
    CalculatorPage calculator;

    @BeforeMethod
    public void initPage() {
        calculator = new CalculatorPage();
    }

    @Test
    public void verifyLargeNumberCalculation() throws Exception {

        calculator.performCalculation(
                "999999999",
                "+",
                "999999999"
        );

        Assert.assertEquals(
                calculator.getDisplayedValue(),
                "1999999998"
        );
    }

    @Test
    public void verifyFloatingPointPrecision() throws Exception {

        calculator.performCalculation(
                "0.1",
                "+",
                "0.2"
        );

        double actual = Double.parseDouble(
                calculator.getDisplayedValue()
        );

        Assert.assertEquals(
                actual,
                0.3,
                0.0001
        );
    }
    
    @Test
    public void verifyConsecutiveDecimalPoints() {

        calculator.enterNumber("5");

        calculator.clickButton(".");

        calculator.clickButton(".");
        
        calculator.clickButton(".");
        
        calculator.clickButton(".");

        calculator.enterNumber("5");

        String result = calculator.getDisplayedValue();
        System.out.println("result :" + result);

        Assert.assertTrue(
                result.contains("..")
        );
    }

    @Test
    public void verifyRapidButtonClickingOnNumber() {

        for (int i = 0; i < 20; i++) {
            calculator.clickButton("1");
        }

        String result = calculator.getDisplayedValue();

        Assert.assertEquals(
                result.length(),
                20
        );
  
    }
    
    @Test
    public void verifyRapidButtonClickingOnNonNumber() {

        for (int i = 0; i < 20; i++) {
            calculator.clickButton("cos");
        }

        Assert.assertTrue(true, "ERROR");
  
    }
    
    @Test
    public void verifyRapidButtonClickingOnNoOperator() {

        for (int i = 0; i < 20; i++) {
            calculator.clickButton("+");
        }

        String result = calculator.getDisplayedValue();

        Assert.assertEquals(
                result.length(),
                20
        );
  
    }

}
