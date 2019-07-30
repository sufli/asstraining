package tests;
import base.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import pages.CalculatorPage;
import utils.MathUtils;

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
        @Test
           public void itShouldDisplayTwentyRequests() {
            CalculatorPage calculatorPage = new CalculatorPage(driver);
            for (int i = 0; i < 20 ; i++) {
                String fundToSelect = "Tom & Jerry corp";
                calculatorPage.selectFund(fundToSelect);
                calculatorPage.investInput(String.valueOf(MathUtils.getRandomNumberInRange(10,10000)));
                calculatorPage.yearsInput(String.valueOf(MathUtils.getRandomNumberInRange(1,10)));
                calculatorPage.emailInput("ale@podme.sk");
                calculatorPage.submitRequest();
            }
            driver.findElements(By.cssSelector("ul.saving-list > li > div.saving-detail"));
            Assert.assertEquals(20,  driver.findElements(By.cssSelector("ul.saving-list > li > div.saving-detail")).size());
    }
}




