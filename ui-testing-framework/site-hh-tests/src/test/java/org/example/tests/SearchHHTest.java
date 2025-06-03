package org.example.tests;

import org.example.baseTestHH.BaseHHTest;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.SearchPageHH;

public class SearchHHTest extends BaseHHTest {

    @Test
    @Tag("hh")
    public void checkboxTest(){
        SearchPageHH searchPage = new SearchPageHH();
        searchPage.openPage();
        searchPage.radioButton65ShouldNotBeSelected();
        searchPage.selectRadioButton65();
        searchPage.radioButton65ShouldBeSelected();

    }

    @Test
    @Tag("hh")
    public void linkTest(){
        SearchPageHH searchPage = new SearchPageHH();
        searchPage.openPage();
        searchPage.clickEmployerLink();
        searchPage.cvIsDisplayed();
    }
}
