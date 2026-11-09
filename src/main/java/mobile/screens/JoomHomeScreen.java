package mobile.screens;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import mobile.locators.JoomHomeLocators;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

@Slf4j
@Setter
public class JoomHomeScreen extends BaseScreen {
    @AndroidFindBy(xpath = JoomHomeLocators.SKIP_SPINNING_WHEEL)
    private WebElement skipQuizButton;

    @AndroidFindBy(xpath = JoomHomeLocators.PROFILE_BUTTON)
    private WebElement profileButton;

    @AndroidFindBy(xpath =JoomHomeLocators.DONT_ALLOW_BUTTON)
    private WebElement dontAllowButton;

    @AndroidFindBy(xpath=JoomHomeLocators.SHOP_NOW_BUTTON)
    private WebElement shopNowButton;


    public JoomHomeScreen(AppiumDriver driver) {
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }


    public JoomHomeScreen closeAdvertisement() {
        int xCoordinate = 991;
        int yCoordinate = 276;
        tapByCoordinate(xCoordinate, yCoordinate);
        log.info("Tapped advertisement close button");
        return this;
    }

    public JoomHomeScreen skipQuiz() {
        waitUntilElementIsVisible(skipQuizButton);
        clickOnElement(skipQuizButton);
        log.info("Spinning wheel: skipped");
        return new JoomHomeScreen(driver);
    }

    public JoomHomeScreen clickEnableButton() {
        int xCoordinate = 530;
        int yCoordinate = 2083;
        tapByCoordinate(xCoordinate, yCoordinate);
        log.info("Enable button clicked");
        return this;
    }

    public JoomHomeScreen clickDoNotAllowButton() {
        clickOnElement(dontAllowButton);
        log.info("Don't allow button clicked");
        return this;
    }

    public ProfileScreen openLoginScreen() {
        waitUntilElementIsVisible(profileButton);
        clickOnElement(profileButton);
        log.info("Profile opened");
        return new ProfileScreen(driver);
    }

    public JoomHomeScreen clickShopNowButton() {
        clickOnElement(shopNowButton);
        log.info("Shop now button clicked");
        return this;
    }
}
