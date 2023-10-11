package com.plywacz;

import com.google.common.collect.Lists;
import jakarta.transaction.Transactional;
import lombok.val;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private final UserRepo userRepo;

    public UserService(final UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    List<ProductDto> getAllUsers() {
        return Lists.newArrayList(userRepo.findAll())
                .stream()
                .map(UserService::toUserDto)
                .toList();
    }

    @Transactional(rollbackOn = Exception.class)
    ProductDto createUser(final ProductDto productDto) {
        val savedUser = userRepo.save(toUser(productDto));
        return toUserDto(savedUser);
    }

    private static Product toUser(final ProductDto productDto) {
        return new Product.ProductBuilder().name(productDto.name()).build();
    }

    private static ProductDto toUserDto(final Product product) {
        return new ProductDto(product.getName());
    }
}
