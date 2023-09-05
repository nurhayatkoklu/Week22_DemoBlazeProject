package StepDefinitions;

import Pages.DialogContent;
import Utilities.BaseDriver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.Alert;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import java.io.File;

public class AddRemoveBuyProductSteps {
    DialogContent dc = new DialogContent();

    int TotalBeforeRemove;
    int TotalAfterRemove;

    int expectedTotal;

    @When("Login to the website")
    public void loginToTheWebsite() {
        dc.clickMethod(dc.login);
        dc.sendKeysMethod(dc.loginUserName, "kokk");
        dc.sendKeysMethod(dc.loginPassword, "Tokito");
        dc.clickMethod(dc.loginButton);

    }

    @And("Assert that you have successfully logged in")
    public void assertThatYouHaveSuccessfullyLoggedIn() {
        dc.assertText(dc.assertLogin, "kokk");

    }

    @And("Click Phones on side navigation menu")
    public void clickPhonesOnSideNavigationMenu() {
        dc.clickMethod(dc.phonesButton);
    }

    @And("Add a product")
    public void addAProduct() throws InterruptedException {
        dc.clickMethod(dc.SamsungGalaxy);
        dc.waitUntilVisible(dc.productPrice);
        String samsungPrice = dc.productPrice.getText();
        samsungPrice = samsungPrice.replaceAll("[^0-9]", "");
        expectedTotal = expectedTotal + Integer.parseInt(samsungPrice);
        Thread.sleep(1000);
        dc.clickMethod(dc.addProduct);
    }

    @And("Assert that you have successfully added product to your cart")
    public void assertThatYouHaveSuccessfullyAddedProductToYourCart() {
        dc.wait(2);
        Assert.assertTrue(BaseDriver.getDriver().switchTo().alert().getText().contains("Product added."));
        BaseDriver.getDriver().switchTo().alert().accept();
    }

    @And("Click Home")
    public void clickHome() {
        dc.clickMethod(dc.Home);
    }

    @And("Click Laptops on side navigation menu")
    public void clickLaptopsOnSideNavigationMenu() {
        dc.clickMethod(dc.laptopsButton);
    }

    @And("Add another product")
    public void addAnotherProduct() throws InterruptedException {
        dc.clickMethod(dc.SonyVaio);
        dc.waitUntilVisible(dc.productPrice);
        String SonyVaioPrice = dc.productPrice.getText();
        SonyVaioPrice = SonyVaioPrice.replaceAll("[^0-9]", "");
        expectedTotal = expectedTotal + Integer.parseInt(SonyVaioPrice);
        dc.clickMethod(dc.addProduct);
        dc.wait(2);
        BaseDriver.getDriver().switchTo().alert().accept();
    }

    @And("Click Monitors on side navigation menu")
    public void clickMonitorsOnSideNavigationMenu() {
        dc.clickMethod(dc.monitorsButton);
    }

    @And("Add one more product")
    public void addOneMoreProduct() throws InterruptedException {
        dc.clickMethod(dc.AppleMonitor);
        dc.waitUntilVisible(dc.productPrice);
        String appleMonitorPrice = dc.productPrice.getText();
        appleMonitorPrice = appleMonitorPrice.replaceAll("[^0-9]", "");
        expectedTotal = expectedTotal + Integer.parseInt(appleMonitorPrice);
        dc.clickMethod(dc.addProduct);
        dc.wait(2);
        BaseDriver.getDriver().switchTo().alert().accept();
    }

    @And("Go to your Cart")
    public void goToYourCart() {
        dc.clickMethod(dc.Cart);
    }

    @And("Remove monitor from your cart")
    public void removeMonitorFromYourCart() {
        String cartTotal = dc.Total.getText();
        TotalBeforeRemove = Integer.parseInt(cartTotal);
        dc.clickMethod(dc.remove);
    }

    @And("Assert that product removed from your cart")
    public void assertThatProductRemovedFromYourCart() {
        String cartTotal = dc.Total.getText();
        TotalAfterRemove = Integer.parseInt(cartTotal);
        Assert.assertTrue(TotalBeforeRemove > TotalAfterRemove);
    }

    @And("Click Next on the right corner")
    public void clickNextOnTheRightCorner() {
        dc.clickMethod(dc.Next);
    }

    @And("Add a product to your cart")
    public void addAProductToYourCart() {
        dc.clickMethod(dc.MacBookAir);
        String macBookAirPrice = dc.productPrice.getText().replaceAll("[^0-9]", "");
        expectedTotal = expectedTotal + Integer.parseInt(macBookAirPrice);
        dc.clickMethod(dc.addProduct);
    }

    @And("Assert that Total is correct")
    public void assertThatTotalIsCorrect() {
        Assert.assertEquals(String.valueOf(expectedTotal), dc.Total.getText().toString());


    }

    @And("Click Place Order")
    public void clickPlaceOrder() {
        dc.clickMethod(dc.placeOrder);
    }

    @And("Fill the form and click Purchase")
    public void fillTheFormAndClickPurchase() {
        dc.sendKeysMethod(dc.firstName, "John Doe");
        dc.sendKeysMethod(dc.country, "US");
        dc.sendKeysMethod(dc.city, "New York");
        dc.sendKeysMethod(dc.card, "1345678");
        dc.sendKeysMethod(dc.month, "June");
        dc.sendKeysMethod(dc.year, "2030");
        dc.clickMethod(dc.purchaseButton);

    }

    @And("Assert an Id is assigned to your order. Assert Amount, Card Number, Name and Date is correct")
    public void assertAnIdIsAssignedToYourOrderAssertAmountCardNumberNameAndDateIsCorrect() {
        dc.assertText(dc.id, "Id:");
        dc.assertText(dc.id, "Amount:");
        dc.assertText(dc.id, "Card Number:");
        dc.assertText(dc.id, "Name:");
        dc.assertText(dc.id, "Date:");
    }

    @Then("Click Ok")
    public void clickOk() {
        dc.clickMethod(dc.okeyButton);
    }
}
