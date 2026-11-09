package mobile.helper;

import io.appium.java_client.AppiumDriver;
import lombok.Setter;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class
Helper {
    @Setter
    private static AppiumDriver driver;

    public static Boolean isTextOnScreen(String expectedText) {
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(d -> d.getPageSource().contains(expectedText));
        return true;
    }
}
