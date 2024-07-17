package com.example.ElectronicBookStore1.services;


import com.example.ElectronicBookStore1.model.Cart;
import com.example.ElectronicBookStore1.dao.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class CartService {
    private final CartRepository cartRepository;
    @Autowired
    public CartService(CartRepository cartRepository) {
        this.cartRepository = cartRepository;
    }


    @Transactional
    public void saveCart(Cart cart) {
        cartRepository.save(cart);
    }
}




