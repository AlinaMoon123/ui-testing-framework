package pages;

import basePage.BasePage;
import elements.Button;
import elements.Checkbox;
import elements.TextInput;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;

public class LoginPageLeti extends BasePage {
    private static final Logger logger = LoggerFactory.getLogger(LoginPageLeti.class);


    private final TextInput usernameField = TextInput.byName("email");
    private final TextInput passwordField = TextInput.byName("password");

    private final Button loginButton = Button.byXPath("//button[contains(@class, 'btn-primary')]");



    private final Checkbox rememberCheckbox = Checkbox.byId("remember");

    public LoginPageLeti() {
        super("https://id.etu.ru/login", Button.byContainsClass("btn-primary"));
        logger.info("Login page initialized");
    }

    public void enterUsername(String username) {
        usernameField.setValue(username);
        logger.info("Entered username: {}", username);
    }

    public void enterPassword(String password) {
        passwordField.setValue(password);
        logger.info("Entered password");
    }

    public void clickLoginButton() {
        loginButton.click();
        logger.info("Login button clicked");
    }

    public void login(String username, String password) {
        enterUsername(username);
        enterPassword(password);
        clickLoginButton();
    }

    public void isErrorMessageDisplayed() {
        $x("//span[contains(@class, 'text-error')]").shouldBe(visible);
    }

    public String getErrorMessage() {
        return $x("//span[contains(@class, 'text-error')]").shouldBe(visible).getText();
    }

    public void clickRememberCheckbox(){
        rememberCheckbox.check();
        logger.info("Remember Checkbox button clicked");
    }

    public void rememberCheckboxIsChecked(){
        rememberCheckbox.isChecked();
    }

    public void rememberShouldBeChecked() {
        rememberCheckbox.shouldBeChecked();
    }

    public void rememberShouldNotBeChecked() {
        rememberCheckbox.shouldNotBeChecked();
    }
}
