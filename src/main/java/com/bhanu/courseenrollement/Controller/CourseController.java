package com.bhanu.courseenrollement.Controller;

import com.bhanu.courseenrollement.entity.Course;
import com.bhanu.courseenrollement.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/courses")
public class CourseController {
    @Autowired
    CourseService courseService;

    @PostMapping()
    public ResponseEntity<String> addCourse(@RequestBody Course course)
    {
        courseService.addCourse(course);
        return new ResponseEntity<>("course is added successfully", HttpStatus.CREATED);
    }

    @GetMapping()
    public ResponseEntity<List<Course>> getAllCourses()
    {
        return new ResponseEntity<>(courseService.getAllCourses(),HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Course> getCourseById(@PathVariable long id)
    {
        Course course=courseService.getCourseById(id);
        if(course==null)return new ResponseEntity<>(course,HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(course,HttpStatus.FOUND);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateCourseById(@PathVariable long id,@RequestBody Course course)
    {
        boolean isAdded= courseService.updateCourse(id,course);
        if(isAdded)return new ResponseEntity<>("course is updated successfully",HttpStatus.OK);
        return new ResponseEntity<>("course if not found!",HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCourseById(@PathVariable Long id)
    {
        boolean isDeleted=courseService.deleteCourse(id);
        if(isDeleted)return new ResponseEntity<>("course deleted successfully",HttpStatus.OK);
        return  new ResponseEntity<>("course not found so not deleted",HttpStatus.NOT_FOUND);
    }
}
