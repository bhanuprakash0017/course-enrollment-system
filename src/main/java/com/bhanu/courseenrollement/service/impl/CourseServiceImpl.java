package com.bhanu.courseenrollement.service.impl;

import com.bhanu.courseenrollement.entity.Course;
import com.bhanu.courseenrollement.repository.CourseRepository;
import com.bhanu.courseenrollement.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    CourseRepository courseRepository;

    @Override
    public void addCourse(Course course) {
        courseRepository.save(course);
    }

    @Override
    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }

    @Override
    public Course getCourseById(Long id) {
        return courseRepository.findByCourseId(id);
    }

    @Override
    public boolean updateCourse(Long id, Course course) {
        Course course1=courseRepository.findByCourseId(id);
        if(course1==null)return false;
        course1.setName(course.getName());
        course1.setFees(course.getFees());
        course1.setDescription(course.getDescription());
        course1.setDuration(course.getDuration());
        courseRepository.save(course1);
        return true;
    }

    @Override
    public boolean deleteCourse(Long id) {
        Course course=courseRepository.findByCourseId(id);
        if(course==null)return false;
        courseRepository.delete(course);
        return true;

    }

}
