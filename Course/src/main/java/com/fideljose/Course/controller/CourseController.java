package com.fideljose.Course.controller;

import com.fideljose.Course.entity.model.Course;
import com.fideljose.Course.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CourseController {

    @Autowired
    private CourseService service;

    @GetMapping("/")
    public ResponseEntity<?> getCourses(){
        return ResponseEntity.ok(service.listCourse());
    }

    @PostMapping("/")
    public ResponseEntity<?> saveCourse(@RequestBody Course course){
        return ResponseEntity.ok().body(service.saveCourse(course));
    }
}
