package stepDefinition;

import io.cucumber.java.en.*;
import org.junit.Assert;
import pages.Locaters;
import utilities.Driver;
import utilities.Log;

import java.util.Locale;

public class TC07StepDef {
    Locaters locater=new Locaters();

    @Given("user verifies the title")
    public void user_verifies_the_title() {
        Log.startTestCase("Verify links testing");
        Driver.getDriver().getTitle().contains("Etsy");

    }
    @Given("user selects submenus and checks the correctness of their titles")
    public void user_selects_submenus_and_checks_the_correctness_of_their_titles() throws InterruptedException {
        for (int i=0; i<locater.menu.size(); i++){
            String title=locater.menu.get(i).getText();
            locater.menu.get(i).click();
            Thread.sleep(1000);
            Assert.assertTrue(Driver.getDriver().getTitle().contains(title.trim()));
            Log.endTestCase("Verify links testing");

        }


    }
}
