package com.infosys.User_Rest.repository;

import com.infosys.User_Rest.model.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserInterfaceRepository extends JpaRepository<UserInfo,Long> {
}
