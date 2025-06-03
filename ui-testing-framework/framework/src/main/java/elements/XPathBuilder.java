package elements;

/**
 * Класс {@code XPathBuilder} предназначен для динамической сборки XPath-выражений.
 * <p>
 * Упрощает создание XPath с различными условиями поиска по атрибутам и тексту.
 * Поддерживает как точные совпадения атрибутов, так и частичные (через `contains()`).
 * <p>
 * Используется для построения XPath-выражений в классах элементов страницы.
 *
 * @author Хабибуллина Алина
 */
public class XPathBuilder {
    private StringBuilder xpath;

    /**
     * Создаёт новый экземпляр {@code XPathBuilder} с указанным тегом элемента.
     *
     * @param tag имя HTML-тега (например, "input", "button", "a").
     */
    protected XPathBuilder(String tag) {
        this.xpath = new StringBuilder("//").append(tag);
    }

    /**
     * Добавляет в XPath условие точного совпадения значения атрибута.
     *
     * @param attribute имя атрибута.
     * @param value     значение атрибута.
     * @return текущий экземпляр {@code XPathBuilder}.
     */
    public XPathBuilder withAttribute(String attribute, String value) {
        xpath.append(String.format("[@%s='%s']", attribute, value));
        return this;
    }

    /**
     * Добавляет проверку точного текста в элементе.
     * Например: [text()='Submit']
     */
    public XPathBuilder withText(String text) {
        xpath.append(String.format("[text()='%s']", text));
        return this;
    }

    /**
     * Добавляет в XPath условие, что текст элемента содержит указанную подстроку.
     *
     * @param text подстрока, которую должен содержать текст элемента.
     * @return текущий экземпляр {@code XPathBuilder}.
     */
    public XPathBuilder containsText(String text) {
        xpath.append(String.format("[contains(text(),'%s')]", text));
        return this;
    }

    /**
     * Добавляет в XPath условие, что значение указанного атрибута содержит подстроку.
     *
     * @param attribute имя атрибута.
     * @param value     подстрока значения атрибута.
     * @return текущий экземпляр {@code XPathBuilder}.
     */
    public XPathBuilder containsAttribute(String attribute, String value) {
        xpath.append(String.format("[contains(@%s,'%s')]", attribute, value));
        return this;
    }

    /**
     * Завершает построение XPath-выражения и возвращает его в виде строки.
     *
     * @return готовое XPath-выражение.
     */
    public String build() {
        return xpath.toString();
    }

    /**
     * Статический метод для создания нового экземпляра {@code XPathBuilder}.
     *
     * @param tagName имя HTML-тега (например, "div", "span", "input").
     * @return новый экземпляр {@code XPathBuilder} для дальнейшего построения выражения.
     */
    public static XPathBuilder create(String tagName) {
        return new XPathBuilder(tagName);
    }

}
