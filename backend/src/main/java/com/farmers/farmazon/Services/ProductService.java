package com.farmers.farmazon.Services;

import com.farmers.farmazon.Models.Product;
import com.farmers.farmazon.Repos.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    @Autowired
    private ProductRepo productRepo;

    public Iterable<Product> getProducts() {
        return productRepo.findAll();
    }

    public Product getProductById(Integer id) {
        return productRepo.findById(id).get();
    }

}
