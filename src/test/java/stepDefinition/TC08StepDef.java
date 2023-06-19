package stepDefinition;

import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.ScriptKey;
import org.openqa.selenium.support.ui.Select;
import pages.Locaters;
import utilities.Driver;
import utilities.Log;

public class TC08StepDef {

    Locaters locater=new Locaters();

    @Given("user clicks the region settings")
    public void user_clicks_the_region_settings() {
        Log.startTestCase("Location testing");
        JavascriptExecutor js= (JavascriptExecutor) Driver.getDriver();
        String button= "document.getElementById('locale-picker-trigger').click()";
        js.executeScript(button);



    }

    @Given("user selects region {string}")
    public void user_selects_region(String region) {

        Select select=new Select(locater.region);
        select.selectByVisibleText(region);


    }

    @Given("user selects Language {string}")
    public void user_selects_language(String language) {
        Select select=new Select(locater.language);
        select.selectByVisibleText(language);
    }

    @Given("user selects Currency {string}")
    public void user_selects_currency(String currency) {
        Select select=new Select(locater.currency);
        select.selectByValue(currency);
    }


    @Then("user verifies that the page is loaded with the correct region option {string}")
    public void userVerifiesThatThePageIsLoadedWithTheCorrectRegionOption(String currencySymbol) throws InterruptedException {
        locater.saveButton.click();
        Thread.sleep(2000);
        Assert.assertTrue(locater.currencySymbol.getText().equals(currencySymbol));
        Log.endTestCase("Location testing");
    }
}
