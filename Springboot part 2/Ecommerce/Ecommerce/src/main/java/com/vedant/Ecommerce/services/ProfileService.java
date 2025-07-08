package com.vedant.Ecommerce.services;

import com.vedant.Ecommerce.beans.Profile;
import com.vedant.Ecommerce.repos.ProfileRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProfileService implements ProfileServiceInterface {

    @Autowired
    private ProfileRepo profileRepo;

    @Override
    public Profile saveProfile(Profile profile) {
        return profileRepo.save(profile);
    }

    @Override
    public Profile getProfileById(int id) {
        return profileRepo.findById(id).orElse(null);
    }
}
