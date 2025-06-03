package elements;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static com.codeborne.selenide.Condition.value;
import static com.codeborne.selenide.Condition.visible;

/**
 * Класс {@code TextInput} представляет собой элемент веб-интерфейса типа "текстовое поле".
 * Он расширяет функциональность базового элемента {@link BaseElement}
 * и предоставляет удобные методы создания текстового поля по различным XPath-атрибутам.
 * <p>
 * Класс предназначен для использования в UI-тестах с библиотекой Selenide
 * и может быть расширен пользователями фреймворка при необходимости добавления
 * кастомных методов создания текстовых полей.
 *
 * @author Хабибуллина Алина
 */
public class TextInput extends BaseElement {
    private static final Logger logger = LoggerFactory.getLogger(TextInput.class);

    /**
     * Конструктор для создания текстового поля по XPath.
     *
     * @param XPath строка XPath до текстового поля.
     */
    protected TextInput(String XPath) {
        super(XPath);
        logger.info("Initialized text input with XPath: {}", XPath);
    }

    /**
     * Создаёт текстовое поле по заданному атрибуту и значению.
     *
     * @param attribute имя атрибута.
     * @param value значение атрибута.
     * @return экземпляр {@code TextInput}.
     */
    public static TextInput byAttribute(String attribute, String value) {
        return new TextInput(new XPathBuilder("input").withAttribute(attribute, value).build());
    }

    /**
     * Создаёт текстовое поле, у которого атрибут содержит указанное значение.
     *
     * @param attribute имя атрибута.
     * @param value часть значения атрибута.
     * @return экземпляр {@code TextInput}.
     */
    public static TextInput byContainsAttribute(String attribute, String value) {
        return new TextInput(new XPathBuilder("input").containsAttribute(attribute, value).build());
    }

    /**
     * Создаёт кнопку по значению атрибута {@code class}.
     *
     * @param classValue значение атрибута {@code class}.
     * @return экземпляр {@code Button}.
     */
    public static TextInput byClass(String classValue) {
        return TextInput.byAttribute("class", classValue);
    }

    /**
     * Создаёт кнопку, у которой {@code class} содержит заданное значение.
     *
     * @param classValue часть значения атрибута {@code class}.
     * @return экземпляр {@code Button}.
     */
    public static TextInput byContainsClass(String classValue) {
        return TextInput.byContainsAttribute("class", classValue);
    }

    /**
     * Создаёт текстовое поле по атрибуту {@code name}.
     *
     * @param name значение атрибута {@code name}.
     * @return экземпляр {@code TextInput}.
     */
    public static TextInput byName(String name) {
        return TextInput.byAttribute("name", name);
    }

    /**
     * Создаёт текстовое поле, у которого {@code name} содержит указанное значение.
     *
     * @param name часть значения {@code name}.
     * @return экземпляр {@code TextInput}.
     */
    public static TextInput byContainsName(String name) {
        return TextInput.byContainsAttribute("name", name);
    }

    /**
     * Создаёт текстовое поле по атрибуту {@code id}.
     *
     * @param id значение атрибута {@code id}.
     * @return экземпляр {@code TextInput}.
     */
    public static TextInput byId(String id) {
        return TextInput.byAttribute("id", id);
    }

    /**
     * Создаёт текстовое поле, у которого {@code id} содержит указанное значение.
     *
     * @param id часть значения {@code id}.
     * @return экземпляр {@code TextInput}.
     */
    public static TextInput byContainsId(String id) {
        return TextInput.byContainsAttribute("id", id);
    }

    /**
     * Создаёт текстовое поле по атрибуту {@code placeholder}.
     *
     * @param placeholder значение атрибута {@code placeholder}.
     * @return экземпляр {@code TextInput}.
     */
    public static TextInput byPlaceholder(String placeholder) {
        return TextInput.byAttribute("placeholder", placeholder);
    }

    /**
     * Создаёт текстовое поле, у которого {@code placeholder} содержит указанное значение.
     *
     * @param placeholder часть значения {@code placeholder}.
     * @return экземпляр {@code TextInput}.
     */
    public static TextInput byContainsPlaceholder(String placeholder) {
        return TextInput.byContainsAttribute("placeholder", placeholder);
    }

    /**
     * Создаёт текстовое поле по атрибуту {@code type}.
     *
     * @param type значение атрибута {@code type}.
     * @return экземпляр {@code TextInput}.
     */
    public static TextInput byType(String type) {
        return TextInput.byAttribute("type", type);
    }

    /**
     * Создаёт текстовое поле, у которого {@code type} содержит указанное значение.
     *
     * @param type часть значения {@code type}.
     * @return экземпляр {@code TextInput}.
     */
    public static TextInput byContainsType(String type) {
        return TextInput.byContainsAttribute("type", type);
    }

    /**
     * Создаёт текстовое поле по XPath.
     *
     * @param rawXPath строка XPath.
     * @return экземпляр {@code TextInput}.
     */
    public static TextInput byXPath(String rawXPath) {
        return new TextInput(rawXPath);
    }

    /**
     * Вспомогательный метод для построения XPath по атрибуту.
     *
     * @param attr имя атрибута.
     * @param value значение атрибута.
     * @return XPath-выражение.
     */
    protected static String buildByAttribute(String attr, String value) {
        return new XPathBuilder("input").withAttribute(attr, value).build();
    }

    /**
     * Вспомогательный метод для построения XPath по частичному совпадению атрибута.
     *
     * @param attr имя атрибута.
     * @param value часть значения атрибута.
     * @return XPath-выражение.
     */
    protected static String buildByContainsAttribute(String attr, String value) {
        return new XPathBuilder("input").containsAttribute(attr, value).build();
    }

    /**
     * Проверяет, пусто ли текстовое поле.
     *
     * @return {@code true}, если поле пустое, иначе {@code false}.
     */
    public boolean isEmpty() {
        boolean empty = getValue().isEmpty();
        logger.info("Checked if input is empty: {}", empty);
        return empty;
    }

    /**
     * Проверяет, что текстовое поле пустое.
     * <p>Вызывает исключение, если поле не пустое.</p>
     */
    public void shouldBeEmpty() {
        element.shouldHave(value("")); // Selenide проверяет, что значение пустое
        logger.info("Input is empty as expected");
    }


    /**
     * Устанавливает заданное значение в текстовое поле.
     *
     * @param value значение для ввода.
     */
    public void setValue(String value) {
        element.shouldBe(visible).setValue(value);
        logger.info("Set value '{}' for input with XPath: {}", value, element);
    }

    /**
     * Получает текущее значение из текстового поля.
     *
     * @return текущее значение поля.
     */
    public String getValue() {
        String value = element.shouldBe(visible).getValue();
        logger.info("Retrieved value '{}' from input with XPath: {}", value, element);
        return value;
    }

    /**
     * Очищает содержимое текстового поля.
     */
    public void clear() {
        element.shouldBe(visible).clear();
        logger.info("Cleared input with XPath: {}", element);
    }
}
