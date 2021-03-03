package com.example.student.classmapper;

import com.example.student.entities.Course;
import com.example.student.models.CourseDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CourseMapper {

    Course courseDTOToCourse(CourseDTO courseDTO);
    CourseDTO courseToCourseDT0(Course course);
}
