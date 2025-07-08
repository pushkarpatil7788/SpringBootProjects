package com.infosys.EcommerceSystem.services;

import com.infosys.EcommerceSystem.beans.User;
import java.util.List;

public interface UserServiceInterface {
    void addUser(User user);
    List<User> getAllUsers();
    User getUserById(int userId);
    void updateUser(int userId, User updatedUser);
    void deleteUser(int userId);
    User getUserWithProfileAndOrders(int userId);

}
