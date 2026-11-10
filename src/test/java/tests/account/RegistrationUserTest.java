package tests.account;

import lombok.extern.slf4j.Slf4j;
import mobile.dto.AddUserData;
import mobile.helper.TestDescription;
import mobile.screens.JoomHomeScreen;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import tests.BaseTest;

import static mobile.enums.AccountTitle.NEW_USER_DATA;
import static mobile.utils.Constants.*;

@Slf4j
public class RegistrationUserTest extends BaseTest {

    private final AddUserData userData = AddUserData.builder()
            .userFirstName(USER_FIRST_NAME)
            .userLastName(USER_LAST_NAME)
            .userEmail(USER_EMAIL)
            .userPassword(USER_PASSWORD)
            .userPasswordConfirmation(USER_PASSWORD)
            .build();

    @Test
    @DisplayName("User registration")
    @TestDescription("Close advertisement, open login screen and sign up")
    public void testRegistrationUser(){
        JoomHomeScreen joomHomeScreen = new JoomHomeScreen(driver);
        joomHomeScreen.openLoginScreen()
                .clickOnLogInButton()
                .clickOnShowMoreLoginOptions()
                .clickOnLoginEmailButton()
                .clickOnSignUpButton()
                .newUserRegistration(userData)
                .verifyUserRegistered(NEW_USER_DATA);
    }
}
