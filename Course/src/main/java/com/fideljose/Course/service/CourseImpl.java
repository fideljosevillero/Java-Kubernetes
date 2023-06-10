package com.fideljose.Course.service;

import com.fideljose.Course.entity.model.Course;
import com.fideljose.Course.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
