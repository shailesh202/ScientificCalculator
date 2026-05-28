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

    @Test
    public void verifySquareRootOperation() {

    	calculator.enterNumber("25");
    	
    	calculator.clickButton("√");

        calculator.clickEquals();

        Assert.assertEquals(
                calculator.getDisplayedValue(),
                "5"
        );
    }

    @Test
    public void verifyPercentageOperation() {

        calculator.enterNumber("10");

        calculator.clickButton("÷");

        calculator.enterNumber("50");

        calculator.clickEquals();

        Assert.assertEquals(
                calculator.getDisplayedValue(),
                "5"
        );
    }

//    @Test
//    public void verifyPowerOperation() {
//
//        calculator.enterNumber("2");
//        
//        calculator.clickButton("^");
//
//        calculator.enterNumber("3");
//
//        calculator.clickEquals();
//
//        Assert.assertEquals(
//                calculator.getDisplayedValue(),     // not available in calculator
//                "8"
//        );
//    }

    @Test
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

    @Test
    public void verifyCosOperation() {

        calculator.enterNumber("45");

        calculator.clickButton("cos");

        calculator.clickEquals();
        String result = calculator.getDisplayedValue();
        System.out.print("Result :" + result);
        
        Assert.assertTrue(
                 result.contains("0.5253")
                    );//0.5253219888177297
        Assert.assertEquals(result, "0.5253219888177297");
    }

    @Test
    public void verifyMemoryStoreAndRecallqq() {

        calculator.enterNumber("120");

        calculator.clickButton("tan");

        calculator.clickEquals();
        String result = calculator.getDisplayedValue();
        System.out.print("Result :" + result);
        
        Assert.assertTrue(
        		result.contains("0.7131")
                   ); //0.7131230097859091
        Assert.assertEquals(result, "0.7131230097859091");
    }
}
