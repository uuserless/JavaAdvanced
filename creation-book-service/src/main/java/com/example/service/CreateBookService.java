package com.example.service;

import com.example.model.Book;
import java.util.function.Supplier;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class CreateBookService {

    private BookGenerator bookGen = new BookGenerator();

    @Bean
    public Supplier<Book> sendBook() {
        Book book = bookGen.createBook();
        log.info("-----Book with id : " + book.getId() + " was created!-----");
        return () -> book;
    }

}
