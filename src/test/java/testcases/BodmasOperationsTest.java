package testcases;


import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


import pages.CalculatorPage;

public class BodmasOperationsTest extends BaseTest {
	
	CalculatorPage calculator;

    @BeforeMethod(alwaysRun = true)
    public void initPage() {

        calculator = new CalculatorPage();
    }

    @Test(groups = {"sanity", "regression"}, description = "Verify multiplication precedence over addition")
    public void verifyMultiplicationPrecedence() {

        calculator.enterExpression("2+5×4");

        calculator.clickEquals();

        Assert.assertEquals( calculator.getDisplayedValue(),"22");
    }

    @Test( groups = {"regression", "sanity"}, description = "Verify bodmas operation")
    public void verifyPowerOperationPrecedence() {

        calculator.enterExpression("7×(5+2)");

        calculator.clickEquals();

        Assert.assertEquals(calculator.getDisplayedValue(), "49");
    }

}
