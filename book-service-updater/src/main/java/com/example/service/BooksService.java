package com.example.service;

import com.example.model.Book;
import com.example.repository.BooksRepository;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class BooksService {

    private final BooksRepository booksRepository;

    public BooksService(BooksRepository booksRepository) {
        this.booksRepository = booksRepository;
    }

    public List<Book> findAllBooks() {
        return booksRepository.findAll();
    }
}