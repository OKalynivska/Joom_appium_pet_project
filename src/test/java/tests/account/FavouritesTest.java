package tests.account;

import mobile.helper.TestDescription;
import mobile.screens.JoomHomeScreen;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import tests.BaseTest;

import static mobile.enums.SearchTitle.CATEGORY_ITEM;


public class FavouritesTest extends BaseTest {

    @Test
    @DisplayName("Add item to favourites")
    @TestDescription("Close advertisement, add item to favourites, favourite item present")
    public void testAddItemToFavourites() {
        JoomHomeScreen joomHomeScreen = new JoomHomeScreen(driver);
        joomHomeScreen.clickOnGetTheBestDealButton()
                .openSearchScreen()
                .enterSearchValue(CATEGORY_ITEM)
                .clickOnSearchedItem()
                .clickOnAddToFavouritesFirstButton();
        joomHomeScreen.openFavorites()
                .verifyListFavouritesItemsIsEqual(1);
        //need to think about logged user
    }
}
