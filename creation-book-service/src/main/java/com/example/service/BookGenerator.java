package com.example.service;

import com.example.model.Book;
import java.util.Random;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
public class BookGenerator {

    private final Random random = new Random();

    public Book createBook() {
        int id = random.ints(1, 1000).findFirst().getAsInt();
        return new Book(id, "Book №" + id,
                "Story about number " + id,
                "UNCHECKED");
    }
}
