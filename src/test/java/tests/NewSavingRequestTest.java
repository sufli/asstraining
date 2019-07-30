package tests;
import base.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pages.CalculatorPage;
public class NewSavingRequestTest extends TestBase {
    @Test
    public void itShouldDisplayTotalIncomeInNewRequest() {
        String fundToSelect = "Death Star real estate";
        CalculatorPage calculatorPage = new CalculatorPage(driver);
        calculatorPage.selectFund (fundToSelect);
        calculatorPage.investInput("20000");
        calculatorPage.yearsInput("24");
        calculatorPage.emailInput("nie2@nie.sk");
        //precitat total income
        String calculatedIncome = calculatorPage.getToatalIncome();
        //vytvorit novy saving
        calculatorPage.submitRequest();
        //overit ze sa total income zobrazi v requeste
        driver.findElement(By.xpath("//ul[contains(@class, 'saving-list')]/li/div")).getText();
        System.out.println(driver.findElement(By.xpath("//ul[contains(@class, 'saving-list')]/li/div")).getText());
        System.out.println(driver.findElement(By.xpath("//ul[contains(@class,'saving-list')]/li//div[contains(@class, 'amounts')]/p/span")).getText());

        Assert.assertEquals(
                calculatedIncome,
                driver
                .findElement(By.xpath("//ul[contains(@class,'saving-list')]/li//div[contains(@class, 'amounts')]/p/span")).getText());

        Assert.assertEquals(
                calculatedIncome,
                calculatorPage.prvacastcestynawebe("ul.saving-list > li div.amounts > p > span").getText());
    }

    @Test
    public void itShouldDisplayFundInNewRequest (){
        String fundToSelect = "Tom & Jerry corp";
        CalculatorPage calculatorPage = new CalculatorPage(driver);
        calculatorPage.selectFund(fundToSelect);
        calculatorPage.investInput("1000");
        calculatorPage.yearsInput("2");
        calculatorPage.emailInput("ale@podme.sk");
        calculatorPage.submitRequest();
        System.out.println(calculatorPage.prvacastcestynawebe("ul.saving-list > li > div.saving-detail").findElement(By.cssSelector("p.fund-description")).getText());

        String displayFund = calculatorPage.prvacastcestynawebe("ul.saving-list > li > div.saving-detail").findElement(By.cssSelector("p.fund-description")).getText();

        System.out.println(driver.findElement(By.xpath("//p[contains(@class, 'fund-description')]")).getText());

        Assert.assertEquals(displayFund, fundToSelect );

    }


}