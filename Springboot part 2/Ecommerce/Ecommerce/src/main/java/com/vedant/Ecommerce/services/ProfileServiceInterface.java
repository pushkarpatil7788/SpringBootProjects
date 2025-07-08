package com.vedant.Ecommerce.services;

import com.vedant.Ecommerce.beans.Profile;

public interface ProfileServiceInterface {
    Profile saveProfile(Profile profile);
    Profile getProfileById(int id);
}
