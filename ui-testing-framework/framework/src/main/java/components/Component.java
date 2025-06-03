package components;

import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Condition.hidden;
import static com.codeborne.selenide.Condition.visible;

/**
 * Базовый класс {@code Component} представляет собой обёртку над {@link SelenideElement},
 * обеспечивающую базовую функциональность для компонентов пользовательского интерфейса.
 * <p>
 * Класс реализует проверки отображения элементов и предоставляет доступ к самому {@link SelenideElement}.
 *
 * @author Хабибуллина Алина
 */
public abstract class Component {
    /**
     * элемент страницы
     */
    protected SelenideElement element;

    /**
     * Конструктор для инициализации компонента с Selenide.
     *
     * @param element {@link SelenideElement}, соответствующий компоненту.
     */
    protected Component(SelenideElement element) {
        this.element = element;
    }

    /**
     * Проверяет, отображается ли элемент на странице.
     */
    public void isDisplayed() {
        element.shouldBe(visible);
    }

    /**
     * Проверяет, не отображается ли элемент на странице.
     */
    public void isNotDisplayed() {
        element.shouldNotBe(visible);
    }

    /**
     * Возвращает связанный с компонентом элемент Selenide.
     *
     * @return {@link SelenideElement}, с которым связан компонент.
     */
    public SelenideElement getElement() {
        return element;
    }
}

