package org.example.tests;

import org.example.baseTestHH.BaseHHTest;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.MainPageHH;
import pages.SearchPageHH;

public class MainHHTest  extends BaseHHTest {

    @Test
    @Tag("hh")
    public void searchTest() {
        MainPageHH mainPage = new MainPageHH();
        mainPage.openPage();

        mainPage.isDisplayed();

        mainPage.enterSearchRequest("аналитик");
        mainPage.clearTextButtonIsDisplayed();

        mainPage.clickSearchButton();
        if (mainPage.modalIsDisplayed()){
            mainPage.clickModal();
        }

        SearchPageHH searchPage = new SearchPageHH();
        searchPage.isDisplayed();
    }

    @Test
    @Tag("hh")
    public void searchClearTest() {
        MainPageHH mainPage = new MainPageHH();
        mainPage.openPage();

        mainPage.isDisplayed();
        mainPage.clearTextButtonIsNotDisplayed();

        mainPage.enterSearchRequest("аналитик");
        mainPage.clearTextButtonIsDisplayed();

        mainPage.clickClearTextButton();
        mainPage.searchInputShouldBeEmpty();
    }
}
