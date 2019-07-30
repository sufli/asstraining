package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class CalculatorPage {

    private WebDriver pageDriver;

    public CalculatorPage(WebDriver driver) {
        this.pageDriver = driver;
    }
    public void selectFund(String fundToSelect){
        new Select(pageDriver.findElement(By.id("fundSelect"))).selectByVisibleText(fundToSelect);
    }
    public String getToatalIncome(){
        return pageDriver.findElement(By.cssSelector("div.result > div:nth-child(1) > p")).getText();
    }
    public String getToatalIncome2(){
        return pageDriver.findElement(By.cssSelector("div.result > div:nth-child(2) > p")).getText();
    }
    public String getToatalIncome3(){
        return pageDriver.findElement(By.cssSelector("div.result > div:nth-child(3) > p")).getText();
    }
    public void investInput(String investInput){
        pageDriver.findElement(By.id("oneTimeInvestmentInput")).clear();
        pageDriver.findElement(By.id("oneTimeInvestmentInput")).sendKeys(investInput);
    }

    public void yearsInput(String yearsInput){
        pageDriver.findElement(By.id("yearsInput")).clear();
        pageDriver.findElement(By.id("yearsInput")).sendKeys(yearsInput);

    }

    public void emailInput(String emailInput){
        pageDriver.findElement(By.id("emailInput")).clear();
        pageDriver.findElement(By.id("emailInput")).sendKeys(emailInput);
        pageDriver.findElement(By.id("emailInput")).sendKeys(Keys.TAB);
    }

    public void submitRequest(){
        pageDriver.findElement(By.cssSelector("button.btn-block")).click();
    }
    public WebElement prvacastcestynawebe(String s) {
        return pageDriver.findElement(By.cssSelector(s));
    }
}
