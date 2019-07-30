package tests;

import base.TestBase;
import org.junit.Assert;
import org.junit.Test;
import pages.CalculatorPage;

public class CalculationTest extends TestBase {

    @Test
    public void itShouldCalculateTotalIncome() {
        //1. vybrat fond, sumu, rok, email
        CalculatorPage calculatorPage = new CalculatorPage(driver);
        calculatorPage.selectFund("Death Star real estate");
        calculatorPage.investInput("20000");
        calculatorPage.yearsInput("24");
        calculatorPage.emailInput("nie2@nie.sk");
        //driver.findElement(By.cssSelector("div.result > div:nth-child(1) > p"));
        Assert.assertFalse(calculatorPage.getToatalIncome().isEmpty());
        Assert.assertTrue(calculatorPage.getToatalIncome().contains("kr"));
    }

    @Test
    public void itShouldCalculateInterestIncome() {
        //1. vybrat fond, sumu, rok, email
        CalculatorPage calculatorPage = new CalculatorPage(driver);
        calculatorPage.selectFund("Death Star real estate");
        calculatorPage.investInput("4500");
        calculatorPage.yearsInput("55");
        calculatorPage.emailInput("nie3@nie.sk");
       // driver.findElement(By.cssSelector("div.result > div:nth-child(2) > p"));
        Assert.assertFalse(calculatorPage.getToatalIncome2().isEmpty());
    }

    @Test
    public void itShouldCalculateRisk() {
        //1. vybrat fond, sumu, rok, email
        CalculatorPage calculatorPage = new CalculatorPage(driver);
        calculatorPage.selectFund("Death Star real estate");
        calculatorPage.investInput("1500");
        calculatorPage.yearsInput("25");
        calculatorPage.emailInput("nie@nie.sk");
        //driver.findElement(By.cssSelector("div.result > div:nth-child(3) > p"));
        Assert.assertFalse(calculatorPage.getToatalIncome3().isEmpty());
    }

    @Test
    public void itShouldCalculateTotalIncomeForEachFund(){
        CalculatorPage calculatorPage = new CalculatorPage(driver);
        String[] arrayOfFunds = {"Death Star real estate", "Tom & Jerry corp", "Batman's Cave Development",
                "McDuck's safe", "Fellowship investment group", "Hoggwart's Fund", "Handelsbanken Aktiv 100"};
        for (String a : arrayOfFunds) {
            calculatorPage.selectFund(a);
            calculatorPage.investInput("1500");
            calculatorPage.yearsInput("25");
            calculatorPage.emailInput("nie@nie.sk");
            Assert.assertFalse(calculatorPage.getToatalIncome().isEmpty());
            Assert.assertFalse(calculatorPage.getToatalIncome2().isEmpty());
            Assert.assertFalse(calculatorPage.getToatalIncome3().isEmpty());
            Assert.assertTrue(calculatorPage.getToatalIncome().contains("kr"));
            Assert.assertTrue(calculatorPage.getToatalIncome2().contains("kr"));
        }
    }

}
