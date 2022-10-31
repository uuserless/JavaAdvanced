package com.example.clientservice.service;

import com.example.clientservice.connector.BookServiceConnector;
import com.example.clientservice.model.Book;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Slf4j
@Service
public class ClientService {

    private final RestTemplate restTemplate;
    private final BookServiceConnector connector;

    public ClientService(RestTemplate restTemplate, BookServiceConnector connector) {
        this.restTemplate = restTemplate;
        this.connector = connector;
    }
    @Cacheable(value = "book")
    @HystrixCommand(fallbackMethod = "failed")
    public String getAllBooksList() {
        return connector.getAllBooksList();
    }

    @Cacheable(value = "book")
    public String data() {
        String response = restTemplate.getForObject("http://book-service/data", String.class);
        return response;
    }

    public String failed() {
        String error = "Service is not available now. Please try again later";
        log.info(error);
        return error;
    }

}
