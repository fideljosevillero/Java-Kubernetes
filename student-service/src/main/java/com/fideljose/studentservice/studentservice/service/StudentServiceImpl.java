package com.fideljose.studentservice.studentservice.service;

import com.fideljose.studentservice.studentservice.model.entity.Student;
import com.fideljose.studentservice.studentservice.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService{

    @Autowired
    private StudentRepository repository;

    @Override
    @Transactional(readOnly = true)
    public List<Student> findAllStudents() {
        return repository.findAll();
    }

    @Override
    public Student saveStudent(Student student) {
        return repository.save(student);
    }

    @Override
    public Optional<Student> findByIdStudent(Long id) {
        return repository.findById(id);
    }

    @Override
    public void deleteStudent() {

    }

    @Override
    public List<Student> getListStudentByIds(Iterable<Long> ids) {
        return repository.findAllById(ids);
    }

}
