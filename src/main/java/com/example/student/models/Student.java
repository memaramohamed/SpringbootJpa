package com.example.student.models;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "STUDENTS")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "NAME")
    private String name;

    private String lastName;

    @Column
    List<courseName> courseNames = new ArrayList<>();
    private Object Student;

    public Student(Long id, String name, List<courseName> courseNames) {
        this.id = Math.toIntExact(id);
        this.name = name;
        this.courseNames = courseNames;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<courseName> getCourseNames() {
        return courseNames;
    }

    public void setCourseNames(List<courseName> courseNames) {
        this.courseNames = courseNames;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", courseNames=" + courseNames +
                '}';
    }

    public void addStudentToCourse(Course course){
        courseNames.add(courseName.CourseA);
    }

}