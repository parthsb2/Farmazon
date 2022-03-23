package com.farmers.farmazon.Controllers;

import com.farmers.farmazon.Models.Product;
import com.farmers.farmazon.Services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/products")
    public Iterable<Product> getProducts() {
        return productService.getProducts();
    }

    @GetMapping("/products/{id}")
    public Product getProductsById(@PathVariable Integer id) {
        return productService.getProductById(id);
    }
}
