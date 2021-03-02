package com.example.student.service;

import com.example.student.classmapper.StudentMapper;
import com.example.student.exceptions.StudentNotFoundException;
import com.example.student.entities.Student;
import com.example.student.models.StudentDTO;
import com.example.student.repository.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;


@Service
public class StudentService {

    @Autowired
    StudentRepo studentRepo;

    public Student getStudent(Long id) throws StudentNotFoundException {
        Optional<Student> byId = studentRepo.findById(id);
        if(!byId.isPresent()) {
            throw new StudentNotFoundException("Student with ID number: " + id + " not found on the record!");
        }
        return byId.get();
    }

    public Collection<Student> getAllStudent() {
        Iterable<Student> iterableStudent = studentRepo.findAll();
        Collection<Student> collectionStudent = new ArrayList<Student>();
        iterableStudent.forEach(collectionStudent::add);
        return collectionStudent;
    }

    public Student save(Student student) {
        return studentRepo.save(student);
    }
}
