package Utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BaseDriver {
    private static WebDriver driver;

    public static WebDriver getDriver() {
        if (driver == null) {
            closePreviousDrivers();
            Logger logger = Logger.getLogger("");
            logger.setLevel(Level.SEVERE);
            driver = new ChromeDriver();
            driver.manage().window().maximize();
        }


        return driver;
    }

    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }

    public static void closePreviousDrivers() {
        try {
            Runtime.getRuntime().exec("taskkill /F /IM chromedriver.exe /T");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
