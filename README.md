# Фреймворк определения компонентов для ui-тестирования

## Описание
* Фреймворк содержит базовае комопненты: кнопка, поле ввода, гиперссылка, чекбокс и радиокнопка

* Фреймворк находится в каталоге ui-tesring-framework/framework.

* В данный файл внесите свои данные для входа в ЛК ЛЭТИ и Moodle для запуска тестов.
\resources\config.properties

## Подключение
Добавьте зависимость в `pom.xml`:

```xml
<dependency>
    <groupId>org.example</groupId>
    <artifactId>framework</artifactId>
    <version>1.0-SNAPSHOT</version>
</dependency>
```

## Пример инициализации элементов страницы

```java
Button loginButton = Button.byClass("login-btn");
TextInput username = TextInput.byName("username");
TextInput input = TextInput.byAttribute("data-qa", "search-input");
```

## Пример создания страницы

```java
public class LoginPage extends BasePage {
    public TextInput username = TextInput.byId("username");
    public TextInput password = TextInput.byId("password");
    public Button loginBtn = Button.byText("Войти");

    public LoginPage() {
        super("https://example.com/login", "//form[@id='login-form']");
    }
}
```

## Пример расширения. Добавление собственного метода определения компонентов

```java
public class CustomButton extends Button {
    public static Button byDataQa(String value) {
        return new Button(buildByAttribute("data-qa", value));
    }
}
```

## Запуск тестов
* Для запуска всех тестов: mvn clean test
* Для запуска тестов только для сайта ЛЭТИ: mvn clean test -Dgroups=leti
* Для запуска тестов только для сайта hh.ru: mvn clean test -Dgroups=hh
* Для запуска тестов только для сайта Moodle: mvn clean test -Dgroups=moodle