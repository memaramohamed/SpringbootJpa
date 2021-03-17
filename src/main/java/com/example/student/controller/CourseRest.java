package com.example.student.controller;

import com.example.student.entities.Course;
import com.example.student.models.CourseDTO;
import com.example.student.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

    @RestController
    @RequestMapping("course")
    public class CourseRest {

        @Autowired
        CourseService courseService;

        @GetMapping
        public Iterable<CourseDTO> getAllCourse() {
            return courseService.getAllCourse();
        }

        @GetMapping("{id}")
        public CourseDTO getCourse(@PathVariable Long id) {
            return courseService.getCourse(id);
        }

        @PostMapping
        public Course addCourse(@RequestBody CourseDTO c) {
            return courseService.save(c);
        }
    }


