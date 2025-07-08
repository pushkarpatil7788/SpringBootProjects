package com.infosys.EcommerceSystem.repos;

import com.infosys.EcommerceSystem.beans.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User,Integer> {

}
