package com.example.student.service;

import com.example.student.entities.Course;
import com.example.student.exceptions.CourseNotFoundException;
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

    public Course getCourse(Long id) throws CourseNotFoundException {
        Optional<Course> byId = courseRepo.findById(id);
        if(!byId.isPresent()) {
            throw new CourseNotFoundException("Course with ID number: " + id + " not found on the record!");
        }
        return byId.get();
    }

    public Collection<Course> getAllCourse() {
        Iterable<Course> iterableCourse = courseRepo.findAll();
        Collection<Course> collectionCourse = new ArrayList<Course>();
        iterableCourse.forEach(collectionCourse::add);
        return collectionCourse;
    }

    public Course save(Course course) {
        return (Course) courseRepo.save(course);
    }
}
