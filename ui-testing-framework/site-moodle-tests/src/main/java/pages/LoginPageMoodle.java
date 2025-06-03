package pages;

import basePage.BasePage;
import elements.Button;
import elements.Checkbox;
import elements.TextInput;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;

public class LoginPageMoodle extends BasePage {
    private static final Logger logger = LoggerFactory.getLogger(LoginPageMoodle.class);


    private final TextInput usernameInput = TextInput.byXPath("//input[@autocomplete = 'username']");
    private final TextInput passwordInput = TextInput.byXPath("//input[@autocomplete = 'current-password']");
    private final Button loginButton = Button.byXPath("//button[text()= 'Вход']");


    private final Checkbox rememberCheckbox = Checkbox.byContainsName("remember");

    public LoginPageMoodle() {
        super("https://vec.etu.ru/moodle/login/", Button.byId("loginbtn"));
        logger.info("Login page initialized");
    }

    public void enterUsername(String username) {
        usernameInput.setValue(username);
        logger.info("Entered username: {}", username);
    }

    public void enterPassword(String password) {
        passwordInput.setValue(password);
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
        $x("//div[contains(text(), \"Неверный\")]").shouldBe(visible);
    }

    public void clickRememberCheckbox(){
        rememberCheckbox.check();
        logger.info("Remember Checkbox button clicked");
    }

    public void rememberCheckboxIsChecked(){
        rememberCheckbox.isChecked();
    }

    public void RememberShouldBeChecked() {
        rememberCheckbox.shouldBeChecked();
    }

    public void RememberShouldNotBeChecked() {
        rememberCheckbox.shouldNotBeChecked();
    }
}
