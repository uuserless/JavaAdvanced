package com.example.service;

import com.example.model.Book;
import java.util.function.Consumer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class StoreBookService {

    @Bean
    public Consumer<Book> acceptBook() {
        return book -> {
            log.info("-----Book with id : " + book.getId() + " was accept to store!-----");
        };
    }

}
