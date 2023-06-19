package stepDefinition;

import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.interactions.Actions;
import pages.Locaters;
import utilities.Driver;
import utilities.Log;

import java.util.ArrayList;
import java.util.List;

public class TC09StepDef {

    Locaters locater=new Locaters();

    @Given("user clicks favorites button")
    public void user_clicks_favorites_button() throws InterruptedException {
        Log.startTestCase("Create collection testing");
        Thread.sleep(2000);
        locater.profile1.click();
        locater.profile2.click();

    }

    @Given("user clicks create collection button")
    public void user_clicks_create_collection_button() throws InterruptedException {
        Thread.sleep(2000);
        locater.createCollection.click();

    }

    @Given("user sends collection name {string} and clicks create button")
    public void user_sends_collection_name_and_clicks_create_button(String collectionName) throws InterruptedException {

        Thread.sleep(2000);
        locater.collectionName.sendKeys(collectionName);
        locater.collectionOK.click();

    }

    @Then("user verifies that the collection of {string} exists")
    public void user_verifies_that_the_collection_of_exists(String collectionName) {

        List<String> collectionList=new ArrayList<>();
        for (int i=0; i<locater.collectionList.size(); i++) {
            collectionList.add(locater.collectionList.get(i).getText());

        }
        int counter=0;
        for (int i=0; i<locater.collectionList.size(); i++) {
            if(locater.collectionList.get(i).getText().equals(collectionName)){
                counter++;
            }

        }
        Assert.assertTrue(counter==1);
        Log.endTestCase("Create collection testing");

    }

}
