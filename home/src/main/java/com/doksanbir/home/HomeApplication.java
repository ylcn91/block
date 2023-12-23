package com.doksanbir.home;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClient;

@SpringBootApplication
public class HomeApplication {

    public static void main(String[] args) {
        SpringApplication.run(HomeApplication.class, args);
    }

}

@Slf4j
@RestController
class HomeController {

    private final RestClient restClient;

    HomeController(RestClient.Builder builder) {
        this.restClient = builder.baseUrl("http://localhost:8085").build();
    }


    @GetMapping("/block/{seconds}")
    public String home(@PathVariable int seconds) {

        ResponseEntity<Void> response =
                restClient
                        .get()
                        .uri("/block/{seconds}", seconds)
                        .retrieve()
                        .toBodilessEntity();

        log.info("Block for {} seconds, response status: {} on thread name: {}", seconds, response.getStatusCode(), Thread.currentThread());

        return Thread.currentThread().getName();
    }
}