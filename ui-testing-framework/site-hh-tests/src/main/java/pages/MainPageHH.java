package pages;

import basePage.BasePage;
import com.codeborne.selenide.Selenide;
import elem.CustomButton;
import elements.Button;
import elements.Link;
import elements.TextInput;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MainPageHH extends BasePage {
    private static final Logger logger = LoggerFactory.getLogger(MainPageHH.class);


    private final TextInput searchInput= TextInput.byXPath("//input[@data-qa = 'search-input']");
    private final Button searchButton = Button.byXPath("//button[@type = 'submit']" );
    private final Button cleartextButton = Button.byXPath("//button[@data-qa = 'input-clearable-button']");
    private final CustomButton regionButton = CustomButton.byDataQa("region-clarification-submit-button");
    private final Link LoginLink = Link.byClass("supernova-button");

    public MainPageHH() {
        super("https://spb.hh.ru/?hhtmFrom=vacancy_search_list", Button.byAttribute("data-qa", "search-button" ));
        logger.info("Main page initialized");
    }

    public void clickRegionButton() {
        regionButton.click();
        logger.info("Region button clicked");
    }

    public boolean searchInputIsEmpty(){
        return searchInput.isEmpty();
    }

    public void clickSearchButton() {
        searchButton.click();
        logger.info("Search button clicked");
    }
    public void  regionButtonIsDisplayed(){
        regionButton.isDisplayed();
    }

    public void  clearTextButtonIsDisplayed(){
        cleartextButton.isDisplayed();
    }

    public void  clearTextButtonIsNotDisplayed(){
        cleartextButton.isNotDisplayed();
    }

    public void clickClearTextButton() {
        cleartextButton.click();
        logger.info("Clear text button clicked");
    }

    public void clickModal(){
        Selenide.$x("//div[@data-qa='bloko-modal-close']").click();

    }

    public boolean  modalIsDisplayed(){
        return Selenide.$x("//div[@data-qa='bloko-modal-close']").isDisplayed();
    }

    public void enterSearchRequest(String searchRequest) {
        searchInput.setValue(searchRequest);
        logger.info("Entered search request");
    }

    public void searchInputShouldBeEmpty(){
        searchInput.shouldBeEmpty();
    }

}
