package com.example.student.controller;

import com.example.student.entities.Student;
import com.example.student.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Optional;

@RestController
@RequestMapping("student")
public class StudentRest {
    @Autowired
    StudentService studentService;

    @GetMapping
    public Collection<Student> getAllStudents() {
        return studentService.getAllStudent();
    }

    @GetMapping("{id}")
    public Optional<Student> getStudent(@PathVariable Long id) {
        return studentService.getStudent(id);
    }

    @PostMapping
    public Student addStudent(@RequestBody Student s) {
        return studentService.save(s);
    }
}
