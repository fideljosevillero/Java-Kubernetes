package com.fideljose.Course.service;

import com.fideljose.Course.entity.model.Course;
import com.fideljose.Course.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseImpl implements CourseService{

    @Autowired
    private CourseRepository repository;

    @Override
    public Course saveCourse(Course course) {
        return repository.save(course);
    }

    @Override
    public List<Course> listCourse() {
        return repository.findAll();
    }

}
