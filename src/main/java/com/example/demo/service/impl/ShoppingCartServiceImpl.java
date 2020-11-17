package com.example.demo.service.impl;

import com.example.demo.model.Person;
import com.example.demo.model.Product;
import com.example.demo.model.ShoppingCart;
import com.example.demo.model.exceptions.ProductIsAlreadyInShoppingCartException;
import com.example.demo.repository.ShoppingCartRepository;
import com.example.demo.service.ProductService;
import com.example.demo.service.ShoppingCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ShoppingCartServiceImpl implements ShoppingCartService {
    @Autowired
    ProductService productService;
    @Autowired
    ShoppingCartRepository shoppingCartRepository;

    @Override
    public ShoppingCart addProductToShoppingCart(Long userId, Long productId) {
        ShoppingCart shoppingCart = this.shoppingCartRepository.getOne(userId);
        Product product = this.productService.findProductbyId(productId);
        for (Product p : shoppingCart.getProduct()) {
            if(p.getId().equals(productId)){
                throw new ProductIsAlreadyInShoppingCartException(product.getName());
            }

        }
        shoppingCart.getProduct().add(product);
        return this.shoppingCartRepository.save(shoppingCart);
    }

    @Override
    public ShoppingCart removeProductFromShoppingCart(Long userId, Long productId) {
        return null;
    }

    @Override
    public List<ShoppingCart> findAllShoppingCarts() {
        return this.shoppingCartRepository.findAll();
    }

    @Override
    public List<ShoppingCart> getCurrentCarts(Person person) {
        return null;
    }
}
