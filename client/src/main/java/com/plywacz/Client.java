package com.plywacz;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;

@Log4j2
@Component
class Client {
    public static final String API_PRODUCTS = "api/products";
    private final WebClient webClient;

    private final String serverUrl;

    Client(@Value("${server.url}") String serverUrl) {
        this.serverUrl = serverUrl;
        webClient = WebClient.create(serverUrl);
    }

    Flux<ProductDto> allProducts() {
        log.info("GET -> " + serverUrl + API_PRODUCTS);

        return webClient.get()
                .uri(API_PRODUCTS)
                .retrieve()
                .bodyToFlux(ProductDto.class);
    }
}
