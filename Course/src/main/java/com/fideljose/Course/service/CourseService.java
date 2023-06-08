package com.fideljose.Course.service;

import com.fideljose.Course.entity.model.Course;

import java.util.List;

public interface CourseService {

    public Course saveCourse(Course course);
    public List<Course> listCourse();
}
