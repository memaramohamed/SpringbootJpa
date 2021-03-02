package com.example.student.entities;

import com.example.student.entities.Student;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "COURSES")
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(name = "COURSE_NAME")
    private String courseName;

    @OneToMany(mappedBy = "NAME", fetch=FetchType.LAZY,cascade=CascadeType.ALL)
    @JoinColumn(name="NAME")
    private List<Student> students;

    public Course() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }
}
