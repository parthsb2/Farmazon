package com.farmers.farmazon.Repos;

import com.farmers.farmazon.Models.Cart;
import org.springframework.data.repository.CrudRepository;

public interface CartRepo extends CrudRepository <Cart, Integer>{}