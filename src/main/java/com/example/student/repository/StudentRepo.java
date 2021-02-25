package com.example.student.repository;

import com.example.student.VirtualDB;
import com.example.student.models.Student;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.Optional;

@Component
public class StudentRepo {

    public Student save(Student student) {
        VirtualDB.STUDENTS.add(student);
        return student;
    }

    public Student findById(Long id) {
        Optional<Student> first = VirtualDB.STUDENTS.stream().filter(s -> s.getId() == id).findFirst();
        return first.get();
    }

    public Collection<Student> findAll() {
        return VirtualDB.STUDENTS;
    }
}
