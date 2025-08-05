package ru.qa.api.client.interfaces;

public interface RequestAdapter {

    /**
     * Подготовить запрос для выбранного клиента
     */
    <T> T performRequest();
}
