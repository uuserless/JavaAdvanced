package com.example.controller;

import com.example.model.Book;
import com.example.service.BooksService;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/")
public class BooksController {

    private final Environment env;
    private final BooksService booksService;

    public BooksController(Environment env, BooksService booksService) {
        this.env = env;
        this.booksService = booksService;
    }


    @RequestMapping("/")
    public String home() {
        String home = "Book-Service running at port: " + env.getProperty("local.server.port");
        log.info(home);
        return home;
    }

    @GetMapping(path = "/show")
    public List<Book> getAllBooksList() {
        log.info("Get data from database (Feign Client on client-service side)");
        return booksService.findAllBooks();
    }

    @GetMapping("/data")
    public List<Book> data() {
        log.info("Get data from database (RestTemplate on client-service side)");
        return booksService.findAllBooks();
    }
}