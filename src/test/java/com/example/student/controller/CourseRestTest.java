package com.example.student.controller;

import com.example.student.entities.Course;
import com.example.student.models.CourseDTO;
import com.example.student.service.CourseService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(MockitoExtension.class)
@WebMvcTest(CourseRest.class)
class CourseRestTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CourseService courseService;

    CourseDTO mockCourseDTO;
    CourseDTO mockCourseDTO2;
    Course mockCourse;

    @BeforeEach
    void setUp() {
        mockCourseDTO = new CourseDTO();
        mockCourseDTO.setCourseName("science");
        mockCourseDTO.setId(1L);

        mockCourse = new Course();
        mockCourse.setCourseName("science");
        mockCourse.setId(1L);
        mockCourse.setStudents(null);
    }

    @Test
    void getAllCourse() throws Exception {

        mockCourseDTO2 = new CourseDTO();
        mockCourseDTO2.setCourseName("math");
        mockCourseDTO2.setId(2L);
        List<CourseDTO> allCoursesDTO = new ArrayList<>();
        allCoursesDTO.add(mockCourseDTO);
        allCoursesDTO.add(mockCourseDTO2);

        when(courseService.getAllCourse()).thenReturn(allCoursesDTO);

        MockHttpServletResponse response = mockMvc.perform(MockMvcRequestBuilders
        .get("/course")
        .accept(MediaType.APPLICATION_JSON))
        .andDo(print())
        .andExpect(status().isOk())
        .andExpect(content().json("[{\"id\":1,\"courseName\":\"science\"},{\"id\":2,\"courseName\":\"math\"}]"))
        .andReturn().getResponse();

        // String responseString = response.getContentAsString();
        // String expectedResponse = "[{\"id\":1,\"courseName\":\"science\"},{\"id\":2,\"courseName\":\"math\"}]";

        // assertEquals(expectedResponse, responseString);
    }

    @Test
    void getCourse() throws Exception {
        when(courseService.getCourse(1L)).thenReturn(mockCourseDTO);

        RequestBuilder request = MockMvcRequestBuilders
                .get("/course/1")
                .accept(MediaType.APPLICATION_JSON);

        mockMvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(jsonPath("id").value(1L))
                .andExpect(jsonPath("courseName").value("science"))
                .andReturn();
    }

    @Test
    void addCourse() throws Exception {
        when(courseService.save(Mockito.any(CourseDTO.class))).thenReturn(mockCourse);

        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .post("/course")
                .contentType(MediaType.APPLICATION_JSON)
                .content(courseDtoToJson(mockCourseDTO));

        mockMvc.perform(requestBuilder)
                .andExpect(status().isOk())
                .andExpect(jsonPath("/course/1").exists())
                .andReturn();
    }

    private String courseDtoToJson(CourseDTO courseDto) {

        ObjectMapper objectMapper = new ObjectMapper();
        try {
            return objectMapper.writeValueAsString(courseDto);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return null;
    }
}