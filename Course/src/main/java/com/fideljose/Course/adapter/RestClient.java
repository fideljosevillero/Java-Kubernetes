package com.fideljose.Course.adapter;

import com.fideljose.Course.entity.StudentDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

@FeignClient(name = "student-service", url = "host.docker.internal:8001")
public interface RestClient {

    @PostMapping("/")
    StudentDto createStudent(StudentDto studentDto);

    @GetMapping("/")
    StudentDto listStudent();

    @GetMapping("/{id}")
    Optional<StudentDto> studentFindById(@PathVariable Long id);

    @GetMapping("/students")
    List<StudentDto> getListStudentByIds(@RequestParam List<Long> ids);
}
