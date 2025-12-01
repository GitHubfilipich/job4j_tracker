package ru.job4j.tracker;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.List;
import java.util.Objects;

/**
 * Простая обёртка клиента на RestTemplate для REST-сервера Tracker.
 * Использует JSON (Jackson) по умолчанию в Spring.
 */
public class RestClient {
    private final RestTemplate rest;
    private final String baseUrl;

    public RestClient(String baseUrl) {
        this(baseUrl, 5_000, 10_000); // таймауты: connect=5s, read=10s
    }

    public RestClient(String baseUrl, int connectTimeoutMillis, int readTimeoutMillis) {
        Objects.requireNonNull(baseUrl, "baseUrl must not be null");
        this.baseUrl = baseUrl.endsWith("/") ? baseUrl.substring(0, baseUrl.length() - 1) : baseUrl;
        SimpleClientHttpRequestFactory rf = new SimpleClientHttpRequestFactory();
        rf.setConnectTimeout(connectTimeoutMillis);
        rf.setReadTimeout(readTimeoutMillis);
        this.rest = new RestTemplate(rf);
    }

    private HttpHeaders jsonHeaders() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        return headers;
    }

    public List<Item> getAll() {
        try {
            ResponseEntity<List<Item>> resp = rest.exchange(
                    URI.create(baseUrl + "/items"),
                    HttpMethod.GET,
                    null,
                    new ParameterizedTypeReference<>() {
                    }
            );
            return resp.getBody();
        } catch (RestClientException e) {
            throw new RuntimeException("Failed to get all items", e);
        }
    }

    public Item getById(int id) {
        try {
            return rest.getForObject(baseUrl + "/items/{id}", Item.class, id);
        } catch (RestClientException e) {
            throw new RuntimeException("Failed to get item by id=" + id, e);
        }
    }

    public Item create(Item item) {
        try {
            HttpEntity<Item> request = new HttpEntity<>(item, jsonHeaders());
            ResponseEntity<Item> resp = rest.postForEntity(baseUrl + "/items", request, Item.class);
            return resp.getBody();
        } catch (RestClientException e) {
            throw new RuntimeException("Failed to create item", e);
        }
    }

    public boolean update(int id, Item item) {
        try {
            HttpEntity<Item> request = new HttpEntity<>(item, jsonHeaders());
            ResponseEntity<Item> resp = rest.exchange(baseUrl + "/items/{id}", HttpMethod.PUT, request, Item.class, id);
            return resp.getStatusCode().is2xxSuccessful();
        } catch (RestClientException e) {
            throw new RuntimeException("Failed to update item id=" + id, e);
        }
    }

    public boolean delete(int id) {
        try {
            ResponseEntity<Void> resp = rest.exchange(baseUrl + "/items/{id}", HttpMethod.DELETE, null, Void.class, id);
            return resp.getStatusCode().is2xxSuccessful();
        } catch (RestClientException e) {
            throw new RuntimeException("Failed to delete item id=" + id, e);
        }
    }

    public List<Item> findByName(String name) {
        try {
            ResponseEntity<List<Item>> resp = rest.exchange(
                    URI.create(baseUrl + "/items/search?name=" + encode(name)),
                    HttpMethod.GET,
                    null,
                    new ParameterizedTypeReference<>() {
                    }
            );
            return resp.getBody();
        } catch (RestClientException e) {
            throw new RuntimeException("Failed to find items by name=" + name, e);
        }
    }

    private String encode(String s) {
        // простая кодировка для query param (можно заменить на URLEncoder при необходимости)
        return s == null ? "" : s.replace(" ", "%20");
    }

    // Пример использования (main для быстрой проверки)
    public static void main(String[] args) {
        RestClient client = new RestClient("http://localhost:7000");

         /*GET all*/
        System.out.println("All items: " + client.getAll());

         /*create*/
        Item newItem = new Item();
        newItem.setName("rest-created " + System.currentTimeMillis());
         /*POST create*/
        Item created = client.create(newItem);
        System.out.println("Created: " + created);

    }
}
