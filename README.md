# Amino Dating — Backend Service

**Amino Dating** — это бэкенд-сервис для современного приложения знакомств, разработанный на фреймворке **Spring Boot** и **Java 21**. Проект предоставляет REST API для регистрации пользователей, создания анкет, интеллектуального мэтчинга, отправки лайков и обмена сообщениями в реальном времени.

## Технологический стек

* **Язык программирования:** Java 21 (использование Record-классов, Pattern Matching, Virtual Threads)
* **Фреймворк:** Spring Boot 3.x (Spring Security, Spring Data JPA, Spring WebSocket)
* **База данных:** PostgreSQL (хранение пользователей, анкет и связей)
* **Кэширование и брокер:** Redis (хранение сессий, кэширование геопозиций, WebSocket-сессии)
* **Миграция БД:** Liquibase / Flyway
* **Тестирование:** JUnit 5, Testcontainers, Mockito
* **Сборка проекта:** Gradle (или Maven)
* **Документация:** OpenAPI / Swagger UI

## Основной функционал (Features)

- 🔐 **Аутентификация и авторизация:** Безопасный вход через JWT, поддержка OAuth2 (Google/Apple), валидация почты.
- 👤 **Профили пользователей:** Загрузка фотографий, указание интересов, возраста, геопозиции и гибкие настройки приватности.
- 🎯 **Система Мэтчинга (Алгоритм знакомств):** Поиск людей поблизости (геолокация), общим интересам и возрастным фильтрам.
- 💬 **Чат в реальном времени:** Мгновенный обмен сообщениями между взаимными лайками (мэтчами) через WebSockets.
- 🔔 **Уведомления:** Push-уведомления и WebSocket-нотификации о новых лайках и сообщениях.

## 🛠️ Архитектура проекта

Проект спроектирован по принципам **Layered Architecture (Слоистая архитектура)**:
1. **Controller (API Layer):** Обработка HTTP-запросов, валидация входящих DTO, Swagger-аннотации.
2. **Service (Business Logic Layer):** Основная бизнес-логика приложения, обработка мэтчей, интеграции.
3. **Repository (Data Access Layer):** Интерфейсы Spring Data JPA для взаимодействия с PostgreSQL.
4. **Model/Entity:** Доменные модели приложения.

## 🔧 Запуск проекта локально

### Требования
* **JDK 21**
* **Docker & Docker Compose** (для запуска PostgreSQL и Redis)

### Шаги для запуска

1. **Клонируйте репозиторий:**
   ```bash
   git clone https://github.com/your-username/amino-dating-backend.git
   cd amino-dating-backend
   ```

2. **Запустите инфраструктуру (БД и Кэш):**
   ```bash
   docker-compose up -d
   ```

3. **Настройте окружение (`.env` или `application.yml`):**
   Убедитесь, что параметры подключения к БД соответствуют настройкам в `src/main/resources/application.yml`.

4. **Соберите и запустите приложение:**
   * При использовании **Gradle**:
     ```bash
     ./gradlew bootRun
     ```
   * При использовании **Maven**:
     ```bash
     ./mvnw spring-boot:run
     ```

Приложение будет доступно по адресу: `http://localhost:8080`

## 📖 API Документация

После запуска приложения интерактивная документация Swagger UI доступна по адресу:
`http://localhost:8080/swagger-ui/index.html`

## 📂 Структура репозитория

```text
src/
├── main/
│   ├── java/com/amino/dating/
│   │   ├── config/          # Конфигурационные классы (Security, WebSocket, Redis)
│   │   ├── controller/      # REST Контроллеры (Endpoints)
│   │   ├── dto/             # Объект передачи данных (Request/Response DTOs)
│   │   ├── exception/       # Глобальная обработка ошибок
│   │   ├── model/           # Сущности базы данных (Entities)
│   │   ├── repository/      # Репозитории (Spring Data JPA)
│   │   └── service/         # Бизнес-логика приложения
│   └── resources/
│       ├── db/changelog/    # Скрипты миграции БД
│       └── application.yml  # Конфигурация приложения
```

