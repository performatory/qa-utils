package ru.qa.api.client.interfaces;

/**
 * Действия, которые можно выполнить над ответом на запрос
 */
public interface ResponseActions {
    /**
     * "Распарсить" текстовое тело ответа (если оно текстовое)
     * @param tClass - сущность, на которую надо парсить тело ответа
     * @return - объект класса tClass с данными из тела ответа
     */
    <T> T parseBodyAs(Class<T> tClass);

    /**
     * Получить значение из поля тела ответа, найденного по пути
     * @param path - путь до ключа в теле ответа
     * @return - значение из поля ответа
     */
    <T> T getValueFromBodyByPath(String path);

    /**
     * Проверить код ответа на соответствие ожидаемому коду. Если ожидаемое значение не соответствует действительному,
     * то тест упадёт по аналогии с ошибкой из Assertions.assertEquals() в JUnit5 (использован аналогичный Error)
     * @param expectedStatusCode - ожидаемый статус - код
     * @return - объект с ответом на запрос
     */
    ResponseActions shouldBeStatusCode(int expectedStatusCode);

    /**
     * Получить статус - код ответа на запрос
     */
    int getStatusCode();

    /**
     * @return - тело запроса в строковом представлении
     */
    String getBody();
}
