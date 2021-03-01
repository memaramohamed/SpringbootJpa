package com.example.student.models;

import javax.persistence.*;


    @Entity
    @Table(name="Course List")
    public class CoursesToRegister {
        //
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name="id")
        private int studentId;

        @Column(name="A")
        private String courseA;

        @Column(name="B")
        private String courseB;

        @Column(name="C")
        private String CourseC;

        @Column(name="Grade")
        boolean Pass = true;

    }


