package com.vedant.Ecommerce.services;

import com.vedant.Ecommerce.beans.Profile;
import com.vedant.Ecommerce.beans.User;
import com.vedant.Ecommerce.repos.ProfileRepo;
import com.vedant.Ecommerce.repos.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService implements UserServiceInterface {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private ProfileRepo profileRepo;

    @Override
    public User createUserWithProfile(User user, Profile profile) {
        profile.setUser(user);
        user.setProfile(profile);
        return userRepo.save(user);
    }

    @Override
    public User getUserById(int id) {
        return userRepo.findById(id).orElse(null);
    }
}
