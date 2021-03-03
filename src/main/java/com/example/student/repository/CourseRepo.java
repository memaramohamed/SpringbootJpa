
package com.example.student.repository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepo<Course> extends CrudRepository<Course, Long> {
}
