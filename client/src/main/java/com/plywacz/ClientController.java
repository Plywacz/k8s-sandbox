package com.plywacz;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/api/processedProducts")
class ClientController {
    private final ProductService productService;

    ClientController(final ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    Flux<ProcessedProductDto> processedProducts() {
        return productService.getProcessedProducts();
    }

}
