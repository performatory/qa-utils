package ru.qa.api.client.enums;

/**
 * Методы для работы с HTTP-протоколом
 */
public enum HttpMethod implements Method{
    GET("GET"),
    POST("POST"),
    PUT("PUT"),
    DELETE("DELETE");

    final String name;

    HttpMethod(String name) {
        this.name = name;
    }

    public String toString() {return name;}
}
