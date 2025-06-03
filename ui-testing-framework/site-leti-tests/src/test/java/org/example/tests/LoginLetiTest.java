package org.example.tests;
import org.example.baseTestLeti.BaseLetiTest;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.HomePageLeti;
import pages.LoginPageLeti;
import reader.ConfigReader;


public class LoginLetiTest extends BaseLetiTest {

    @Test
    @Tag("leti")
    public void testLoginButtonClick() {
        String email = ConfigReader.getProperty("email");
        String password = ConfigReader.getProperty("password");

        LoginPageLeti loginPage = new LoginPageLeti();
        loginPage.openPage();

        loginPage.isDisplayed();
        loginPage.login(email, password);

        HomePageLeti homePage = new HomePageLeti();
        homePage.isDisplayed();
    }

    @Test
    @Tag("leti")
    public void testLoginWithEmptyFields() {
        LoginPageLeti loginPage = new LoginPageLeti();
        loginPage.openPage();
        loginPage.isDisplayed();
        loginPage.clickLoginButton();
        loginPage.isDisplayed();
    }

    @Test
    @Tag("leti")
    public void testLoginWithInvalidPassword() {
        String email = ConfigReader.getProperty("email");

        LoginPageLeti loginPage = new LoginPageLeti();
        loginPage.openPage();
        loginPage.enterUsername(email);
        loginPage.enterPassword("wrongpassword");
        loginPage.clickLoginButton();
        loginPage.isErrorMessageDisplayed();

    }

    @Test
    @Tag("leti")
    public void testLoginWithInvalidEmail() {
        String password = ConfigReader.getProperty("password");

        LoginPageLeti loginPage = new LoginPageLeti();
        loginPage.openPage();
        loginPage.enterUsername("invalid@example.com");
        loginPage.enterPassword(password);
        loginPage.clickLoginButton();
        loginPage.isErrorMessageDisplayed();
    }

    @Test
    @Tag("leti")
    public void testCheckbox() {
        LoginPageLeti loginPage = new LoginPageLeti();
        loginPage.openPage();
        loginPage.isDisplayed();
        loginPage.rememberShouldNotBeChecked();
        loginPage.clickRememberCheckbox();
        loginPage.rememberShouldBeChecked();
    }

}