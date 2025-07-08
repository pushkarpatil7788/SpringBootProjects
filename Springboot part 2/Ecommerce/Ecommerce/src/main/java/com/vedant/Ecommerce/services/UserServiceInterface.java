package com.vedant.Ecommerce.services;

import com.vedant.Ecommerce.beans.Profile;
import com.vedant.Ecommerce.beans.User;

public interface UserServiceInterface {

    User createUserWithProfile(User user, Profile profile);
    User getUserById(int id);
}
