package com.plywacz;

import org.springframework.data.repository.CrudRepository;

interface UserRepo extends CrudRepository<Product, Long> {
}
