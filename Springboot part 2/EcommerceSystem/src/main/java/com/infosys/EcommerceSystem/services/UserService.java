package com.infosys.EcommerceSystem.services;

import com.infosys.EcommerceSystem.beans.User;
import com.infosys.EcommerceSystem.repos.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements UserServiceInterface {

    @Autowired
    private UserRepo userRepo;

    @Override
    public void addUser(User user) {
        userRepo.save(user);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepo.findAll();
    }

    @Override
    public User getUserById(int userId) {
        return userRepo.findById(userId).orElse(null);
    }

    @Override
    public void updateUser(int userId, User updatedUser) {
        User existing = userRepo.findById(userId).orElse(null);
        if (existing != null) {
            existing.setUsername(updatedUser.getUsername());
            existing.setUserPassword(updatedUser.getUserPassword());
            userRepo.save(existing);
        }
    }

    @Override
    public void deleteUser(int userId) {
        userRepo.deleteById(userId);
    }
    @Override
    public User getUserWithProfileAndOrders(int userId) {
        return userRepo.findById(userId).orElse(null);
    }

}
