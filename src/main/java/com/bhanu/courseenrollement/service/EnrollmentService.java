package com.bhanu.courseenrollement.service;

import com.bhanu.courseenrollement.entity.Course;
import com.bhanu.courseenrollement.entity.Enrollment;
import com.bhanu.courseenrollement.entity.Student;

import java.util.List;

public interface EnrollmentService {

    void  enrollStudent(Long studentId,Long courseId);

    List<Enrollment> getAllEnrollments();

    List<Student> getStudentsByCourseId(Long courseId);

    List<Course> getCoursesByStudentId(Long studentId);
}
