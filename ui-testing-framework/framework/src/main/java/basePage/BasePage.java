package basePage;

import com.codeborne.selenide.Selenide;
import components.Component;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;

/**
 * Базовый класс {@code BasePage} представляет собой абстракцию для всех страниц веб-приложения
 * <p>
 * Обеспечивает общую структуру и поведение страниц, включая открытие, обновление и ожидание загрузки страницы.
 * Наследует от {@link Component} и использует главный элемент страницы в качестве проверки загрузки страницы.
 *
 * @author Хабибуллина Алина
 */
public abstract class BasePage extends Component {
    /**
     * URL страницы, которую представляет данный объект.
     */
    protected final String url;

    private static final Logger logger = LoggerFactory.getLogger(BasePage.class);

    /**
     * Конструктор страницы с указанием URL и XPath главного элемента.
     *
     * @param url              адрес страницы.
     * @param mainElementXPath XPath главного элемента страницы (используется как индикатор загрузки).
     */
    protected BasePage(String url, String mainElementXPath) {
        super($x(mainElementXPath));
        this.url = url;
        logger.info("Initialized page with URL: {}", url);
    }

    /**
     * Конструктор страницы с указанием URL и компонента, представляющего главный элемент.
     *
     * @param url          адрес страницы.
     * @param mainElement  главный компонент страницы.
     */
    protected BasePage(String url, Component mainElement) {
        super(mainElement.getElement());
        this.url = url;
        logger.info("Initialized page with URL: {} and main element: {}", url, mainElement);
    }

    /**
     * Открывает страницу по заданному URL и ожидает её полной загрузки.
     */
    public void openPage() {
        logger.info("Opening page: {}", url);
        Selenide.open(url);
        waitForPageToLoad();
    }

    /**
     * Обновляет текущую страницу и ожидает её полной загрузки.
     */
    public void refreshPage() {
        logger.info("Refreshing the page");
        Selenide.refresh();
        waitForPageToLoad();
    }

    /**
     * Ожидает, что главный элемент страницы станет видимым.
     * Этот метод используется как индикатор полной загрузки страницы.
     */
    public void waitForPageToLoad() {
        logger.info("Waiting for the main element to become visible...");
        element.shouldBe(visible, Duration.ofSeconds(10));
        logger.info("Page is loaded successfully.");
    }
}
