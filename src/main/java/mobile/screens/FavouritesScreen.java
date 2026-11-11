package mobile.screens;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidBy;
import io.appium.java_client.pagefactory.AndroidFindAll;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

import static mobile.locators.FavouritesLocators.FAVOURITES_ITEMS;
import static org.assertj.core.api.Assertions.assertThat;

@Slf4j
@Setter
public class FavouritesScreen extends BaseScreen {

    public FavouritesScreen(AppiumDriver driver) {
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindAll({@AndroidBy(xpath = FAVOURITES_ITEMS)})
    private List<WebElement> favouritesItems;

    public FavouritesScreen verifyListFavouritesItemsIsEqual(int number) {
        assertThat(favouritesItems.size()).as("Size of favourites items is not equal %d", number).isEqualTo(number);
        log.info("Searched items are not empty");
        return this;
    }
}
