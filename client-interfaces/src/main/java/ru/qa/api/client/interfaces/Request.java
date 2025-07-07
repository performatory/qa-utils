package ru.qa.api.client.interfaces;

import ru.qa.api.client.enums.Method;

import java.util.List;
import java.util.Map;

/**
 * Контракт для подготовки запроса к тестируемому сервису
 */
public interface Request {
    /**
     * Установить url для отправки запроса
     * @return - объект запроса с установленной URL
     */
    Request setUrl(String url);

    /**
     * Добавить параметры запроса в URL
     * В результате выполнения метода в моменты выполнения запроса клиентом
     * к установленной URL будет добавлен знак вопроса `?` и после него
     * параметры, разделённые между собой знаком `&`, каждый элемент объекта Map
     * будет записан следующим образом: ключ=значение
     * Пример:
     * https://www.somehost.com/wiki/URL?key1=value1&key2=value2&key3=value3
     * @return - объект запроса с установленными параметрами запроса
     */
    Request setQueries(Map<String, String> queries);

    /**
     * Вставить тело запроса в текстовом виде
     * @return - объект запроса с установленным телом запроса
     */
    Request setStringBody(String body);

    /**
     * Вставить тело запроса в виде объекта
     * @return - объект запроса с установленным телом запроса
     */
    Request setBody(Object body);

    /**
     * Установить метод запроса
     * @param method - объект enum {@link Method}
     * @return - объект запроса с установленным методом запроса
     */
    Request setMethod(Method method);

    /**
     * Добавить заголовки к запросу, не удаляя те, что уже были добавлены ранее
     * @param headers - список с заголовками
     * @return - объект запроса с добавленными заголовками
     */
    Request addHeaders(List<Header> headers);

    /**
     * Добавить заголовок к запросу, не удаляя те, что уже были добавлены ранее
     * @param key - ключ заголовка
     * @param value - значение заголовка
     * @return - объект запроса с добавленным заголовком
     */
    Request addHeader(String key, String value);

    /**
     * Получить значение URL из объекта запроса в строковом формате
     */
    String getUrl();

    /**
     * @return - Параметры запроса
     */
    Map<String, String> getQueries();
}
