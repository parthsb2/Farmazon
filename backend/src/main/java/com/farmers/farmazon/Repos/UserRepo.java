package com.farmers.farmazon.Repos;

import com.farmers.farmazon.Models.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepo extends CrudRepository <User, Integer>{}