package StepDefinitions;

import Utilities.BaseDriver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.time.Duration;
import java.time.LocalDateTime;

public class Hooks {
    LocalDateTime startTime;
    LocalDateTime endTime;

    @Before // Runs before each scenario in the feature files
    public void beforeScenario() {
        startTime = LocalDateTime.now();
        System.out.println("Before Scenario runs");
    }

    @After // Runs after each scenario in the feature files
    public void afterScenario(Scenario scenario) {
        endTime = LocalDateTime.now();
        Duration duration = Duration.between(startTime, endTime);
        if (scenario.isFailed()) { // take screenshot when the scenario fails
            final byte[] byteImage = ((TakesScreenshot) BaseDriver.getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(byteImage, "image/png", scenario.getName());
        }
        BaseDriver.quitDriver();
    }
}
