package com.farmers.farmazon.Repos;

import com.farmers.farmazon.Models.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepo extends CrudRepository <Product, Integer>{}
