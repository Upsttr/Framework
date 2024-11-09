
# Фреймворк для Автоматизированного Тестирования

Этот проект представляет собой фреймворк для автоматизированного тестирования с использованием Java, Selenide, RestAssured и Allure для отчетности. Он поддерживает выполнение UI, API и тестов баз данных.

## Структура Проекта

- `src/main/java`: Конфигурационные файлы и многократно используемые методы
- `github` : Конфигурация CI
  - `config`: Содержит конфигурационные файлы, такие как config.properties
  - `utils`: Содержит вспомогательные методы
  - `db`: Содержит класс для взаимодействия с базой данных
- `src/test/java`: Тестовые классы, организованные по типам тестов
  - `api`: Содержит классы для API тестов с использованием RestAssured
  - `db`: Содержит классы для тестирования базы данных с использованием JDBC
  - `ui`: Содержит классы для UI тестов с использованием Selenide

## Требования

- Java JDK 8+
- Maven 3.6+
- Данные для подключения к базе данных (настраиваются в конфигурации)

## Настройка

1. Клонируйте репозиторий.
2. Перейдите в директорию проекта.
3. Соберите проект:

   ```bash
   mvn clean install
   ```

## Запуск Тестов

Для запуска всех тестов из командной строки:

```bash
mvn test
```

## Создание отчета Allure

1. Запустите тесты, чтобы получить результаты для Allure.
2. Сгенерируйте отчет Allure:

   ```bash
    allure serve
   ```

## Конфигурация

- Обновите настройки базы данных и среды в `src/main/java/config/config.properties`.

## Автор

Вадим Кирилюк