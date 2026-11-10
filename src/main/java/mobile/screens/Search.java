package mobile.screens;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import lombok.extern.slf4j.Slf4j;
import mobile.enums.SearchTitle;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import static mobile.locators.SearchLocators.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.doesNotHave;

@Slf4j
public class Search extends BaseScreen {
    public Search(AppiumDriver driver) {
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(id = SEARCH_FIELD)
    private WebElement searchField;

    @AndroidFindBy(id=SEARCH_INPUT_FIELD)
    private WebElement searchInputField;

    @AndroidFindBy(xpath= SEARCHED_ITEM)
    private WebElement searchedItem;

    @AndroidFindBy(xpath = CATEGORY_ELEMENT)
    private WebElement category;

    public Search enterSearchValue(SearchTitle searchTitle){
        clickOnElement(searchField);
        enterValue(searchInputField, searchTitle.getValue());
        log.info(searchTitle.getValue(), " entered");
        return this;
    }

    public Search verifySearchedItemPresent(SearchTitle searchTitle){
        assertThat(searchedItem.getText())
                .as("Searched item '%s' has different value from '%s'", searchedItem.getText(), searchTitle.getValue())
                .isEqualTo(searchTitle.getValue());
        log.info(searchTitle.getValue(), " present");
        return this;
    }

    public Search verifyCategoryPresent(SearchTitle searchTitle){
        waitUntilElementIsVisible(category);
        assertThat(category.getText())
                .as("Category element '%s' has different value from '%s'", category.getText(), searchTitle.getValue())
                .isEqualTo(searchTitle.getValue());
        log.info(searchTitle.getValue(), " present");
        return this;
    }

    public Search verifySearchedItemNotPresent(SearchTitle searchTitle) {
        assertThat(driver.findElements(By.xpath(SEARCHED_ITEM)))
                .as("Searched element should not be present")
                .isEmpty();

        log.info("{} is not present", searchTitle.getValue());
        return this;
    }

    public Search verifyCategoryNotPresent(SearchTitle searchTitle) {
        assertThat(driver.findElements(By.xpath(CATEGORY_ELEMENT)))
                .as("Category element should not be present")
                .isEmpty();

        log.info("Category '{}' is not present", searchTitle.getValue());
        return this;
    }
}
