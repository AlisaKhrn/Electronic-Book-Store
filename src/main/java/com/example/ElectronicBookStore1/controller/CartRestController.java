package com.example.ElectronicBookStore1.controller;

import com.example.ElectronicBookStore1.model.Cart;
import com.example.ElectronicBookStore1.services.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CartRestController {
    private final CartService cartService;

    @Autowired
    public CartRestController(CartService cartService) {
        this.cartService = cartService;
    }

    @PostMapping("/addToCart")
    public String addToCart(Cart cart){
        cartService.saveCart(cart);
        return "Товар добавлен в корзину";
    }

}