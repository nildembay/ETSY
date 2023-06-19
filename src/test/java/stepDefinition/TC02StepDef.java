package stepDefinition;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import pages.Locaters;
import utilities.Log;

import java.util.Locale;

public class TC02StepDef {
    Locaters locater=new Locaters();

    @And("clicks search text area and sends {string} for searching")
    public void clicksSearchTextAreaAndSendsForSearching(String searched) throws InterruptedException {
        Log.startTestCase("Search testing");
        Thread.sleep(2000);
        locater.searchBox.sendKeys(searched+ Keys.ENTER);
        Log.info("searching");

    }

    @Then("the user verifies that all listed records contain the {string}")
    public void theUserVerifiesThatAllListedRecordsContainThe(String searched) {
        for (int i=0; i<locater.searchResult.size(); i++){
            System.out.println(locater.searchResult.get(i).getText());
            String item=locater.searchResult.get(i).getText().toLowerCase();
            Assert.assertTrue(item.contains(searched.toLowerCase()));

            //Sitede beklenen dışında ürün gelince fail ediyor

            Log.endTestCase("Search testing");
        }
    }


}
