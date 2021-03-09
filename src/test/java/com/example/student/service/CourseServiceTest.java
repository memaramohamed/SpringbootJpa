package com.example.student.service;

import com.example.student.classmapper.CourseMapper;
import com.example.student.entities.Course;
import com.example.student.models.CourseDTO;
import com.example.student.repository.CourseRepo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CourseServiceTest {

    @InjectMocks
    CourseService service;

    @Mock
    CourseRepo courseRepo;

    @Mock
    CourseMapper courseMapper;

    CourseDTO mockCourseDTO;
    CourseDTO mockCourseDTO2;
    Course mockCourse;
    Course mockCourse2;

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
    void getCourse() {

        when(courseRepo.findById(1L)).thenReturn(java.util.Optional.ofNullable(mockCourse));
        when(courseMapper.courseToCourseDT0(mockCourse)).thenReturn(mockCourseDTO);

        CourseDTO course = service.getCourse(1L);
        assertEquals(mockCourseDTO, course);
    }

    @Test
    void getAllCourse() {

        mockCourseDTO2 = new CourseDTO();
        mockCourseDTO2.setCourseName("math");
        mockCourseDTO2.setId(2L);
        List<CourseDTO> allCoursesDTO = new ArrayList<>();
        allCoursesDTO.add(mockCourseDTO);
        allCoursesDTO.add(mockCourseDTO2);

        mockCourse2 = new Course();
        mockCourse2.setCourseName("math");
        mockCourse2.setId(2L);
        List<Course> allCourses = new ArrayList<>();
        allCourses.add(mockCourse);
        allCourses.add(mockCourse2);

        when(courseRepo.findAll()).thenReturn(allCourses);
        //kaa saiisinaat?
        when(courseMapper.courseToCourseDT0(mockCourse)).thenReturn(mockCourseDTO);
        when(courseMapper.courseToCourseDT0(mockCourse2)).thenReturn(mockCourseDTO2);

        assertArrayEquals(allCoursesDTO.toArray(), service.getAllCourse().toArray());
    }

    @Test
    void save() {

        when(courseRepo.save(mockCourse)).thenReturn(mockCourse);
        when(courseMapper.courseDTOToCourse(mockCourseDTO)).thenReturn(mockCourse);

        assertEquals(mockCourse, service.save(mockCourseDTO));
    }
}