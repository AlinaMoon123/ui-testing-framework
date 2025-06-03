package elements;

import components.Component;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import static com.codeborne.selenide.Selenide.$x;

/**
 * Базовый класс {@code BaseElement} представляет собой абстракцию над
 * любым элементом веб-интерфейса, основанную на использовании XPath.
 * <p>
 * Является родительским классом для специализированных элементов,
 * таких как {@link Button}, {@link Link}, {@link TextInput} и других.
 * Обеспечивает базовую инициализацию элемента и общее поведение, такое как фокусировка.
 * <p>
 * Используется в рамках UI-тестирования с использованием Selenide.
 *
 * @author Хабибуллина Алина
 */
public class BaseElement extends Component {
    private static final Logger logger = LoggerFactory.getLogger(BaseElement.class);

    /**
     * Конструктор элемента по XPath.
     *
     * @param XPath XPath-выражение, указывающее на элемент.
     */
    protected BaseElement(String XPath) {
        super($x(XPath));
        logger.info("Initialized element with XPath: {}", XPath);
    }

    /**
     * Наводит курсор на элемент, чтобы установить на него фокус.
     * Может использоваться для имитации пользовательского взаимодействия с элементом.
     */
    public void focus() {
        element.hover();
    }

    /**
     * Проверяет, доступен ли элемент для взаимодействия.
     *
     * @return {@code true}, если элемент доступен для взаимодействия; {@code false} в противном случае.
     */
    public boolean isEnabled() {
        return element.isEnabled();
    }
}
