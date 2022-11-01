package com.example.service;

import com.example.model.Book;
import java.util.function.Supplier;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@AllArgsConstructor
public class CreateBookService {

    private BookGenerator bookGen;

    @Bean
    @Scope("prototype")
    public Supplier<Book> sendBook() {
        Book book = bookGen.createBook();
        log.info("-----Book with id : " + book.getId() + " was created!-----");
        return () -> book;
    }

}
