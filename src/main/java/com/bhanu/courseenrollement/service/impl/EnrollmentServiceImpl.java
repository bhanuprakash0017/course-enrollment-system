package com.bhanu.courseenrollement.service.impl;

import com.bhanu.courseenrollement.entity.Course;
import com.bhanu.courseenrollement.entity.Enrollment;
import com.bhanu.courseenrollement.entity.Student;
import com.bhanu.courseenrollement.repository.CourseRepository;
import com.bhanu.courseenrollement.repository.EnrollmentRepository;
import com.bhanu.courseenrollement.repository.StudentRepository;
import com.bhanu.courseenrollement.service.EnrollmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class EnrollmentServiceImpl implements EnrollmentService {

    @Autowired
    EnrollmentRepository enrollmentRepository;

    @Autowired
    StudentRepository studentRepository;

    @Autowired
    CourseRepository courseRepository;

    @Override
    public void enrollStudent(Long studentId, Long courseId) {
        Student student = studentRepository.findById(studentId)
                .orElseThrow(() -> new RuntimeException("Student not found"));
        Course course = courseRepository.findById(courseId)
                .orElseThrow(() -> new RuntimeException("Course not found"));
        Enrollment enrollment =new Enrollment();
        enrollment.setStudent(student);
        enrollment.setCourse(course);
        enrollment.setEnrollmentDate(LocalDate.now());
        enrollmentRepository.save(enrollment);
    }

    @Override
    public List<Enrollment> getAllEnrollments() {
        return enrollmentRepository.findAll();
    }

    @Override
    public List<Student> getStudentsByCourseId(Long courseId) {
        Course course=courseRepository.findById(courseId).orElseThrow(()->new RuntimeException("course not found"));
        List<Enrollment> enrollments=enrollmentRepository.findByCourse(course);
        List<Student> students=new ArrayList<>();
        for(Enrollment enrollment:enrollments)
        {
            students.add(enrollment.getStudent());
        }
        return students;
    }

    @Override
    public List<Course> getCoursesByStudentId(Long studentId) {
        Student student=studentRepository.findById(studentId).orElseThrow(()->new RuntimeException("STUDENT NOT FOUND!"));
        List<Enrollment> enrollments=enrollmentRepository.findByStudent(student);
        List<Course> courses=new ArrayList<>();
        for(Enrollment enrollment:enrollments)
        {
            courses.add(enrollment.getCourse());
        }
        return courses;
    }
}
