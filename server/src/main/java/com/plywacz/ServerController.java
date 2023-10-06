package com.plywacz;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
class ServerController {
    private final UserService userService;

    ServerController(final UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    List<ProductDto> allUsers() {
        return userService.getAllUsers();
    }

    @PostMapping
    ProductDto createUser(@RequestBody ProductDto productDto) {
        return userService.createUser(productDto);
    }
}
