package Tests;

import base.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import pages.CalculatorPage;

public class SavingCalculatorTest extends TestBase {

    @Test
    public void itShouldDisplayTitle() {
        Assert.assertEquals("Savings Calculator", driver.findElement(By.cssSelector("h1")).getText());
    }

    @Test
    public void itShouldDisableApplyButtonOnPageOpen() {
        Assert.assertFalse(driver.findElement(By.cssSelector("button.btn-block")).isEnabled());
    }

    @Test
    public void itShouldEnableApplyButton() {
        //1. vybrat fond
        CalculatorPage calculatorPage = new CalculatorPage(driver);
        calculatorPage.selectFund("Hoggwart's Fund");
        //2.zadat sumu
        driver.findElement(By.id("oneTimeInvestmentInput")).sendKeys("1500");
        //3.zadat pocet rokov
        driver.findElement(By.id("yearsInput")).sendKeys("39");
        //4.zadat email
        driver.findElement(By.id("emailInput")).sendKeys("test@test.sk");
        //5.overit button
        Assert.assertTrue(driver.findElement(By.cssSelector("button.btn-block")).isEnabled());
    }

    @Test
    public void itShouldnotSelectAnyFundOnPageOpen() {
        new Select(driver.findElement(By.id("fundSelect"))).getFirstSelectedOption().getText();
        System.out.println(new Select(driver.findElement(By.id("fundSelect"))).getFirstSelectedOption().getText());
        Assert.assertEquals("Select your fund",
                new Select(driver.findElement(By.id("fundSelect"))).getFirstSelectedOption().getText());
    }


}
