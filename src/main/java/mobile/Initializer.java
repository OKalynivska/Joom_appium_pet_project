package mobile;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import lombok.extern.slf4j.Slf4j;

import java.io.InputStream;
import java.net.URI;
import java.net.URL;
import java.time.Duration;
import java.util.Properties;

@Slf4j

public class Initializer {
    private static AppiumDriver driver;
    static Properties config = new Properties();

    static {
        try (InputStream inputStream = Initializer.class.getClassLoader().getResourceAsStream("config.properties")) {
            if (inputStream == null) {
                log.error("Enable to find cofig.properties");
            }
            config.load(inputStream);
        } catch (Exception e) {
            log.error("Failed to load configuration ", e);
            throw new ExceptionInInitializerError();
        }

    }

    public static AppiumDriver getDriver() {
        if (driver == null) {
            initDriver();
        }
        return driver;
    }

    private static void initDriver() {
        try {
            URI appiumServerUri = new URI(config.getProperty("appium.server.url"));
            URL appiumServerUrl = appiumServerUri.toURL();
            driver = new AndroidDriver(appiumServerUrl, getDesiredCapabilities());
            log.info("Driver initialized successfully");
        } catch (Exception e) {
            log.error("Driver initialization failed", e);
        }
    }

    private static UiAutomator2Options getDesiredCapabilities() {
        UiAutomator2Options options = new UiAutomator2Options();
        options.setDeviceName(config.getProperty("device.name"));
        options.setPlatformName(config.getProperty("platform.name"));
        options.setAppPackage(config.getProperty("app.package"));
        options.setAppActivity(config.getProperty("app.activity"));
        options.setAutomationName(config.getProperty("automation.name"));
        //options.setNewCommandTimeout(Duration.parse("new.command.timeout"));
        return options;
    }

    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver=null;
        }
    }
}
