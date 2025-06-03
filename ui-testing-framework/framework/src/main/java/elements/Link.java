package elements;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static com.codeborne.selenide.Condition.visible;

/**
 * Класс {@code Link} представляет собой элемент веб-интерфейса типа "гиперссылка".
 * Он расширяет функциональность базового элемента {@link BaseElement}
 * и предоставляет удобные методы создания ссылок по различным XPath-атрибутам.
 * <p>
 * Класс предназначен для использования в UI-тестах с библиотекой Selenide
 * и может быть расширен пользователями фреймворка при необходимости добавления
 * кастомных методов создания гиперссылок.
 *
 * @author Хабибуллина Алина
 */
public class Link extends BaseElement {
    private static final Logger logger = LoggerFactory.getLogger(Link.class);

    /**
     * Конструктор ссылки по XPath.
     *
     * @param XPath строка XPath для ссылки.
     */
    protected Link(String XPath) {
        super(XPath);
        logger.info("Initialized link with XPath: {}", XPath);
    }

    /**
     * Создаёт ссылку по заданному атрибуту и значению.
     *
     * @param attribute имя атрибута.
     * @param value значение атрибута.
     * @return экземпляр {@code Link}.
     */
    public static Link byAttribute(String attribute, String value) {
        return new Link(new XPathBuilder("a").withAttribute(attribute, value).build());
    }

    /**
     * Создаёт ссылку, у которой указанный атрибут содержит заданное значение.
     *
     * @param attribute имя атрибута.
     * @param value часть значения атрибута.
     * @return экземпляр {@code Link}.
     */
    public static Link byContainsAttribute(String attribute, String value) {
        return new Link(new XPathBuilder("a").containsAttribute(attribute, value).build());
    }

    /**
     * Создаёт ссылку по полному XPath.
     *
     * @param rawXPath строка XPath.
     * @return экземпляр {@code Link}.
     */
    public static Link byXPath(String rawXPath) {
        return new Link(rawXPath);
    }

    /**
     * Создаёт ссылку по точному тексту.
     *
     * @param text текст ссылки.
     * @return экземпляр {@code Link}.
     */
    public static Link byText(String text) {
        return new Link(new XPathBuilder("a").withText(text).build());
    }

    /**
     * Создаёт ссылку, текст которой содержит указанную строку.
     *
     * @param text часть текста.
     * @return экземпляр {@code Link}.
     */
    public static Link byContainsText(String text) {
        return new Link(new XPathBuilder("a").containsText(text).build());
    }

    /**
     * Создаёт ссылку по атрибуту {@code class}.
     *
     * @param classValue значение атрибута {@code class}.
     * @return экземпляр {@code Link}.
     */
    public static Link byClass(String classValue) {
        return Link.byAttribute("class", classValue);
    }

    /**
     * Создаёт ссылку, у которой {@code class} содержит заданное значение.
     *
     * @param classValue часть значения атрибута {@code class}.
     * @return экземпляр {@code Link}.
     */
    public static Link byContainsClass(String classValue) {
        return Link.byContainsAttribute("class", classValue);
    }

    /**
     * Создаёт ссылку по атрибуту {@code id}.
     *
     * @param idValue значение атрибута {@code id}.
     * @return экземпляр {@code Link}.
     */
    public static Link byId(String idValue) {
        return Link.byAttribute("id", idValue);
    }

    /**
     * Создаёт ссылку, у которой {@code id} содержит заданное значение.
     *
     * @param idValue часть значения атрибута {@code id}.
     * @return экземпляр {@code Link}.
     */
    public static Link byContainsId(String idValue) {
        return Link.byContainsAttribute("id", idValue);
    }

    /**
     * Создаёт ссылку по атрибуту {@code name}.
     *
     * @param nameValue значение атрибута {@code name}.
     * @return экземпляр {@code Link}.
     */
    public static Link byName(String nameValue) {
        return Link.byAttribute("name", nameValue);
    }

    /**
     * Создаёт ссылку, у которой {@code name} содержит заданное значение.
     *
     * @param nameValue часть значения атрибута {@code name}.
     * @return экземпляр {@code Link}.
     */
    public static Link byContainsName(String nameValue) {
        return Link.byContainsAttribute("name", nameValue);
    }

    /**
     * Создаёт ссылку по атрибуту {@code title}.
     *
     * @param titleValue значение атрибута {@code title}.
     * @return экземпляр {@code Link}.
     */
    public static Link byTitle(String titleValue) {
        return Link.byAttribute("title", titleValue);
    }

    /**
     * Создаёт ссылку, у которой {@code title} содержит заданное значение.
     *
     * @param titleValue часть значения атрибута {@code title}.
     * @return экземпляр {@code Link}.
     */
    public static Link byContainsTitle(String titleValue) {
        return Link.byContainsAttribute("title", titleValue);
    }

    /**
     * Создаёт ссылку по атрибуту {@code href}.
     *
     * @param hrefValue значение атрибута {@code href}.
     * @return экземпляр {@code Link}.
     */
    public static Link byHref(String hrefValue) {
        return Link.byAttribute("href", hrefValue);
    }

    /**
     * Создаёт ссылку, у которой {@code href} содержит заданное значение.
     *
     * @param hrefValue часть значения атрибута {@code href}.
     * @return экземпляр {@code Link}.
     */
    public static Link byContainsHref(String hrefValue) {
        return Link.byContainsAttribute("href", hrefValue);
    }

    /**
     * Вспомогательный метод построения XPath по точному совпадению атрибута.
     *
     * @param attr имя атрибута.
     * @param value значение атрибута.
     * @return XPath-выражение.
     */
    protected static String buildByAttribute(String attr, String value) {
        return new XPathBuilder("a").withAttribute(attr, value).build();
    }

    /**
     * Вспомогательный метод построения XPath по частичному совпадению атрибута.
     *
     * @param attr имя атрибута.
     * @param value часть значения атрибута.
     * @return XPath-выражение.
     */
    protected static String buildByContainsAttribute(String attr, String value) {
        return new XPathBuilder("a").containsAttribute(attr, value).build();
    }

    /**
     * Выполняет клик по ссылке.
     * Ожидает, что ссылка будет видимой.
     */
    public void click() {
        element.shouldBe(visible).click();
        logger.info("Clicked link with XPath: {}", element);
    }

    /**
     * Получает значение атрибута {@code href} ссылки.
     *
     * @return значение {@code href}.
     */
    public String getHref() {
        String href = element.shouldBe(visible).getAttribute("href");
        logger.info("Retrieved href '{}' from link with XPath: {}", href, element);
        return href;
    }

    /**
     * Получает текстовое содержимое ссылки.
     *
     * @return текст ссылки.
     */
    public String getText() {
        String text = element.shouldBe(visible).getText();
        logger.info("Retrieved text '{}' from link with XPath: {}", text, element);
        return text;
    }
}
