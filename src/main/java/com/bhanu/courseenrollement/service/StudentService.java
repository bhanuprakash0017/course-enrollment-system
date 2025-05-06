package com.bhanu.courseenrollement.service;
import com.bhanu.courseenrollement.entity.Student;

import java.util.List;

public interface StudentService {
    void addStudent(Student student);
    List<Student> getAllStudents();
    Student getStudentById(Long id);
    boolean updateStudentById(Long id,Student student);
    boolean deleteStudentById(Long id);
}
