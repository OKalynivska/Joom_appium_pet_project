package mobile.screens;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import lombok.extern.slf4j.Slf4j;
import mobile.dto.AddUserData;
import mobile.enums.AccountTitle;
import mobile.helper.Helper;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import static mobile.locators.SignUpPopUpLocators.*;
import static org.assertj.core.api.Assertions.assertThat;

@Slf4j
public class SignUpPopUpScreen extends BaseScreen {

    public SignUpPopUpScreen(AppiumDriver driver) {
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(id = SHOW_MORE_LOGIN_OPTIONS)
    private WebElement showMoreLoginOptions;

    @AndroidFindBy(id = LOGIN_EMAIL_BUTTON)
    private WebElement loginEmailButton;

    @AndroidFindBy(id = EMAIL_INPUT_FIELD)
    private WebElement emailInputField;

    @AndroidFindBy(id = PASSWORD_INPUT_FIELD)
    private WebElement passwordInputField;

    @AndroidFindBy(id = LOGIN_BUTTON)
    private WebElement loginButton;

    @AndroidFindBy(id = REGISTER_BUTTON)
    private WebElement signUpButton;

    @AndroidFindBy(id = FIRST_NAME_INPUT_FIELD)
    private WebElement firstNameInputField;

    @AndroidFindBy(id = LAST_NAME_INPUT_FIELD)
    private WebElement lastNameInputField;

    @AndroidFindBy(id = PASSWORD_CONFIRMATION_INPUT_FIELD)
    private WebElement passwordConfirmationInputField;

    public SignUpPopUpScreen clickOnShowMoreLoginOptions() {
        clickOnElement(showMoreLoginOptions);
        log.info("Show more login options button clicked");
        return this;
    }

    public SignUpPopUpScreen clickOnLoginEmailButton() {
        clickOnElement(loginEmailButton);
        log.info("Login Email button clicked");
        return this;
    }

    public SignUpPopUpScreen enterFirstName(String firstName) {
        enterValue(firstNameInputField, firstName);
        log.info(firstName, " entered");
        return this;
    }

    public SignUpPopUpScreen enterLastName(String lastName) {
        enterValue(lastNameInputField, lastName);
        log.info(lastName, " entered");
        return this;
    }

    public SignUpPopUpScreen enterEmail(String email) {
        enterValue(emailInputField, email);
        log.info(email, " entered");
        return this;
    }

    public SignUpPopUpScreen enterPassword(String password) {
        enterValue(passwordInputField, password);
        log.info(password, " entered");
        return this;
    }

    public SignUpPopUpScreen enterPasswordConfirmation(String password) {
        enterValue(passwordConfirmationInputField, password);
        log.info(password, " entered");
        return this;
    }

    public SignUpPopUpScreen clickOnLoginButton() {
        clickOnElement(loginButton);
        log.info("Login button clicked");
        return this;
    }

    public SignUpPopUpScreen clickOnSignUpButton() {
        clickOnElement(signUpButton);
        log.info("Sign Up button clicked");
        return this;
    }

    public SignUpPopUpScreen newUserRegistration(AddUserData addUserData) {
        enterFirstName(addUserData.getUserFirstName());
        enterLastName(addUserData.getUserLastName());
        enterEmail(addUserData.getUserEmail());
        enterPassword(addUserData.getUserPassword());
        enterPasswordConfirmation(addUserData.getUserPasswordConfirmation());
        clickOnSignUpButton();
        return this;
    }

    public void verifyUserRegistered(AccountTitle accountTitle) {
        assertThat(Helper.isTextOnScreen(accountTitle.getValue()))
                .as("Check if '%s' is visible on screen", accountTitle.getValue())
                .isTrue();
        log.info("Verified '{}' text is visible", accountTitle.getValue());
    }

}
