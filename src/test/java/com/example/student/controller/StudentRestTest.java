package com.example.student.controller;

import com.example.student.controller.CourseRest;
import com.example.student.entities.Student;
import com.example.student.models.StudentDTO;
import com.example.student.service.CourseService;
import com.example.student.service.StudentService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.BDDMockito;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.BDDAssumptions.given;
import static org.mockito.BDDMockito.then;
import static org.mockito.BDDMockito.willReturn;
import static org.mockito.Mockito.when;

    @ExtendWith(MockitoExtension.class)
    @WebMvcTest(CourseRest.class)
    @RunWith(SpringRunner.class)
    class StudentRestTest {

        @MockBean
        private StudentService studentService;
        StudentDTO mockStudentDTO;
        Student mockStudent;
        @MockBean
        CourseService courseService;
        @Mock
        Map<String, Object> model;
        List<Student> studentList = new ArrayList<>();
        MockMvc mockMvc;
        private Object Student;


        @BeforeEach
        void setup() {

            studentList.add(new Student());
            mockMvc = MockMvcBuilders.standaloneSetup(studentService).build();

            // mockStudentDTO = new StudentDTO();
            //mockStudentDTO.setName("Lita");
            // mockStudentDTO.setId(1L);

            // mockStudent = new Student();
            // mockStudent.setName("Lita");
            //mockStudent.setId(1L);

        }

        @Test
        void getAllStudents() throws Exception {
            // mockStudentDTO = new StudentDTO();
            // mockStudentDTO.setName("Lita");
            // mockStudentDTO.setId(2L);
            List<StudentDTO> allStudentsDTO = new ArrayList<>();
            allStudentsDTO.add(mockStudentDTO);


            when(studentService.getAllStudent()).thenReturn((Collection<com.example.student.entities.Student>) Student);

        }
        // @Test
        // void testControllerGetAllStudents() throws Exception {
        // mockMvc.perform(get("/students"))
        //       .andExpect(status().isOk())
        //       .andExpect(model().attributeExists("students"))
        //        .andExpect(view().name("students/allStudentDTO"));
        // }


        @Test
        void getStudent() {
            com.example.student.entities.Student students = studentService.getStudent(1l);
            then(studentService.getStudent(1l));


        }

        @Test
        void addStudent() {
        }


    }