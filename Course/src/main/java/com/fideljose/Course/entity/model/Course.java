package com.fideljose.Course.entity.model;

import com.fideljose.Course.entity.StudentDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "course")
@Data
@AllArgsConstructor
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty
    private String name;

    @NotEmpty
    private String address;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "id_course")
    private List<CourseStudent> courseStudentList;

    @Transient
    private List<StudentDto> students;

    public Course() {
        courseStudentList = new ArrayList<>();
        students = new ArrayList<>();
    }

    public void assignStudentToCourse(CourseStudent courseStudent){ courseStudentList.add(courseStudent);   }

    public void removeStudentToCourse(CourseStudent courseStudent){
        courseStudentList.remove(courseStudent);
    }

}
