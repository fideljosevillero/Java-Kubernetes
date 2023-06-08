package com.fideljose.studentservice.studentservice.controller;

import com.fideljose.studentservice.studentservice.model.entity.Student;
import com.fideljose.studentservice.studentservice.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class StudentController {

    @Autowired
    private StudentService service;

    @GetMapping("/")
    public ResponseEntity<?> getStudents(){
        return ResponseEntity.ok(service.findAllStudents());
    }

    @PostMapping("/")
    public ResponseEntity<Student> saveStudent(Student student){
        return ResponseEntity.ok(service.saveStudent(student));
    }
}
