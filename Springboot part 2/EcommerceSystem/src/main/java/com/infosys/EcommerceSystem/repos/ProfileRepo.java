package com.infosys.EcommerceSystem.repos;

import com.infosys.EcommerceSystem.beans.Profile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfileRepo extends JpaRepository<Profile,Integer> {
}
