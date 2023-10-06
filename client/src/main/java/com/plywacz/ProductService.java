package com.plywacz;

import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.util.Random;

@Service
class ProductService {
    private final Client client;

    ProductService(final Client client) {
        this.client = client;
    }

    Flux<ProcessedProductDto> getProcessedProducts() {
        return client.allProducts().map(ProductService::processProducts);
    }

    private static ProcessedProductDto processProducts(final ProductDto productDto) {
        return new ProcessedProductDto(productDto.name(), "calculatedPayload: " + new Random().nextDouble());
    }
}
