package com.fideljose.Course.controller;

import com.fideljose.Course.Util.ValidateBody;
import com.fideljose.Course.entity.model.Course;
import com.fideljose.Course.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

@RestController
public class CourseController {

    @Autowired
    private CourseService service;

    @GetMapping("/")
    public ResponseEntity<?> getCourses(){
        return ResponseEntity.ok(service.listCourse());
    }

    @PostMapping("/")
    public ResponseEntity<?> saveCourse(@Valid @RequestBody Course course, BindingResult validResult){
        if(validResult.hasErrors()){
            return ValidateBody.validateCourse(course, validResult);
        }
        return ResponseEntity.ok().body(service.saveCourse(course));
    }


}
