package com.example.student.repository;

import com.example.student.entities.Student;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepo extends CrudRepository<Student, Long> {

//    public Student save(Student student) {
//        VirtualDB.STUDENTS.add(student);
//        return student;
//    }
//
//    public Student findById(Long id) {
//        Optional<Student> first = VirtualDB.STUDENTS.stream().filter(s -> s.getId() == id).findFirst();
//        return first.get();
//    }
//
//    public Collection<Student> findAll() {
//        return VirtualDB.STUDENTS;
//    }
}