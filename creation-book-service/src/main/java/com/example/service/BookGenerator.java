package com.example.service;

import com.example.model.Book;
import java.util.Random;

public class BookGenerator {

    private Random random = new Random();

    public Book createBook() {
        int id = random.ints(1, 100).findFirst().getAsInt();
        return new Book(id, "Book №" + id,
                "Story about number " + id,
                "UNCHECKED");
    }
}
