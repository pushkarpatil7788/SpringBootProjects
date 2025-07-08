package com.infosys.mappdemo2.repos;

import com.infosys.mappdemo2.beans.Courses;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepo extends JpaRepository<Courses,Integer> {

}
