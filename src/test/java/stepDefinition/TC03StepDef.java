package stepDefinition;

import io.cucumber.java.en.*;
import net.bytebuddy.dynamic.scaffold.MethodRegistry;
import org.junit.Assert;
import org.openqa.selenium.WindowType;
import pages.Locaters;
import utilities.Driver;
import utilities.Log;
import utilities.Methods;

import java.util.Random;
import java.util.Set;

public class TC03StepDef {

    Locaters locater=new Locaters();
    String productText;
    String mainPageHandle;

    @Given("user chooses a random product listed")
    public void user_chooses_a_random_product_listed() {
        Log.startTestCase("Select the product");
        Random rnd = new Random();
        int index = rnd.nextInt(locater.searchResult.size());
        productText=locater.searchResult.get(index).getText();
        mainPageHandle=Driver.getDriver().getWindowHandle();
        locater.searchResult.get(index).click();

    }

    @Then("the user confirms that has seen the features of the product")
    public void the_user_confirms_that_has_seen_the_features_of_the_product() throws InterruptedException {
        System.out.println(productText);
        System.out.println("----------------------");

        Driver.getDriver().switchTo().window(Methods.SwitcHandle(mainPageHandle));
        Thread.sleep(2000);
        System.out.println(locater.productText.getText());
        Assert.assertTrue(locater.productText.getText().contains(productText));
        Log.endTestCase("Select the product");
    }

}
