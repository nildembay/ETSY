package stepDefinition;

import io.cucumber.java.en.*;
import org.junit.Assert;
import pages.Locaters;
import utilities.Log;

import java.util.ArrayList;
import java.util.List;

public class TC10StepDef {

    Locaters locater=new Locaters();
    String itemName;

    @Given("user clicks collection")
    public void user_clicks_collection() {
        Log.startTestCase("Edit collection testing");
        itemName=locater.collectionItem.getText();
        locater.collectionItem.click();
    }

    @Given("user clicks edit menu")
    public void user_clicks_edit_menu() throws InterruptedException {
        Thread.sleep(2000);
        locater.editButton.click();
    }

    @Given("user clicks delete collection button")
    public void user_clicks_delete_collection_button() throws InterruptedException {
        locater.deleteButton.click();
        Thread.sleep(2000);
        locater.deleteAccept.click();
        Thread.sleep(2000);
    }

    @Then("user verifies that collection is deleted")
    public void user_verifies_that_collection_is_deleted() {
        List<String> collectionList=new ArrayList<>();
        for (int i=0; i<locater.collectionList.size(); i++) {
            collectionList.add(locater.collectionList.get(i).getText());

        }
        int counter=0;
        for (int i=0; i<locater.collectionList.size(); i++) {
            if(locater.collectionList.get(i).getText().equals(itemName)){
                counter++;
            }

        }
        Assert.assertTrue(counter==0);
        Log.endTestCase("Edit collection testing");

    }


}
