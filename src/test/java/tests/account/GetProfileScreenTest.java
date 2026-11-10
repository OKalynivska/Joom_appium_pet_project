package tests.account;

import mobile.helper.TestDescription;
import mobile.screens.JoomHomeScreen;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import tests.BaseTest;

import static mobile.enums.LoginTitle.LOGIN_TITLE;

public class GetProfileScreenTest extends BaseTest {


    @Test
    @DisplayName("Open Login Screen")
    @TestDescription("Close advertisement, open login screen")
    public void testGetLoginScreen() throws InterruptedException {
        JoomHomeScreen joomHomeScreen = new JoomHomeScreen(driver);
        Thread.sleep(5000);
        joomHomeScreen.closeAdvertisement();
        Thread.sleep(2000);
        joomHomeScreen.clickEnableButton()
                .clickDoNotAllowButton()
                .clickShopNowButton()
                .openLoginScreen()
                .verifyLoginScreenOpened(LOGIN_TITLE);
    }
}
