package com.infosys.CoursePostgreSqlRest.exception;

public class CourseException extends RuntimeException {

    public CourseException() {
        super("Course not found");
    }

    public CourseException(String id) {
        super("Cannot find course with ID: " + id);
    }
}
