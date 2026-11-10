package tests.account;

import mobile.helper.TestDescription;
import mobile.screens.JoomHomeScreen;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import tests.BaseTest;

import static mobile.enums.SearchTitle.*;


public class SearchTest extends BaseTest {

    @Test
    @DisplayName("Positive | Search element")
    @TestDescription("Close advertisement, open search screen, search element")
    public void testSearchElement() throws InterruptedException {
        JoomHomeScreen joomHomeScreen = new JoomHomeScreen(driver);
        Thread.sleep(4000);
        joomHomeScreen.closeAdvertisement();
        Thread.sleep(2000);
        joomHomeScreen.clickEnableButton()
                .clickDoNotAllowButton()
                .openSearchScreen()
                .enterSearchValue(CATEGORY_ITEM)
                .verifyCategoryPresent(SEARCH_TITLE)
                .verifySearchedItemPresent(CATEGORY_ITEM);
    }

    @Test
    @DisplayName("Negative | Search element")
    @TestDescription("Close advertisement, open search screen, search element not present")
    public void testSearchElementNotPresent() throws InterruptedException {
        JoomHomeScreen joomHomeScreen = new JoomHomeScreen(driver);
        Thread.sleep(4000);
        joomHomeScreen.closeAdvertisement();
        Thread.sleep(2000);
        joomHomeScreen.clickEnableButton()
                .clickDoNotAllowButton()
                .openSearchScreen()
                .enterSearchValue(NOT_PRESENT_CATEGORY_ITEM)
                .verifyCategoryNotPresent(SEARCH_TITLE)
                .verifySearchedItemNotPresent(CATEGORY_ITEM);
    }
}
