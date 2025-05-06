package com.bhanu.courseenrollement.service;

import com.bhanu.courseenrollement.entity.Course;

import java.util.List;

public interface CourseService {
     void addCourse(Course course);

     List<Course> getAllCourses();

     Course getCourseById(Long id);

     boolean updateCourse(Long id,Course course);

     boolean deleteCourse(Long id);
}
