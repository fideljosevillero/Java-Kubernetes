package com.fideljose.Course.controller;

import com.fideljose.Course.Util.ValidateBody;
import com.fideljose.Course.entity.StudentDto;
import com.fideljose.Course.entity.model.Course;
import com.fideljose.Course.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

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

    @PutMapping("/assign-student/{courseId}")
    public ResponseEntity<?> assingStudentToCourse(@PathVariable Long courseId, @RequestBody StudentDto studentDto){
        Optional<StudentDto> student =  service.assignStudentToCourse(studentDto, courseId);
        if(student.isPresent()){
            return ResponseEntity.status(HttpStatus.CREATED).body(student);
        }
        return ResponseEntity.notFound().build();
    }


}
