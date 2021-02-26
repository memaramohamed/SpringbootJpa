package com.example.student.controller;

import com.example.student.models.Student;
import com.example.student.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("student")
public class StudentRest {
    @Autowired
    StudentService studentService;

    @GetMapping
    public Iterable<Student> getAllStudents() {
        return studentService.getAllStudent();
    }

    @GetMapping("{id}")
    public Student getStudent(@PathVariable Long id) {
        return studentService.getStudent(id)
                .orElseThrow(()->new RuntimeException("No student found"));
    }

    @PostMapping
    public Student addStudent(@RequestBody Student s) {
        return studentService.save(s);
    }
}
