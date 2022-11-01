package com.example.service;

import com.example.model.Book;
import java.util.function.Function;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class CheckBookService {

    @Bean
    public Function<Book, Book> checkBook() {
        return book -> {
            book.setStatus("CHECKED");
            log.info("-----Book with id : " + book.getId() + " changed status to <<CHECKED>>!-----");
            return book;
        };
    }

}
