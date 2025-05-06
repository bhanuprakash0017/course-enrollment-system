package com.bhanu.courseenrollement.Controller;

import com.bhanu.courseenrollement.entity.Course;
import com.bhanu.courseenrollement.entity.Enrollment;
import com.bhanu.courseenrollement.entity.Student;
import com.bhanu.courseenrollement.service.EnrollmentService;
import com.bhanu.courseenrollement.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.w3c.dom.html.HTMLTableCaptionElement;

import java.util.List;

@RestController
@RequestMapping("/enrollment")
public class EnrollmentController {

    @Autowired
    EnrollmentService enrollmentService;

    @PostMapping
    public ResponseEntity<String> enrollStudent(
            @RequestParam Long studentId,
            @RequestParam Long courseId
    )
    {
        enrollmentService.enrollStudent(studentId,courseId);
        return new ResponseEntity<>("Student enrolled sucessfully", HttpStatus.CREATED);
    }
    @GetMapping()

    public ResponseEntity<List<Enrollment>> getAllEnrollments()
    {
        return new ResponseEntity<>(enrollmentService.getAllEnrollments(),HttpStatus.OK);
    }

    @GetMapping("/courses/{courseId}/students")
    public ResponseEntity<List<Student>> getStudentsByCourse(@PathVariable Long courseId)
    {
        return new ResponseEntity<>(enrollmentService.getStudentsByCourseId(courseId),HttpStatus.OK);
    }

    @GetMapping("/students/{studentId}/courses")
    public ResponseEntity<List<Course>> getCoursesByStudent(@PathVariable Long studentId)
    {
        return new ResponseEntity<>(enrollmentService.getCoursesByStudentId(studentId),HttpStatus.OK);
    }
}
