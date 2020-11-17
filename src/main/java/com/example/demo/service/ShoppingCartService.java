package com.example.demo.service;

import com.example.demo.model.Person;
import com.example.demo.model.ShoppingCart;

import java.util.List;

public interface ShoppingCartService {
    ShoppingCart addProductToShoppingCart(Long userId, Long productId);
    ShoppingCart removeProductFromShoppingCart(Long userId, Long productId);
    List<ShoppingCart> findAllShoppingCarts();
    List<ShoppingCart> getCurrentCarts(Person person);
}
