package com.example.student.service;

import com.example.student.classmapper.StudentMapper;
        import com.example.student.entities.Course;
        import com.example.student.entities.Student;
        import com.example.student.models.CourseDTO;
        import com.example.student.models.StudentDTO;
        import com.example.student.repository.StudentRepo;
        import com.example.student.service.StudentService;
        import org.assertj.core.api.AssertionsForClassTypes;
        import org.hamcrest.core.IsInstanceOf;
        import org.junit.jupiter.api.Test;
        import org.junit.jupiter.api.extension.ExtendWith;
        import org.mockito.InjectMocks;
        import org.mockito.Mock;
        import org.mockito.junit.jupiter.MockitoExtension;

        import javax.naming.Name;
        import java.util.*;

        import static org.assertj.core.api.Assertions.assertThat;
        import static org.junit.jupiter.api.Assertions.*;
        import static org.mockito.ArgumentMatchers.any;
        import static org.mockito.ArgumentMatchers.anyLong;
        import static org.mockito.BDDMockito.given;
        import static org.mockito.BDDMockito.then;
        import static org.mockito.Mockito.verify;
        import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class StudentServiceTest {

    @InjectMocks
    StudentService studentService;

    @Mock
    StudentMapper studentMapper;
    @Mock
    StudentRepo studentrepo;
    Student student;
    StudentDTO studentDTO;


    @Test
    void getStudent() {

//when(studentMapper.studentToStudentDT0(any())).thenReturn(); ko vajag atgriezt?
        //K un vai tur jnorda exception?
//StudentDTO studentDTO = studentService.getStudent(1L);
//verify(studentMapper.studentDTOToStudent(any()));
//assertThat(studentDTO).isNotNull();

//        List<Student> students= new ArrayList<>();
//        given(studentService.getStudent(1l)).willReturn(Student);
//        //when
//        Collection<Student>returnStudent = studentService.getStudent();
//
//        //then
//        then(studentrepo).should().findAll();
//        AssertionsForClassTypes.assertThat(returnStudent).isNotNull();

    }

    @Test
    void getAllStudent() {
        //when(studentrepo.findAll(any())).thenReturn();
        // StudentDTO studentDTO = studentService.getAllStudent(Na);

        Student student = new Student();
        Set<Student> students = new HashSet<>();
        students.add(student);
        when(studentrepo.findAll()).thenReturn(students);
        Collection<Student> studentDTOS = studentService.getAllStudent();
        verify(studentrepo).findAll();

    }

    @Test
    void save() {

        Student student = new Student();
        when(studentService.save(any(Student.class))).thenReturn(student);
        Student savedStudents = studentService.save(new Student());


        assertThat(savedStudents).isNotNull();

    }
}

