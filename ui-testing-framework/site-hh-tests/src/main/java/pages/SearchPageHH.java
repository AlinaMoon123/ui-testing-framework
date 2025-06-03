package pages;

import basePage.BasePage;
import elements.Button;
import elements.Link;
import elements.RadioButton;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SearchPageHH extends BasePage {
    private static final Logger logger = LoggerFactory.getLogger(SearchPageHH.class);

    private final Button saveSearchButton = Button.byContainsAttribute("data-qa", "saved");
    private final RadioButton radioButton65 = RadioButton.byValue("65000");
    private final Link employerLink = Link.byText("Работодателям");
    private final Link CVLink = Link.byContainsText("базе резюме");

    public SearchPageHH() {
        super("https://spb.hh.ru/search/vacancy?text=&area=2&hhtmFrom=main&hhtmFromLabel=vacancy_search_line", Button.byContainsAttribute("data-qa", "saved"));
        logger.info("Search page initialized");
    }

    public void selectRadioButton65(){
        radioButton65.select();
    }

    public void radioButton65ShouldBeSelected(){
        radioButton65.shouldBeSelected();
        logger.info("Radio button is selected");
    }

    public void radioButton65ShouldNotBeSelected(){
        radioButton65.shouldNotBeSelected();
        logger.info("Radio button is not selected");
    }

    public void clickEmployerLink(){
        employerLink.click();
    }

    public void cvIsDisplayed(){
        CVLink.isDisplayed();
    }

}
