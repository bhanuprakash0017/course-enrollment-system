package com.bhanu.courseenrollement.repository;

import com.bhanu.courseenrollement.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public  interface CourseRepository extends JpaRepository<Course,Long> {
    Course findByCourseId(Long id);
}
