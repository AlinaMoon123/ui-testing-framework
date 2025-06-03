package pages;

import basePage.BasePage;
import com.codeborne.selenide.SelenideElement;
import elements.Button;
import elements.Link;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static com.codeborne.selenide.Selenide.$x;


public class HomePageLeti extends BasePage {
    private static final Logger logger = LoggerFactory.getLogger(HomePageLeti.class);

    private final SelenideElement dropdownMenu = $x("//div[contains(@class, 'dropdown-bottom')]");
    private final Button logoutButton = Button.byText(" Выйти");
    private final Link personal = Link.byHref("/personal");
    private final Link lk = Link.byContainsHref("https://lk.etu.ru/?");


    public HomePageLeti() {
        super("https://id.etu.ru/", Link.byHref("/personal"));
        logger.info("Home page initialized");
    }

    public void logout() {
        logger.info("Opening dropdown menu");
        dropdownMenu.click();

        logger.info("Clicking logout button");
        //logoutButton.click();
    }
}
