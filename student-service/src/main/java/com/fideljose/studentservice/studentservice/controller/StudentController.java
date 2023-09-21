package com.fideljose.studentservice.studentservice.controller;

import com.fideljose.studentservice.studentservice.model.entity.Student;
import com.fideljose.studentservice.studentservice.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class StudentController {

    @Autowired
    private StudentService service;

    @GetMapping("/")
    public ResponseEntity<?> getStudents(){
        return ResponseEntity.ok(service.findAllStudents());
    }

    @Autowired
    private ApplicationContext applicationContext;

    @Autowired
    private Environment environment;

    @GetMapping("/crash")
    public void crash(){
        ((ConfigurableApplicationContext)applicationContext).close();
    }


    @PostMapping("/")
    public ResponseEntity<?> createStudent(@Valid @RequestBody Student student
            , BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            Map<String, String> errors = new HashMap<>();
            bindingResult.getFieldErrors().forEach(e -> {
                errors.put(e.getField(), "The field - " + e.getField() + " " + e.getDefaultMessage());
            });
            return ResponseEntity.badRequest().body(errors);
        }
        return ResponseEntity.ok(service.saveStudent(student));
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findStudent(@PathVariable Long id){
        return ResponseEntity.ok( service.findByIdStudent(id));
    }

    @GetMapping("/students")
    public ResponseEntity<?> getListStudentByIds(@RequestParam List<Long> ids){
        return ResponseEntity.ok().body(service.getListStudentByIds(ids));
    }

    @GetMapping("/metadata-pod")
    public ResponseEntity<?> getPodMetadata(){
        String metadata = "Metadata: " + environment.getProperty("MY_POD_NAME") + " - " + environment.getProperty("MY_POD_IP")
                + " - " + environment.getProperty("config.text");
        return  ResponseEntity.ok(metadata);
    }
}
