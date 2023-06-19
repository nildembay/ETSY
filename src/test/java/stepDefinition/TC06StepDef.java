package stepDefinition;

import io.cucumber.java.en.*;
import org.junit.Assert;
import pages.Locaters;
import utilities.Driver;
import utilities.Log;
import utilities.Methods;

public class TC06StepDef {

    Locaters locater=new Locaters();
    String information;
    String mainPageHandle;

    @Given("user selects first item listed")
    public void user_selects_first_item_listed() {
        Log.startTestCase("Subcategories testing");
        information=locater.firstItemListed.getText();
        mainPageHandle= Driver.getDriver().getWindowHandle();
        locater.firstItemListed.click();

    }
    @Given("user Verifies that the properties of the selected item are displayed")
    public void user_verifies_that_the_properties_of_the_selected_item_are_displayed() throws InterruptedException {

        Driver.getDriver().switchTo().window(Methods.SwitcHandle(mainPageHandle));
        Thread.sleep(2000);
        System.out.println(information);
        System.out.println(locater.productProperties.getText());
        Assert.assertTrue(information.contains(locater.productProperties.getText()));


    }
    @Given("user clicks add to cart button")
    public void user_clicks_add_to_cart_button() {
        locater.addToCartButton.click();
    }

    @And("ser confirms that the product is in the cart")
    public void serConfirmsThatTheProductIsInTheCart() throws InterruptedException {
        Thread.sleep(2000);
        Assert.assertTrue(locater.title.isDisplayed());
        Log.endTestCase("Subcategories testing");
    }
}
