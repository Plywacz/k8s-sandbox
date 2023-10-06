package com.plywacz;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/api/client")
class Controller {
    private final ProductService productService;

    Controller(final ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    Flux<ProcessedProductDto> hello() {
        return productService.processUsers();
    }

}
