package stepDefinition;

import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.interactions.Actions;
import pages.Locaters;
import utilities.Driver;
import utilities.Log;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class TC05StepDef {

    Locaters locater=new Locaters();
    Actions actions=new Actions(Driver.getDriver());

    @Then("user selects Jewelry & Accessories menu")
    public void user_selects_jewelry_accessories_menu() throws InterruptedException {
        Log.startTestCase("Categories testing");
        actions.moveToElement(locater.mainMenu).perform();
        Thread.sleep(1000);

    }

    @Then("user selects Bags & Purses sub menu")
    public void user_selects_bags_purses_sub_menu() throws InterruptedException {
        actions.moveToElement(locater.subMenu).perform();
        Thread.sleep(1000);
        Log.info("selecting categories");
    }

    @Then("user assert that sub categories contain {string} , {string} , {string}")
    public void user_assert_that_sub_categories_contain(String string, String string2, String string3) {
        List<String> productList=new ArrayList<>();
        productList.add(string);
        productList.add(string2);
        productList.add(string3);

        List<String> subCategoriesList=new ArrayList<>();
        for (int i=0; i<locater.subCategories.size(); i++){
            subCategoriesList.add(locater.subCategories.get(i).getText().trim());
        }
        Assert.assertTrue(subCategoriesList.containsAll(productList));
        Log.endTestCase("Categories testing");

    }

}
