package com.example.student.service;

import com.example.student.entities.Student;
import com.example.student.repository.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    StudentRepo studentRepo;

    public Optional<Student> getStudent(Long id) {
        return studentRepo.findById(id);
    }

    public Collection<Student> getAllStudent() {
        return (Collection<Student>) studentRepo.findAll();
    }

    public Student save(Student student) {
        return studentRepo.save(student);
    }
}
