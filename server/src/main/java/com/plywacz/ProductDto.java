package com.plywacz;

import jakarta.validation.constraints.NotBlank;

record ProductDto(@NotBlank String name) {
}
