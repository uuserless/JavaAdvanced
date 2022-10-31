package com.example.clientservice.connector;

import com.example.clientservice.config.FeignConfig;
import com.example.clientservice.model.Book;
import java.util.List;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(
        name = "book-service",
        url = "${book-service.url}",
        configuration = FeignConfig.class
)
public interface BookServiceConnector {

    @GetMapping(path = "/show")
    String getAllBooksList();
}
