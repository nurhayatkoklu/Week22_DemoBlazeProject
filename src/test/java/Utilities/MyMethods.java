package Utilities;

import io.cucumber.java.Scenario;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class MyMethods {
    public WebDriverWait wait = new WebDriverWait(BaseDriver.getDriver(), Duration.ofSeconds(4));

    public void clickMethod(WebElement element) {
        waitUntilVisible(element);
        wait.until(ExpectedConditions.elementToBeClickable(element));
        scrollToElement(element);
        element.click();
    }

    public void sendKeysMethod(WebElement element, String text) {
        waitUntilVisible(element);
        scrollToElement(element);
        element.clear();
        element.sendKeys(text);
    }

    public void assertText(WebElement element, String text) {
        waitUntilVisible(element);
        Assert.assertTrue(element.getText().contains(text));
    }

    public void waitUntilVisible(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void scrollToElement(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) BaseDriver.getDriver();
        js.executeScript("arguments[0].scrollIntoView();", element);
    }

    public void takeScreenShot(Scenario scenario) {
        final byte[] byteImage = ((TakesScreenshot) BaseDriver.getDriver()).getScreenshotAs(OutputType.BYTES);
        scenario.attach(byteImage, "image/png", scenario.getName());
    }

    public void acceptAlert() {

        Alert alert = BaseDriver.getDriver().switchTo().alert();
        alert.accept();
    }

    public void wait(int seconds){
        try {
            Thread.sleep(seconds*1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

}
