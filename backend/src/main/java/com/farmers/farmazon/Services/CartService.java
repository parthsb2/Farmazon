package com.farmers.farmazon.Services;

import com.farmers.farmazon.Models.Cart;
import com.farmers.farmazon.Repos.CartRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CartService {

    @Autowired
    private CartRepo cartRepo;

    public Cart createCart(Cart cart) {
        return cartRepo.save(cart);
    }

    public Cart updateCart(Integer userid, Cart cart) {
        Cart updatedCart = cartRepo.findById(userid).get();
        updatedCart.setProductLines(cart.getProductLines());
        return cartRepo.save(updatedCart);
    }

    public Cart getCartById(Integer id) {
        return cartRepo.findById(id).get();
    }
}
