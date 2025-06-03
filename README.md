# Фреймворк определения компонентов для ui-тестирования

Фреймворк находится в каталоге ui-tesring-framework/framework.

* В данный файл внесите свои данные для входа в ЛК ЛЭТИ и Moodle для запуска тестов.
\resources\config.properties

## Запуск тестов
* Для запуска всех тестов: mvn test
* Для запуска тестов только для сайта ЛЭТИ: mvn test -Dgroups=leti
* Для запуска тестов только для сайта hh.ru: mvn test -Dgroups=hh
* Для запуска тестов только для сайта Moodle: mvn test -Dgroups=moodle