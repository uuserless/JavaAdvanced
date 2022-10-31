package com.example.clientservice.controller;


import com.example.clientservice.model.Book;
import com.example.clientservice.service.ClientService;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/")
public class ClientServiceController {

    private final Environment env;
    private final ClientService service;

    public ClientServiceController(Environment env, ClientService service) {
        this.env = env;
        this.service = service;
    }

    @RequestMapping("/")
    public String home() {
        String home = "Client-Service running at port: " + env.getProperty("local.server.port");
        log.info(home);
        return home;
    }

    @GetMapping("/getAllBooksByFeignClient")
    public String getAllBooks() {
        log.info("Calling through Feign Client");
        return service.getAllBooksList();
    }

    @GetMapping("/getAllBooksByRestTemplate")
    public String data() {
        log.info("Calling through RestTemplate");
        return service.data();
    }


}
