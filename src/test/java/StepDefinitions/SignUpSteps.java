package StepDefinitions;

import Pages.DialogContent;
import Utilities.BaseDriver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;

public class SignUpSteps {
    DialogContent dc = new DialogContent();
    @Given("Navigate to Demo Blaze")
    public void navigateToDemoBlaze() {
        BaseDriver.getDriver().get("https://www.demoblaze.com/index.html");
    }

    @When("Click Sign up")
    public void clickSignUp() {
        dc.clickMethod(dc.signUp);
    }

    @When("Enter username and password")
    public void enterUsernameAndPassword() {
        dc.sendKeysMethod(dc.username,"johnnn");
        dc.sendKeysMethod(dc.password,"doee");
    }

    @And("Click on Sign up Button")
    public void clickOnSignUpButton() {
        dc.clickMethod(dc.signUpButton);
    }

    @Then("User should login successfully")
    public void userShouldLoginSuccessfully() {
        File srcFile = ((TakesScreenshot) BaseDriver.getDriver()).getScreenshotAs(OutputType.FILE);
        String designatedFolder = "Success";
        File destFile = new File(designatedFolder + "/signUpSuccess.png");
    }

}
