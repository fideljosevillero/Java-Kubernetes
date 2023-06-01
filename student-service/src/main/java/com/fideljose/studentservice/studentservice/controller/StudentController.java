package com.fideljose.studentservice.studentservice.controller;

import com.fideljose.studentservice.studentservice.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController(value = "/api/v1")
public class StudentController {

    @Autowired
    private StudentService service;

    @GetMapping("/")
    public ResponseEntity<?> getStudents(){
        return ResponseEntity.ok(service.findAllStudents());
        //return ResponseEntity.ok("todo bien 2!!!");
    }
}
