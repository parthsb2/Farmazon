package com.farmers.farmazon.Services;

import com.farmers.farmazon.Models.User;
import com.farmers.farmazon.Repos.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepo userRepo;

    public User createUser(User user){
        return userRepo.save(user);
    }

    public Iterable<User> getUsers() {
        return userRepo.findAll();
    }

    public User getUserById(Integer id) {
        return userRepo.findById(id).get();
    }

    public Optional<User> findById(Integer id) {
        return userRepo.findById(id);
    }
}
