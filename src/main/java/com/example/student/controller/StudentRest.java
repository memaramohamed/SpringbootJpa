package com.example.student.controller;

import com.example.student.entities.Student;
import com.example.student.models.StudentDTO;
import com.example.student.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("student")
public class StudentRest {

    @Autowired
    StudentService studentService;

    @GetMapping
    public Iterable<StudentDTO> getAllStudents() {
        return studentService.getAllStudent();
    }

    @GetMapping("{id}")
    public StudentDTO getStudent(@PathVariable Long id) {
        return studentService.getStudent(id);
    }

    @PostMapping
    public Student addStudent(@RequestBody StudentDTO s) {
        return studentService.save(s);
    }
}
