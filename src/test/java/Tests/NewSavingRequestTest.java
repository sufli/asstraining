package tests;
import base.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import pages.CalculatorPage;
public class NewSavingRequestTest extends TestBase {
    @Test
    public void itShouldDisplayTotalIncomeInNewRequest() {
        CalculatorPage calculatorPage = new CalculatorPage(driver);
        calculatorPage.selectFund("Death Star real estate");
        calculatorPage.investInput("20000");
        calculatorPage.yearsInput("24");
        calculatorPage.emailInput("nie2@nie.sk");
        //precitat total income
        String calculatedIncome = calculatorPage.getToatalIncome();
        //vytvorit novy saving
        driver.findElement(By.cssSelector("button.btn-block")).click();
        //overit ze sa total income zobrazi v requeste
        driver.findElement(By.xpath("//ul[contains(@class, 'saving-list')]/li/div")).getText();
        //System.out.println(driver.findElement(By.xpath("//ul[contains(@class, 'saving-list')]/li/div")).getText());
        //System.out.println(driver.findElement(By.xpath("//ul[contains(@class,'saving-list')]/li//div[contains(@class, 'amounts')]/p/span")).getText());

        Assert.assertEquals(
                calculatedIncome,
                driver
                .findElement(By.xpath("//ul[contains(@class,'saving-list')]/li//div[contains(@class, 'amounts')]/p/span")).getText());
    }
}