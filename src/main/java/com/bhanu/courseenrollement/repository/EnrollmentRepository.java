package com.bhanu.courseenrollement.repository;

import com.bhanu.courseenrollement.entity.Course;
import com.bhanu.courseenrollement.entity.Enrollment;
import com.bhanu.courseenrollement.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EnrollmentRepository extends JpaRepository<Enrollment,Long> {
    List<Enrollment> findByCourse(Course course);

    List<Enrollment> findByStudent(Student student);
}
