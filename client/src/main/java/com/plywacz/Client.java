package com.plywacz;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;

@Component
class Client {
    public static final String API_PRODUCTS = "api/products";
    private final WebClient webClient;

    Client(@Value("${serverUrl}") String serverUrl) {
        webClient = WebClient.create(serverUrl);
    }

    Flux<ProductDto> allProducts() {
        return webClient.get()
                .uri(API_PRODUCTS)
                .retrieve()
                .bodyToFlux(ProductDto.class);
    }
}
