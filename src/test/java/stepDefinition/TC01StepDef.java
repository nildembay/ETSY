package stepDefinition;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import pages.Locaters;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.Log;

public class TC01StepDef {
    Locaters locater=new Locaters();
    @Given("user goes to base url")
    public void userGoesToBaseUrl() {
        Log.startTestCase("SignIn");
        Driver.getDriver().get(ConfigReader.getProperty("url"));
    }

    @And("user clicks to sign in button")
    public void userClicksToSignInButton() {
        locater.signInButton.click();
    }

    @And("user clicks email area and enters valid email adress")
    public void userClicksEmailAreaAndEntersValidEmailAdress() {
        Log.info("enters mail and password");
        locater.mailTextBox.click();
        locater.mailTextBox.sendKeys(ConfigReader.getProperty("email"));
    }

    @And("user enters valid password")
    public void userEntersValidPassword() {
        locater.passwordTextBox.sendKeys(ConfigReader.getProperty("password"));
    }

    @And("user clicks sign in")
    public void userClicksSignIn() {
        locater.signIn.click();
    }

    @Then("user verifies that sees your profile")
    public void userVerifiesThatSeesYourProfile() throws InterruptedException {
        Log.info("verify");
        Thread.sleep(5000);

        //Assert.assertTrue(locater.verifyText.getText().contains("Mary"));
        Log.endTestCase("validSignin");
    }

    @And("user enters invalid password")
    public void userEntersInvalidPassword() {
        locater.passwordTextBox.sendKeys(ConfigReader.getProperty("invalidpassword"));
        Log.info("invalid password");

    }

    @Then("user verifies that sees fail message")
    public void userVerifiesThatSeesFailMessage() throws InterruptedException {
        Thread.sleep(2000);
        Assert.assertTrue(locater.failmessage.isDisplayed());
        Log.endTestCase("inValidSignin");
    }

    @Then("user signs out")
    public void userSignsOut() throws InterruptedException {
        Thread.sleep(2000);
        locater.profile1.click();
        locater.signOut.click();
    }
}
