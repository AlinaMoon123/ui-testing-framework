package elements;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static com.codeborne.selenide.Condition.enabled;
import static com.codeborne.selenide.Condition.selected;

/**
 /**
 * Класс {@code RadioButton} представляет собой элемент веб-интерфейса типа "радиокнопка".
 * Он расширяет функциональность базового элемента {@link BaseElement}
 * и предоставляет удобные методы создания радиокнопок по различным XPath-атрибутам.
 * <p>
 * Класс предназначен для использования в UI-тестах с библиотекой Selenide
 * и может быть расширен пользователями фреймворка при необходимости добавления
 * кастомных методов создания радиокнопок.
 *
 * @author Хабибуллина Алина
 */
public class RadioButton extends BaseElement {

    private static final Logger logger = LoggerFactory.getLogger(RadioButton.class);

    /**
     * Конструктор радио-кнопки по XPath.
     *
     * @param XPath строка XPath для радио-кнопки.
     */
    protected RadioButton(String XPath) {
        super(XPath);
        logger.info("Initialized radio button with XPath: {}", XPath);
    }

    /**
     * Создаёт радио-кнопку по полному XPath.
     *
     * @param rawXPath строка XPath.
     * @return экземпляр {@code RadioButton}.
     */
    public static RadioButton byXPath(String rawXPath) {
        return new RadioButton(rawXPath);
    }

    /**
     * Создаёт радио-кнопку по заданному атрибуту и значению.
     *
     * @param attribute имя атрибута.
     * @param value     значение атрибута.
     * @return экземпляр {@code RadioButton}.
     */
    public static RadioButton byAttribute(String attribute, String value) {
        return new RadioButton(new XPathBuilder("input")
                .withAttribute("type", "radio")
                .withAttribute(attribute, value)
                .build());
    }

    /**
     * Создаёт радио-кнопку, у которой атрибут содержит заданное значение.
     *
     * @param attribute имя атрибута.
     * @param value     часть значения атрибута.
     * @return экземпляр {@code RadioButton}.
     */
    public static RadioButton byContainsAttribute(String attribute, String value) {
        return new RadioButton(new XPathBuilder("input")
                .withAttribute("type", "radio")
                .containsAttribute(attribute, value)
                .build());
    }

    /**
     * Создаёт радио-кнопку по значению атрибута {@code class}.
     *
     * @param classValue значение атрибута {@code class}.
     * @return экземпляр {@code RadioButton}.
     */
    public static RadioButton byClass(String classValue) {
        return byAttribute("class", classValue);
    }

    /**
     * Создаёт радио-кнопку, у которой {@code class} содержит заданное значение.
     *
     * @param classValue часть значения атрибута {@code class}.
     * @return экземпляр {@code RadioButton}.
     */
    public static RadioButton byContainsClass(String classValue) {
        return byContainsAttribute("class", classValue);
    }

    /**
     * Создаёт радио-кнопку по значению атрибута {@code id}.
     *
     * @param idValue значение атрибута {@code id}.
     * @return экземпляр {@code RadioButton}.
     */
    public static RadioButton byId(String idValue) {
        return byAttribute("id", idValue);
    }

    /**
     * Создаёт радио-кнопку, у которой {@code id} содержит заданное значение.
     *
     * @param idValue часть значения атрибута {@code id}.
     * @return экземпляр {@code RadioButton}.
     */
    public static RadioButton byContainsId(String idValue) {
        return byContainsAttribute("id", idValue);
    }

    /**
     * Создаёт радио-кнопку по значению атрибута {@code name}.
     *
     * @param nameValue значение атрибута {@code name}.
     * @return экземпляр {@code RadioButton}.
     */
    public static RadioButton byName(String nameValue) {
        return byAttribute("name", nameValue);
    }

    /**
     * Создаёт радио-кнопку, у которой {@code name} содержит заданное значение.
     *
     * @param nameValue часть значения атрибута {@code name}.
     * @return экземпляр {@code RadioButton}.
     */
    public static RadioButton byContainsName(String nameValue) {
        return byContainsAttribute("name", nameValue);
    }

    /**
     * Создаёт радио-кнопку по значению атрибута {@code value}.
     *
     * @param value значение атрибута {@code value}.
     * @return экземпляр {@code RadioButton}.
     */
    public static RadioButton byValue(String value) {
        return byAttribute("value", value);
    }

    /**
     * Вспомогательный метод построения XPath по точному совпадению атрибута.
     * <p>
     * Предназначен для использования в подклассах для упрощения создания XPath по уникальным атрибутам пользователей.
     *
     * @param attr  имя атрибута.
     * @param value значение атрибута.
     * @return XPath-выражение.
     */
    protected static String buildByAttribute(String attr, String value) {
        return new XPathBuilder("button").withAttribute(attr, value).build();
    }

    /**
     * Вспомогательный метод построения XPath по частичному совпадению атрибута.
     * <p>
     * Предназначен для использования в подклассах для упрощения создания XPath по уникальным атрибутам пользователей.
     *
     * @param attr  имя атрибута.
     * @param value часть значения атрибута.
     * @return XPath-выражение.
     */
    protected static String buildByContainsAttribute(String attr, String value) {
        return new XPathBuilder("button").containsAttribute(attr, value).build();
    }


    /**
     * Выбирает радио-кнопку, если она ещё не выбрана.
     */
    public void select() {
        if (!isSelected()) {
            element.shouldBe(enabled).click();
            logger.info("Radio button selected: {}", element);
        } else {
            logger.info("Radio button already selected: {}", element);
        }
    }

    /**
     * Проверяет, выбрана ли радио-кнопка.
     *
     * @return {@code true}, если выбрана; {@code false} — в противном случае.
     */
    public boolean isSelected() {
        boolean selectedState = element.is(selected);
        logger.info("Radio button selected: {}", selectedState);
        return selectedState;
    }

    /**
     * Проверяет, что радио-кнопка выбрана.
     * <p>
     * Метод для написания тестов. Если радио-кнопка не выбрана, то тест упадет
     */
    public void shouldBeSelected() {
        element.shouldBe(selected);

    }

    /**
     * Проверяет, что радио-кнопка не выбрана.
     * <p>
     * Метод для написания тестов. Если радио-кнопка выбрана, то тест упадет
     */
    public void shouldNotBeSelected() {
        element.shouldNotBe(selected);

    }
}
