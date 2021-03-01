package com.example.student.models;

import javax.persistence.*;
import java.util.HashMap;
import java.util.List;


    @Entity
    @Table(name="CourseRegister")
    public class Course {


        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name="id")
        int id;

        @Column(name="courseName")
        String courseName;

        //kā to ievietot tabulā
        List<Student> listOfRegisteredStudents;

        public Course(int id, String courseName, List<Student> listOfRegisteredStudents) {
            this.id = id;
            this.courseName = courseName;
            this.listOfRegisteredStudents = listOfRegisteredStudents;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return courseName;
        }

        public void setName(String name) {
            this.courseName = name;
        }

        public List<Student> getListOfRegisteredStudents() {
            return listOfRegisteredStudents;
        }

        public void setListOfRegisteredStudents(List<Student> listOfRegisteredStudents) {
            this.listOfRegisteredStudents = listOfRegisteredStudents;
        }

        @Override
        public String toString() {
            return "Course{" +
                    "id=" + id +
                    ", courseName='" + courseName + '\'' +
                    ", listOfRegisteredStudents=" + listOfRegisteredStudents +
                    '}';
        }
        public void registerStudentToCourse(Student s){
            listOfRegisteredStudents.add(s);

        }

        HashMap<List<Student>, courseName> passedCourses = new HashMap<List<Student>, courseName>();

    }



