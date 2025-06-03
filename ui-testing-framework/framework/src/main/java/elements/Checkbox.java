package elements;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static com.codeborne.selenide.Condition.enabled;
import static com.codeborne.selenide.Condition.selected;

/**
 /**
 * Класс {@code Checkbox} представляет собой элемент веб-интерфейса типа "чекбокс".
 * Он расширяет функциональность базового элемента {@link BaseElement}
 * и предоставляет удобные методы создания чекбоксов по различным XPath-атрибутам.
 * <p>
 * Класс предназначен для использования в UI-тестах с библиотекой Selenide
 * и может быть расширен пользователями фреймворка при необходимости добавления
 * кастомных методов создания чекюоксов.
 *
 * @author Хабибуллина Алина
 */
public class Checkbox extends BaseElement {

    private static final Logger logger = LoggerFactory.getLogger(Checkbox.class);

    /**
     * Конструктор чекбокса по XPath.
     *
     * @param XPath строка XPath.
     */
    protected Checkbox(String XPath) {
        super(XPath);
        logger.info("Initialized checkbox with XPath: {}", XPath);
    }

    /**
     * Создаёт чекбокс по полному XPath.
     *
     * @param rawXPath строка XPath.
     * @return экземпляр {@code Checkbox}.
     */
    public static Checkbox byXPath(String rawXPath) {
        return new Checkbox(rawXPath);
    }

    /**
     * Создаёт чекбокс по точному совпадению атрибута.
     *
     * @param attribute имя атрибута.
     * @param value     значение атрибута.
     * @return экземпляр {@code Checkbox}.
     */
    public static Checkbox byAttribute(String attribute, String value) {
        return new Checkbox(new XPathBuilder("input")
                .withAttribute("type", "checkbox")
                .withAttribute(attribute, value)
                .build());
    }

    /**
     * Создаёт чекбокс, у которого значение атрибута содержит указанную подстроку.
     *
     * @param attribute имя атрибута.
     * @param value     часть значения атрибута.
     * @return экземпляр {@code Checkbox}.
     */
    public static Checkbox byContainsAttribute(String attribute, String value) {
        return new Checkbox(new XPathBuilder("input")
                .withAttribute("type", "checkbox")
                .containsAttribute(attribute, value)
                .build());
    }

    /**
     * Создаёт чекбокс по атрибуту {@code class}.
     *
     * @param classValue значение атрибута {@code class}.
     * @return экземпляр {@code Checkbox}.
     */
    public static Checkbox byClass(String classValue) {
        return Checkbox.byAttribute("class", classValue);
    }

    /**
     * Создаёт чекбокс, у которого {@code class} содержит указанную подстроку.
     *
     * @param classValue часть значения атрибута {@code class}.
     * @return экземпляр {@code Checkbox}.
     */
    public static Checkbox byContainsClass(String classValue) {
        return Checkbox.byContainsAttribute("class", classValue);
    }

    /**
     * Создаёт чекбокс по атрибуту {@code id}.
     *
     * @param idValue значение атрибута {@code id}.
     * @return экземпляр {@code Checkbox}.
     */
    public static Checkbox byId(String idValue) {
        return Checkbox.byAttribute("id", idValue);
    }

    /**
     * Создаёт чекбокс, у которого {@code id} содержит указанную подстроку.
     *
     * @param idValue часть значения атрибута {@code id}.
     * @return экземпляр {@code Checkbox}.
     */
    public static Checkbox byContainsId(String idValue) {
        return Checkbox.byContainsAttribute("id", idValue);
    }

    /**
     * Создаёт чекбокс по атрибуту {@code name}.
     *
     * @param nameValue значение атрибута {@code name}.
     * @return экземпляр {@code Checkbox}.
     */
    public static Checkbox byName(String nameValue) {
        return Checkbox.byAttribute("name", nameValue);
    }

    /**
     * Создаёт чекбокс, у которого {@code name} содержит указанную подстроку.
     *
     * @param nameValue часть значения атрибута {@code name}.
     * @return экземпляр {@code Checkbox}.
     */
    public static Checkbox byContainsName(String nameValue) {
        return Checkbox.byContainsAttribute("name", nameValue);
    }

    /**
     * Создаёт радио-кнопку по значению атрибута {@code value}.
     *
     * @param value значение атрибута {@code value}.
     * @return экземпляр {@code RadioButton}.
     */
    public static Checkbox byValue(String value) {
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
     * Устанавливает флажок, если он не установлен.
     */
    public void check() {
        if (!isChecked()) {
            element.shouldBe(enabled).click();
            logger.info("Checked checkbox: {}", element);
        }
    }

    /**
     * Снимает флажок, если он установлен.
     */
    public void uncheck() {
        if (isChecked()) {
            element.shouldBe(enabled).click();
            logger.info("Unchecked checkbox: {}", element);
        }
    }

    /**
     * Проверяет, установлен ли флажок.
     *
     * @return {@code true}, если флажок установлен; {@code false} в противном случае.
     */
    public boolean isChecked() {
        boolean state = element.isSelected();
        logger.info("Checkbox checked: {}", state);
        return state;
    }

    public void shouldBeChecked() {
        element.shouldBe(selected);
        logger.info("Checkbox is checked");
    }

    public void shouldNotBeChecked() {
        element.shouldNotBe(selected);
        logger.info("Checkbox is not checked");
    }


}
