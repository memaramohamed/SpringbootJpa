package com.example.student.controller;

import com.example.student.entities.Course;
import com.example.student.models.CourseDTO;
import com.example.student.service.CourseService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(MockitoExtension.class)
@WebMvcTest(CourseRest.class)
class CourseRestTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CourseService courseService;

    CourseDTO mockCourseDTO;
    Course mockCourse;

    @BeforeEach
    void setUp() {
        mockCourseDTO = new CourseDTO();
        mockCourseDTO.setCourseName("science");
        mockCourseDTO.setId(1L);
    }

    @Test
    void getAllCourse() throws Exception {
    }

    @Test
    void getCourse() throws Exception {
        when(courseService.getCourse(1L)).thenReturn(mockCourseDTO);

        RequestBuilder request = MockMvcRequestBuilders
                .get("/course/1")
                .accept(MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().json("{id:1, courseName:science}"))
                .andReturn();
    }

    @Test
    void addCourse()throws Exception {
        when(courseService.save(Mockito.any(CourseDTO.class))).thenReturn(mockCourse);


    }
}