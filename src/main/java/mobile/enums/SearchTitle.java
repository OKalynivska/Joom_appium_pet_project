package mobile.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum SearchTitle {
    SEARCH_TITLE("Categories"),
    CATEGORY_ITEM("Books"),
    NOT_PRESENT_CATEGORY_ITEM("Test something 123");

    private final String value;
}
