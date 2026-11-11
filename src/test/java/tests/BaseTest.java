package tests;

import io.appium.java_client.AppiumDriver;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import mobile.Initializer;
import mobile.dto.AddUserData;
import mobile.helper.Helper;
import mobile.screens.JoomHomeScreen;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import java.io.InputStream;
import java.util.Properties;

import static mobile.Initializer.quitDriver;
import static mobile.utils.Constants.*;
import static mobile.utils.Constants.USER_LAST_NAME;

@Slf4j
public class BaseTest {
    protected static AppiumDriver driver;
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

    @BeforeEach
    @SneakyThrows
    public void setUp(){
        log.info("Driver initialization before test\n");
        driver= Initializer.getDriver();
        Helper.setDriver(driver);
        Thread.sleep(2000);

        JoomHomeScreen joomHomeScreen = new JoomHomeScreen(driver);
        Thread.sleep(5000);
        joomHomeScreen.closeAdvertisement();
        Thread.sleep(2000);
        joomHomeScreen.clickEnableButton()
                .clickDoNotAllowButton()
                .clickOnGetTheBestDealButton()
                .openLoginScreen()
                .clickOnLogInButton()
                .clickOnShowMoreLoginOptions()
                .clickOnLoginEmailButton()
                .logIn("email@examplet.com", "Password1_");
    }

    @AfterEach
    public void tearDown(){
        log.info("Closing driver");
        quitDriver();
    }
}
