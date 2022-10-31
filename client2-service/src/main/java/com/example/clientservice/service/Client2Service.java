package com.example.clientservice.service;

import com.example.clientservice.connector.BookServiceConnector;
import com.example.clientservice.connector.BookServiceUpdateConnector;
import com.example.clientservice.model.Book;
import java.util.List;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class Client2Service {

    private static final Logger logger = Logger.getLogger(Client2Service.class.getName());
    private BookServiceConnector connector;
    private BookServiceUpdateConnector fallback;

    public Client2Service(
            @Qualifier("com.example.clientservice.connector.BookServiceConnector") BookServiceConnector connector,
            BookServiceUpdateConnector fallback) {
        this.connector = connector;
        this.fallback = fallback;
    }

    public List<Book> getAllBooksList() {
        return connector.getAllBooksList();
    }

    public List<Book> getAllBooksListFromFallback() {
        return fallback.getAllBooksList();
    }

}
