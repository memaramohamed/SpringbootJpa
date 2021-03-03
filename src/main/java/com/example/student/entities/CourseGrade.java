package com.example.student.entities;

import javax.persistence.*;

@Entity
public class CourseGrade {

    @EmbeddedId
    CourseGradeKey id;

    @OneToOne
    @MapsId("StudentId")
    @JoinColumn(name = "STUDENT_ID")
    Student student;

    @OneToOne
    @MapsId("CourseId")
    @JoinColumn(name = "COURSE_ID")
    Course course;

    Grade grade;

    public CourseGrade() {
    }

    public CourseGradeKey getId() {
        return id;
    }

    public void setId(CourseGradeKey id) {
        this.id = id;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public Grade getGrade() {
        return grade;
    }

    public void setGrade(Grade grade) {
        this.grade = grade;
    }
}

