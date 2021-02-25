package com.example.student.service;

import com.example.student.VirtualDB;
import com.example.student.models.Student;
import com.example.student.repository.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class StudentService {

    @Autowired
    StudentRepo studentRepo;

    public Student getStudent(Long id) {
        return studentRepo.findById(id);
    }

    public Collection<Student> getAllStudent() {
        return studentRepo.findAll();
    }

    public Student save(Student student) {
        return studentRepo.save(student);
    }
}
