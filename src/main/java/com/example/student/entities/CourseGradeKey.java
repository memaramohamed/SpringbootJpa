package com.example.student.entities;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class CourseGradeKey implements Serializable {

    @Column(name = "COURSE_ID")
    Long CourseId;

    @Column(name = "STUDENT_ID")
    Long StudentId;

    public CourseGradeKey() {
    }

    public Long getCourseId() {
        return CourseId;
    }

    public void setCourseId(Long courseId) {
        CourseId = courseId;
    }

    public Long getStudentId() {
        return StudentId;
    }

    public void setStudentId(Long studentId) {
        StudentId = studentId;
    }

    @Override
    public int hashCode() {

        Integer result = (int)(long)(31 + getCourseId() + getStudentId());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == null) {
            return false;
        }
        if(obj == this) {
            return true;
        }
        if(getClass() != obj.getClass()) {
            return false;
        }

        CourseGradeKey k = (CourseGradeKey) obj;
        return (this.getStudentId() == k.getStudentId() && this.getCourseId() == k.getCourseId());
    }
}
