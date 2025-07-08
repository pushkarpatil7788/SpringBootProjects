package com.infosys.EcommerceSystem.services;

import com.infosys.EcommerceSystem.beans.Profile;
import java.util.List;

public interface ProfileServiceInterface {
    void addProfile(Profile profile);
    List<Profile> getAllProfiles();
    Profile getProfileById(int profileId);
    void updateProfile(int profileId, Profile updatedProfile);
    void deleteProfile(int profileId);
}