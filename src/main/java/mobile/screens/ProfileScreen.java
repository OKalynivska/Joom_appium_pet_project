package mobile.screens;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import lombok.extern.slf4j.Slf4j;
import mobile.enums.LoginTitle;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import static mobile.helper.Helper.isTextOnScreen;
import static mobile.locators.LoginLocators.LOG_IN_BUTTON;
import static mobile.locators.LoginLocators.LOG_IN_WITH_EMAIL_BUTTON;
import static org.assertj.core.api.Assertions.assertThat;

@Slf4j
public class ProfileScreen extends BaseScreen{
    public ProfileScreen(AppiumDriver driver) {
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(xpath= LOG_IN_BUTTON)
    private WebElement loginButton;

    @AndroidFindBy(xpath= LOG_IN_WITH_EMAIL_BUTTON)
    private WebElement loginWithEmailButton;

    public void verifyLoginScreenOpened(LoginTitle loginTitle){
        assertThat(isTextOnScreen(loginTitle.getValue()))
                .as("Check if the text '%s' is visible", loginTitle.getValue())
                .isTrue();
        log.info("Verified {} is visible", loginTitle.getValue());
    }

    public SignUpPopUpScreen clickOnLogInButton(){
        clickOnElement(loginButton);
        log.info("Log In button clicked");
        return new SignUpPopUpScreen(driver);
    }
}
