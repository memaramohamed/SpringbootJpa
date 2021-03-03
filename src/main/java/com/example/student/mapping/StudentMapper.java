package com.example.student.mapping;

import com.example.student.entities.Student;
import com.example.student.models.StudentDTO;
import org.mapstruct.Mapper;

@Mapper
public interface StudentMapper {

    Student studentDTOToStudent(StudentDTO studentDTO);
    StudentDTO studentToStudentDT0(Student student);
}