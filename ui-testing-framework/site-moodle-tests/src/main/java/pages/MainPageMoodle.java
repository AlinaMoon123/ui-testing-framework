package pages;

import basePage.BasePage;
import elements.Link;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MainPageMoodle extends BasePage {
    private static final Logger logger = LoggerFactory.getLogger(MainPageMoodle.class);
    private final Link actionMenuLink = Link.byId("action-menu-toggle-1");
    private final Link LKLink = Link.byContainsAttribute("data-title", "admin");

    public MainPageMoodle() {
        super("https://vec.etu.ru/moodle/", "//h5[@id=\"instance-15219-header\"]");
        logger.info("Login page initialized");
    }
}