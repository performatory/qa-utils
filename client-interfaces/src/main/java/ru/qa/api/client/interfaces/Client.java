package ru.qa.api.client.interfaces;

/**
 * Основной интерфейс клиента, для выполнения подготовленных запросов
 */
public interface Client {
    /**
     * Выполнить переданный запрос
     * @param request - запрос со всей необходимой информацией для его выполнения {@link Request}.
     *                Можно сформировать либо через сеттеры
     * @return - полученный ответ от сервиса на отправленный запрос
     */
    ResponseActions execute(Request request);
}
