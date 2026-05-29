package testcases;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.CalculatorPage;

public class ScientificOperationsTest extends BaseTest  {
	
	CalculatorPage calculator;

    @BeforeMethod
    public void initPage() {
        calculator = new CalculatorPage();
    }

    @Test(priority = 1, groups = {"sanity"}, description =  "verify Square Root Operation")
    public void verifySquareRootOperation() {

    	calculator.enterNumber("25");
    	
    	calculator.clickButton("√");

        calculator.clickEquals();

        Assert.assertEquals(calculator.getDisplayedValue(),"5");
    }

    @Test(priority = 2, groups = {"sanity"}, description =  "verify Percentage Operation")
    public void verifyPercentageOperation() {

        calculator.enterNumber("10");

        calculator.clickButton("÷");

        calculator.enterNumber("50");

        calculator.clickEquals();

        Assert.assertEquals(calculator.getDisplayedValue(),"5");
    }

    @Test(priority = 3, groups = {"sanity", "regression"}, description =  "verify log Operation")
    public void verifyPowerOperation() {

        calculator.enterNumber("100");
        
        calculator.clickButton("log");

        calculator.clickEquals();

        Assert.assertEquals(calculator.getDisplayedValue(), "2"); // not available in calculator
    }

    @Test(priority = 4, groups = {"sanity"}, description =  "verify Sin Operation")
    public void verifySinOperation() {

    	calculator.enterNumber("90");
    	
    	calculator.clickButton("sin");

        calculator.clickEquals();

        double actual = Double.parseDouble(
                calculator.getDisplayedValue()
        );
        String result = calculator.getDisplayedValue();
        System.out.print("Result :" + result);
        
        Assert.assertEquals(actual, 1.0, 0.01);
    }

    @Test(priority = 5, groups = {"sanity"}, description =  "verify Cos Operation")
    public void verifyCosOperation() {

        calculator.enterNumber("45");

        calculator.clickButton("cos");

        calculator.clickEquals();
        String result = calculator.getDisplayedValue();
        System.out.print("Result :" + result);
        
        Assert.assertTrue(result.contains("0.5253"));//0.5253219888177297
        Assert.assertEquals(result, "0.5253219888177297");
    }

    @Test(priority = 6, groups = {"sanity"}, description =  "verify tan Operation")
    public void verifyMemoryStoreAndRecallqq() {

        calculator.enterNumber("120");

        calculator.clickButton("tan");

        calculator.clickEquals();
        String result = calculator.getDisplayedValue();
        System.out.print("Result :" + result);
        
        Assert.assertTrue(result.contains("0.7131")); //0.7131230097859091
        Assert.assertEquals(result, "0.7131230097859091");
    }
}
