package Tests;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class CalculationTest {

    WebDriver driver;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("http://localhost/savingscalculator.php");
    }

    @Test
    public void itShouldCalculateTotalIncome() {
        //1. vybrat fond, sumu, rok, email
        selectFund("Death Star real estate");
        investInput("20000");
        yearsInput("24");
        emailInput("nie2@nie.sk");
        //driver.findElement(By.cssSelector("div.result > div:nth-child(1) > p"));
        Assert.assertFalse(getToatalIncome().isEmpty());
        Assert.assertTrue(getToatalIncome().contains("kr"));
    }

    @Test
    public void itShouldCalculateInterestIncome() {
        //1. vybrat fond, sumu, rok, email
        selectFund("Death Star real estate");
        investInput("4500");
        yearsInput("55");
        emailInput("nie3@nie.sk");
       // driver.findElement(By.cssSelector("div.result > div:nth-child(2) > p"));
        Assert.assertFalse(getToatalIncome2().isEmpty());
    }

    @Test
    public void itShouldCalculateRisk() {
        //1. vybrat fond, sumu, rok, email
        selectFund("Death Star real estate");
        investInput("1500");
        yearsInput("25");
        emailInput("nie@nie.sk");
        //driver.findElement(By.cssSelector("div.result > div:nth-child(3) > p"));
        Assert.assertFalse(getToatalIncome3().isEmpty());
    }

    @Test
    public void itShouldCalculateTotalIncomeForEachFund(){
        String[] arrayOfFunds = {"Death Star real estate", "Tom & Jerry corp", "Batman's Cave Development",
                "McDuck's safe", "Fellowship investment group", "Hoggwart's Fund", "Handelsbanken Aktiv 100"};
        for (String a : arrayOfFunds) {
            selectFund(a);
            investInput("1500");
            yearsInput("25");
            emailInput("nie@nie.sk");
            Assert.assertFalse(getToatalIncome().isEmpty());
            Assert.assertFalse(getToatalIncome2().isEmpty());
            Assert.assertFalse(getToatalIncome3().isEmpty());
            Assert.assertTrue(getToatalIncome().contains("kr"));
            Assert.assertTrue(getToatalIncome2().contains("kr"));
        }
    }

    private String getToatalIncome(){
        return driver.findElement(By.cssSelector("div.result > div:nth-child(1) > p")).getText();
    }
    private String getToatalIncome2(){
        return driver.findElement(By.cssSelector("div.result > div:nth-child(2) > p")).getText();
    }
    private String getToatalIncome3(){
        return driver.findElement(By.cssSelector("div.result > div:nth-child(3) > p")).getText();
    }
    private void selectFund(String fundToSelect){
        new Select(driver.findElement(By.id("fundSelect"))).selectByVisibleText(fundToSelect);
    }

    private void investInput(String investInput){
        driver.findElement(By.id("oneTimeInvestmentInput")).clear();
        driver.findElement(By.id("oneTimeInvestmentInput")).sendKeys(investInput);
    }

    private void yearsInput(String yearsInput){
        driver.findElement(By.id("yearsInput")).clear();
        driver.findElement(By.id("yearsInput")).sendKeys(yearsInput);
    }

    private void emailInput(String emailInput){
        driver.findElement(By.id("emailInput")).clear();
        driver.findElement(By.id("emailInput")).sendKeys(emailInput);
    }

    @After
    public void tearDown() {
        //driver.close();
        //driver.quit();
    }
}
