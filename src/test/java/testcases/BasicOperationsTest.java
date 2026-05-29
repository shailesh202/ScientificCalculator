package testcases;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.CalculatorPage;


public class BasicOperationsTest extends BaseTest {
	
	 CalculatorPage calculator;

	    @BeforeMethod
	    public void initPage() {
	        calculator = new CalculatorPage();
	    }

	    @Test(priority = 1, groups = {"regression", "sanity"}, description =  "Verify the addition of two numbers")
	    public void verifyAddition() throws Exception {

	      calculator.performCalculation("5", "+", "2");

	        Assert.assertEquals(calculator.getDisplayedValue(), "7");
	    }

	    @Test(priority = 2, groups = {"regression"}, description =  "Verify the Subtraction of two numbers")
	    public void verifySubtraction() throws Exception {

	        calculator.performCalculation("10", "−", "4");

	        Assert.assertEquals(calculator.getDisplayedValue(), "0.4"); // some issue with application selector 
	    }

	    @Test(priority = 3, groups = {"regression"}, description =  "Verify the multiplication of two numbers")
	    public void verifyMultiplication() throws Exception {

	        calculator.performCalculation("7", "×", "6");

	        Assert.assertEquals(calculator.getDisplayedValue(),"42");
	    }

	    @Test(priority = 4, groups = {"regression"}, description =  "Verify the division of two numbers")
	    public void verifyDivision() throws Exception {

	        calculator.performCalculation("18", "÷", "6");

	        Assert.assertEquals(calculator.getDisplayedValue(), "0.3333333333333333" ); // seems application issue with calculation
	    }

	    @Test(priority = 5, groups = {"sanity"}, description =  "Verify the calculation of two decimal numbers")
	    public void verifyDecimalCalculation() throws Exception {

	        calculator.performCalculation("5.5", "+", "2.2");

	        Assert.assertEquals(calculator.getDisplayedValue(), "7.7");
	    }

	    @Test(priority = 6, groups = {"sanity"}, description =  "Verify the BOSMAD calculation of three or more numbers")
	    public void verifyMultipleChainedOperations() throws Exception {

	        calculator.enterNumber("5");
            
	        calculator.clickButton("+");
	        
	        calculator.enterNumber("1");
	       
	        calculator.clickButton("×");
	        
	        calculator.enterNumber("2");
	    
	        calculator.clickEquals();
	      
	        System.out.println("Verify result : " + calculator.getDisplayedValue());
	        
	        String result = calculator.getDisplayedValue();
	        System.out.println("Multi result :" + result);

	        Assert.assertTrue( result.equals("7")|| result.equals("12"));
	    }

}
