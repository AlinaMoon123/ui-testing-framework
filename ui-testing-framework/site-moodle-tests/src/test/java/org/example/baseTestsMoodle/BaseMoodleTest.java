package org.example.baseTestsMoodle;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static com.codeborne.selenide.Selenide.closeWebDriver;

public class BaseMoodleTest {
    private static final Logger logger = LoggerFactory.getLogger(BaseMoodleTest.class);

    @BeforeEach
    public void setUp() {
        logger.info("Запуск теста: Настройка браузера");

        Configuration.browser = System.getProperty("selenide.browser", "edge");
        Configuration.browserSize = System.getProperty("selenide.browserSize", "1920x1080");
        Configuration.timeout = Long.parseLong(System.getProperty("selenide.timeout", "10000"));

        SelenideLogger.addListener("AllureSelenide", new AllureSelenide()
                .screenshots(true)
                .savePageSource(false)
        );
    }

    @AfterEach
    public void tearDown() {
        logger.info("Завершение теста: Закрытие браузера");
        closeWebDriver();
        SelenideLogger.removeListener("AllureSelenide");
    }
}


