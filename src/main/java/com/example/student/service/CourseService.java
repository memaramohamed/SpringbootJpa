package com.example.student.service;

import com.example.student.classmapper.CourseMapper;
import com.example.student.entities.Course;
import com.example.student.exceptions.CourseNotFoundException;
import com.example.student.models.CourseDTO;
import com.example.student.repository.CourseRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;
@Service
public class CourseService {

        @Autowired
        CourseRepo courseRepo;
        @Autowired
        CourseMapper courseMapper;

        public CourseDTO getCourse(Long id) throws CourseNotFoundException {
            Optional<Course> byId = courseRepo.findById(id);
            if(!byId.isPresent()) {
                throw new CourseNotFoundException("Course with ID number: " + id + " not found on the record!");
            }
            return courseMapper.courseToCourseDT0(byId.get());
        }

        public Collection<CourseDTO> getAllCourse() {
            Iterable<Course> iterableCourse = courseRepo.findAll();
            Collection<Course> collectionCourse = new ArrayList<Course>();
            iterableCourse.forEach(collectionCourse::add);

            Collection<CourseDTO> collectionCourseDTO = new ArrayList<CourseDTO>();
            collectionCourse.stream()
                    .map(course -> courseMapper.courseToCourseDT0(course))
                    .forEach(collectionCourseDTO::add);
            return collectionCourseDTO;
        }

        public Course save(CourseDTO courseDTO) {
            return (Course) courseRepo.save(courseMapper.courseDTOToCourse(courseDTO));
        }
    }



