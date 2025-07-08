package com.infosys.EcommerceSystem.services;

import com.infosys.EcommerceSystem.beans.Profile;
import com.infosys.EcommerceSystem.repos.ProfileRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProfileService implements ProfileServiceInterface {

    @Autowired
    private ProfileRepo profileRepo;

    @Override
    public void addProfile(Profile profile) {
        profileRepo.save(profile);
    }

    @Override
    public List<Profile> getAllProfiles() {
        return profileRepo.findAll();
    }

    @Override
    public Profile getProfileById(int profileId) {
        return profileRepo.findById(profileId).orElse(null);
    }

    @Override
    public void updateProfile(int profileId, Profile updatedProfile) {
        Profile existing = profileRepo.findById(profileId).orElse(null);
        if (existing != null) {
            existing.setProfileId(updatedProfile.getProfileId());
            existing.setFirstName(updatedProfile.getFirstName());
            existing.setLastName(updatedProfile.getLastName());
            existing.setEmail(updatedProfile.getEmail());
            profileRepo.save(existing);
        }
    }

    @Override
    public void deleteProfile(int profileId) {
        profileRepo.deleteById(profileId);
    }
}
