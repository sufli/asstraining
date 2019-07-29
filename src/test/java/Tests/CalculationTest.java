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
        new Select(driver.findElement(By.id("fundSelect"))).selectByVisibleText("Hoggwart's Fund");
        driver.findElement(By.id("oneTimeInvestmentInput")).sendKeys("1500");
        driver.findElement(By.id("yearsInput")).sendKeys("39");
        driver.findElement(By.id("emailInput")).sendKeys("test@test.sk");
        driver.findElement(By.cssSelector("div.result > div:nth-child(1) > p"));
        Assert.assertFalse(driver.findElement(By.cssSelector("div.result > div:nth-child(1) > p")).getText().isEmpty());

    }

    @Test
    public void itShouldCalculateInterestIncome() {
        //1. vybrat fond, sumu, rok, email
        new Select(driver.findElement(By.id("fundSelect"))).selectByVisibleText("Hoggwart's Fund");
        driver.findElement(By.id("oneTimeInvestmentInput")).sendKeys("1500");
        driver.findElement(By.id("yearsInput")).sendKeys("39");
        driver.findElement(By.id("emailInput")).sendKeys("test@test.sk");
        driver.findElement(By.cssSelector("div.result > div:nth-child(2) > p"));
        Assert.assertFalse(driver.findElement(By.cssSelector("div.result > div:nth-child(2) > p")).getText().isEmpty());
    }

    @Test
    public void itShouldCalculateRisk() {
        //1. vybrat fond, sumu, rok, email
        new Select(driver.findElement(By.id("fundSelect"))).selectByVisibleText("Hoggwart's Fund");
        driver.findElement(By.id("oneTimeInvestmentInput")).sendKeys("1500");
        driver.findElement(By.id("yearsInput")).sendKeys("39");
        driver.findElement(By.id("emailInput")).sendKeys("test@test.sk");
        driver.findElement(By.cssSelector("div.result > div:nth-child(3) > p"));
        Assert.assertFalse(driver.findElement(By.cssSelector("div.result > div:nth-child(3) > p")).getText().isEmpty());
    }
    @After
    public void tearDown() {
        driver.close();
        driver.quit();
    }
}
