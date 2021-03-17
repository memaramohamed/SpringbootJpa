package com.example.student.entities;
import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "COURSES")
public class Course {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @Column(name = "COURSE_NAME")
        private String courseName;

        @OneToMany(mappedBy = "course", fetch = FetchType.LAZY,
                cascade = {CascadeType.PERSIST, CascadeType.MERGE,
                        CascadeType.DETACH, CascadeType.REFRESH
                })
        private List<Student> students;

        @ManyToOne(fetch = FetchType.LAZY,
                cascade = {CascadeType.PERSIST, CascadeType.MERGE,
                        CascadeType.DETACH, CascadeType.REFRESH})
        @JoinTable(
                name = "STUDENT_COURSES",
                joinColumns = @JoinColumn(name = "STUDENT_ID", referencedColumnName = "ID"),
                inverseJoinColumns = @JoinColumn(name = "COURSE_ID", referencedColumnName = "ID")
        )
        private Student student;

        public Course() {
        }

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public String getCourseName() {
            return courseName;
        }

        public void setCourseName(String courseName) {
            this.courseName = courseName;
        }

        public List<Student> getStudents() {
            return students;
        }

        public void setStudents(List<Student> students) {
            this.students = students;
        }
    }
