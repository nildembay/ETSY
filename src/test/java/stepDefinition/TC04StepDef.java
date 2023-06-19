package stepDefinition;

import com.google.gson.stream.JsonToken;
import io.cucumber.java.en.*;
import org.junit.Assert;
import pages.Locaters;
import utilities.Log;

public class TC04StepDef {

    Locaters locater=new Locaters();

    @And("user selects {string} sort filter ascending by product listed")
    public void userSelectsSortFilterAscendingByProductListed(String sorting) {

        Log.startTestCase("Sorting Test");
        locater.sortBy.click();
        for (int i=0; i<locater.sortMenu.size(); i++)
        {
            if (locater.sortMenu.get(i).getText().equals(sorting)){
                locater.sortMenu.get(i).click();
            }
        }
        Log.info("sorting asc");

    }

    @Then("user verifies that products aren't listed in ascending order")
    public void userVerifiesThatProductsArenTListedInAscendingOrder() throws InterruptedException {
        Thread.sleep(5000);
        double a=Double.parseDouble (locater.sortingResultList.get(0).getText());
        double b=Double.parseDouble (locater.sortingResultList.get(1).getText());
        System.out.println(a+"   "+b);
        Assert.assertFalse(a>=b);
        Log.endTestCase("Sorting Test");

    }
}
