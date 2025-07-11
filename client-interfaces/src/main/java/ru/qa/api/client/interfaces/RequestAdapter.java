package ru.qa.api.client.interfaces;

public interface RequestAdapter<T> {

    /**
     * Подготовить запрос для выбранного клиента
     */
    T performRequest();
}
