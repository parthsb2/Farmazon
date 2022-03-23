package com.farmers.farmazon.Controllers;

import com.farmers.farmazon.Models.Cart;
import com.farmers.farmazon.Models.ProductLine;
import com.farmers.farmazon.Models.User;
import com.farmers.farmazon.Services.CartService;
import com.farmers.farmazon.Services.ProductLineService;
import com.farmers.farmazon.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@CrossOrigin("*")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private CartService cartService;

    @Autowired
    private ProductLineService productLineService;

    @PostMapping("/users")
    public User post(@RequestBody User user) {

        Cart newCart = new Cart();
        Cart savedCart = cartService.createCart(newCart);
        user.setCart(savedCart);
        return userService.createUser(user);
    }

    @GetMapping("/users")
    public Iterable<User> getUsers() {
        return userService.getUsers();
    }

    @GetMapping("/users/{id}")
    public User getUserById(@PathVariable Integer id) {
        return userService.getUserById(id);
    }

    @PutMapping("/users/{userId}/changecredit")
    public User put(@PathVariable Integer userId, @RequestBody Integer credit) {
        Optional<User> optionalUser = userService.findById(userId);
        if (optionalUser.isPresent()) {
            User updatedUser = optionalUser.get();
            Integer oldCredit = updatedUser.getCredit();
            Integer newCredit = oldCredit + credit;
            if (newCredit < 0){
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, String.format("User id: %s credit cannot be negative.", userId));
            } else {
                updatedUser.setCredit(newCredit);
                return userService.createUser(updatedUser);
            }

        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, String.format("No user with id %s found", userId));
        }



    }

    @PutMapping("/checkout/{userId}")
    public void put(@PathVariable Integer userId){
        List<ProductLine> productLines = productLineService.getProductLines();
        List<ProductLine> productLinesInCart = productLines.stream()
                .filter(line -> Objects.equals(line.getUserId(), userId) && Objects.equals(line.getInCart(), true))
                .collect(Collectors.toList());
        List<ProductLine> productLinesNotInCart = productLines.stream()
                .filter(line -> Objects.equals(line.getUserId(), userId) && Objects.equals(line.getInCart(), false))
                .collect(Collectors.toList());
        for (ProductLine productLineInCart: productLinesInCart) {
            for (ProductLine productLineNotInCart: productLinesNotInCart) {
                if (Objects.equals(productLineInCart.getProductName(), productLineNotInCart.getProductName())) {

                    Integer totalQuantity = productLineNotInCart.getQuantity() + productLineInCart.getQuantity();
                    productLineNotInCart.setQuantity(totalQuantity);
                    productLineService.deleteById(productLineInCart.getId());
                    productLineService.createProductLine(productLineNotInCart);
                }
            }
        }

        List<ProductLine> productLines2 = productLineService.getProductLines();
        List<ProductLine> productLinesInCart1 = productLines2.stream()
                .filter(line -> Objects.equals(line.getUserId(), userId) && Objects.equals(line.getInCart(), true))
                .collect(Collectors.toList());
        for (ProductLine productLineInCart1: productLinesInCart1) {

            productLineInCart1.setInCart(false);
            productLineInCart1.setCart(null);
            productLineService.createProductLine(productLineInCart1);
        }

    }

}
