package com.example.clientservice.connector.fallback;

import com.example.clientservice.connector.BookServiceConnector;
import com.example.clientservice.model.Book;
import com.example.clientservice.service.Client2Service;
import java.util.List;
import org.springframework.stereotype.Component;

@Component
public class BookServiceFallback implements BookServiceConnector {

    private final Client2Service service;

    public BookServiceFallback(Client2Service service) {
        this.service = service;
    }

    @Override
    public List<Book> getAllBooksList() {
        return service.getAllBooksList();
    }
}
