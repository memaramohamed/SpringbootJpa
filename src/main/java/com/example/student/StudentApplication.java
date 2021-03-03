package com.example.student;

import com.example.student.entities.Course;
import com.example.student.entities.Course;
import com.example.student.entities.Student;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@SpringBootApplication
public class StudentApplication {

	public static void main(String[] args) {
		SpringApplication.run(StudentApplication.class, args);

		HashMap<List<Student>, courseName> passedCourses = new HashMap<List<Student>, courseName>();


		List<Student> students = new ArrayList<Student>();
		Course course = new Course(1,"Course",students);

		List<Course> courses = new ArrayList<>();
		courses.add(course);
	}

}
