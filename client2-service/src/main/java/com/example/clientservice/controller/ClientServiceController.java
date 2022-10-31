package com.example.clientservice.controller;


import com.example.clientservice.model.Book;
import com.example.clientservice.service.Client2Service;
import java.util.List;
import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class ClientServiceController {

    Logger logger = Logger.getLogger(ClientServiceController.class.getName());
    private final Client2Service service;

    public ClientServiceController(Client2Service service) {
        this.service = service;
    }

    @GetMapping("/getAllBooksByFeignClient")
    public List<Book> getAllData() {
        logger.info("Calling through Feign Client");
        return service.getAllBooksList();
    }

}
