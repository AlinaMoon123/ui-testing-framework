package elements;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static com.codeborne.selenide.Condition.enabled;

/**
 * Класс {@code Button} представляет собой элемент веб-интерфейса типа "кнопка".
 * Он расширяет функциональность базового элемента {@link BaseElement}
 * и предоставляет удобные методы создания кнопок по различным XPath-атрибутам.
 * <p>
 * Класс предназначен для использования в UI-тестах с библиотекой Selenide
 * и может быть расширен пользователями фреймворка при необходимости добавления
 * кастомных методов создания кнопок.
 *
 * @author Хабибуллина Алина
 */
public class Button extends BaseElement {

    private static final Logger logger = LoggerFactory.getLogger(Button.class);

    /**
     * Конструктор кнопки по XPath.
     *
     * @param XPath строка XPath для кнопки.
     */
    protected Button(String XPath) {
        super(XPath);
        logger.info("Initialized button with XPath: {}", XPath);
    }

    /**
     * Создаёт кнопку по полному XPath.
     *
     * @param rawXPath строка XPath.
     * @return экземпляр {@code Button}.
     */
    public static Button byXPath(String rawXPath) {
        return new Button(rawXPath);
    }

    /**
     * Создаёт кнопку по заданному атрибуту и значению.
     *
     * @param attribute имя атрибута.
     * @param value     значение атрибута.
     * @return экземпляр {@code Button}.
     */
    public static Button byAttribute(String attribute, String value) {
        return new Button(new XPathBuilder("button").withAttribute(attribute, value).build());
    }

    /**
     * Создаёт кнопку, у которой атрибут содержит заданное значение.
     *
     * @param attribute имя атрибута.
     * @param value     часть значения атрибута.
     * @return экземпляр {@code Button}.
     */
    public static Button byContainsAttribute(String attribute, String value) {
        return new Button(new XPathBuilder("button").containsAttribute(attribute, value).build());
    }

    /**
     * Создаёт кнопку по точному тексту внутри неё.
     *
     * @param text текст кнопки.
     * @return экземпляр {@code Button}.
     */
    public static Button byText(String text) {
        return new Button(new XPathBuilder("button").withText(text).build());
    }

    /**
     * Создаёт кнопку, текст которой содержит указанную строку.
     *
     * @param text часть текста.
     * @return экземпляр {@code Button}.
     */
    public static Button byContainsText(String text) {
        return new Button(new XPathBuilder("button").containsText(text).build());
    }

    /**
     * Создаёт кнопку по значению атрибута {@code class}.
     *
     * @param classValue значение атрибута {@code class}.
     * @return экземпляр {@code Button}.
     */
    public static Button byClass(String classValue) {
        return Button.byAttribute("class", classValue);
    }

    /**
     * Создаёт кнопку, у которой {@code class} содержит заданное значение.
     *
     * @param classValue часть значения атрибута {@code class}.
     * @return экземпляр {@code Button}.
     */
    public static Button byContainsClass(String classValue) {
        return Button.byContainsAttribute("class", classValue);
    }

    /**
     * Создаёт кнопку по атрибуту {@code id}.
     *
     * @param idValue значение атрибута {@code id}.
     * @return экземпляр {@code Button}.
     */
    public static Button byId(String idValue) {
        return Button.byAttribute("id", idValue);
    }

    /**
     * Создаёт кнопку, у которой {@code id} содержит заданное значение.
     *
     * @param idValue часть значения атрибута {@code id}.
     * @return экземпляр {@code Button}.
     */
    public static Button byContainsId(String idValue) {
        return Button.byContainsAttribute("id", idValue);
    }

    /**
     * Создаёт кнопку по атрибуту {@code name}.
     *
     * @param nameValue значение атрибута {@code name}.
     * @return экземпляр {@code Button}.
     */
    public static Button byName(String nameValue) {
        return Button.byAttribute("name", nameValue);
    }

    /**
     * Создаёт кнопку, у которой {@code name} содержит заданное значение.
     *
     * @param nameValue часть значения атрибута {@code name}.
     * @return экземпляр {@code Button}.
     */
    public static Button byContainsName(String nameValue) {
        return Button.byContainsAttribute("name", nameValue);
    }

    /**
     * Создаёт кнопку по атрибуту {@code type}.
     *
     * @param typeValue значение атрибута {@code type}.
     * @return экземпляр {@code Button}.
     */
    public static Button byType(String typeValue) {
        return Button.byAttribute("type", typeValue);
    }

    /**
     * Создаёт кнопку, у которой {@code type} содержит заданное значение.
     *
     * @param typeValue часть значения атрибута {@code type}.
     * @return экземпляр {@code Button}.
     */
    public static Button byContainsType(String typeValue) {
        return Button.byContainsAttribute("type", typeValue);
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
     * Выполняет клик по кнопке.
     * Ожидает, что кнопка будет активна и доступна для взаимодействия.
     */
    public void click() {
        element.shouldBe(enabled).click();
        logger.info("Clicked button with XPath: {}", element);
    }

    /**
     * Получает текстовое содержимое кнопки.
     *
     * @return текст кнопки.
     */
    public String getText() {
        return element.getText();
    }
}
