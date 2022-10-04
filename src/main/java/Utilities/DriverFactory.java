package Utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;

public class DriverFactory {
    private static ThreadLocal<WebDriver> webDriver = new ThreadLocal<>();

    public static WebDriver getDriver(){
        if (webDriver.get() == null){
            webDriver.set(createDriver());
        }
        return webDriver.get();
    }

    private static WebDriver createDriver(){
        WebDriver driver = null;

        String browserType = "chrome";

        switch (browserType) {
            case "chrome" -> {
                driver = WebDriverManager.chromedriver().create();
                break;
            }
            case "firefox" -> {
                driver = WebDriverManager.firefoxdriver().create();
                break;
            }

        }

        driver.manage().window().setSize(new Dimension(1920,1080));
        return driver;

    }

    public static void cleanupDriver(){
        webDriver.get().quit();
        webDriver.remove();
    }

}
