package com.infosys.mappdemo2.services;

import com.infosys.mappdemo2.beans.Courses;

import java.util.List;

public interface CourseInterface {
    public void saveCourses(Courses courses);
    public List<Courses> getAllCourses();

}
