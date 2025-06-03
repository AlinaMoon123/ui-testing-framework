package org.example.tests;

import org.example.baseTestsMoodle.BaseMoodleTest;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.LoginPageMoodle;
import pages.MainPageMoodle;
import reader.ConfigReader;

public class LoginMoodleTest extends BaseMoodleTest {
    @Test
    @Tag("moodle")
    public void testLoginButtonClick() {
        String email = ConfigReader.getProperty("email");
        String password = ConfigReader.getProperty("password");

        LoginPageMoodle loginPage = new LoginPageMoodle();
        loginPage.openPage();

        loginPage.isDisplayed();
        loginPage.login(email, password);

        MainPageMoodle homePage = new MainPageMoodle();
        homePage.isDisplayed();
    }

    @Test
    @Tag("moodle")
    public void testLoginWithEmptyFields() {
        LoginPageMoodle loginPage = new LoginPageMoodle();
        loginPage.openPage();
        loginPage.isDisplayed();
        loginPage.clickLoginButton();
        loginPage.isDisplayed();
    }

    @Test
    @Tag("moodle")
    public void testLoginWithInvalidPassword() {
        String email = ConfigReader.getProperty("email");

        LoginPageMoodle loginPage = new LoginPageMoodle();
        loginPage.openPage();
        loginPage.enterUsername(email);
        loginPage.enterPassword("wrongpassword");
        loginPage.clickLoginButton();
        loginPage.isErrorMessageDisplayed();

    }

    @Test
    @Tag("moodle")
    public void testLoginWithInvalidEmail() {
        String password = ConfigReader.getProperty("password");

        LoginPageMoodle loginPage = new LoginPageMoodle();
        loginPage.openPage();
        loginPage.enterUsername("invalid@example.com");
        loginPage.enterPassword(password);
        loginPage.clickLoginButton();
        loginPage.isErrorMessageDisplayed();
    }

    @Test
    @Tag("moodle")
    public void testCheckbox() {
        LoginPageMoodle loginPage = new LoginPageMoodle();
        loginPage.openPage();
        loginPage.isDisplayed();
        loginPage.RememberShouldNotBeChecked();
        loginPage.clickRememberCheckbox();
        loginPage.RememberShouldBeChecked();
    }
}

