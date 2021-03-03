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
    @Autowired
    StudentMapper studentMapper;

    public StudentDTO getStudent(Long id) throws StudentNotFoundException {
        Optional<Student> byId = studentRepo.findById(id);
        if(!byId.isPresent()) {
            throw new StudentNotFoundException("Student with ID number: " + id + " not found on the record!");
        }
        StudentDTO studentDTO = studentMapper.studentToStudentDT0(byId.get());
        return studentDTO;
    }

    public Collection<StudentDTO> getAllStudent() {
        Iterable<Student> iterableStudent = studentRepo.findAll();
        Collection<Student> collectionStudent = new ArrayList<Student>();
        iterableStudent.forEach(collectionStudent::add);

        Collection<StudentDTO> collectionStudentDTO = new ArrayList<StudentDTO>();
        collectionStudent.stream()
                .map(student -> studentMapper.studentToStudentDT0(student))
                .forEach(collectionStudentDTO::add);

        return collectionStudentDTO;
    }

    public Student save(StudentDTO studentDTO) {
        Student student = studentMapper.studentDTOToStudent(studentDTO);
        return studentRepo.save(student);
    }
}
