package com.infosys.coursemanagement.repos;
import com.infosys.coursemanagement.beans.Courses;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface CourseRepo extends JpaRepository<Courses,Integer> {
    List<Courses> findByCourseInstructor(String courseInstructor);
    List<Courses> findByCourseCategory(String courseCategory);
    List<Courses> findByCourseScheduleContaining(String schedulePart);
}
