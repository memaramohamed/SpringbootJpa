package com.example.student.entities;
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

    @OneToMany(fetch=FetchType.LAZY,cascade=CascadeType.ALL)
    @JoinColumn(name="NAME")
    private List<Student> students;

    public Course() {
    }

    public Course(int i, String course, List<com.example.student.Student> students) {
    }

    public Course(long id, String course, List<Student> students) {
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

