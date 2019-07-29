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
        driver.findElement(By.id("oneTimeInvestmentInput")).sendKeys("1500");
        driver.findElement(By.id("yearsInput")).sendKeys("39");
        driver.findElement(By.id("emailInput")).sendKeys("test@test.sk");
        driver.findElement(By.cssSelector("div.result > div:nth-child(1) > p"));
        Assert.assertFalse(driver.findElement(By.cssSelector("div.result > div:nth-child(1) > p")).getText().isEmpty());
        Assert.assertTrue(driver.findElement(By.cssSelector("div.result > div:nth-child(1) > p")).getText().contains("kr"));
    }

    @Test
    public void itShouldCalculateInterestIncome() {
        //1. vybrat fond, sumu, rok, email
        selectFund("Death Star real estate");
        driver.findElement(By.id("oneTimeInvestmentInput")).sendKeys("1500");
        driver.findElement(By.id("yearsInput")).sendKeys("39");
        driver.findElement(By.id("emailInput")).sendKeys("test@test.sk");
        driver.findElement(By.cssSelector("div.result > div:nth-child(2) > p"));
        Assert.assertFalse(driver.findElement(By.cssSelector("div.result > div:nth-child(2) > p")).getText().isEmpty());
    }

    @Test
    public void itShouldCalculateRisk() {
        //1. vybrat fond, sumu, rok, email
        selectFund("Death Star real estate");
        investInput("1500");
        yearsInput("25");
        emailInput("nie@nie.sk");
        driver.findElement(By.cssSelector("div.result > div:nth-child(3) > p"));
        Assert.assertFalse(driver.findElement(By.cssSelector("div.result > div:nth-child(3) > p")).getText().isEmpty());
    }

    private void selectFund(String fundToSelect){
        new Select(driver.findElement(By.id("fundSelect"))).selectByVisibleText(fundToSelect);
    }

    private void investInput(String investInput){
        driver.findElement(By.id("oneTimeInvestmentInput")).sendKeys(investInput);
    }

    private void yearsInput(String yearsInput){
        driver.findElement(By.id("yearsInput")).sendKeys(yearsInput);
    }

    private void emailInput(String emailInput){
        driver.findElement(By.id("emailInput")).sendKeys(emailInput);
    }

    @After
    public void tearDown() {
        driver.close();
        driver.quit();
    }
}
