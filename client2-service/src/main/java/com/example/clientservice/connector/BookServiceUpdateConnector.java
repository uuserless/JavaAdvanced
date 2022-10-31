package com.example.clientservice.connector;

import com.example.clientservice.config.FeignConfig;
import com.example.clientservice.model.Book;
import java.util.List;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(
        name = "book-service-update",
        url = "${book-service-update.url}",
        configuration = FeignConfig.class
)
public interface BookServiceUpdateConnector {

    @GetMapping(path = "/show")
    List<Book> getAllBooksList();
}
