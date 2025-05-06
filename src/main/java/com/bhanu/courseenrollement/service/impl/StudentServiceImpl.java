package com.bhanu.courseenrollement.service.impl;

import com.bhanu.courseenrollement.entity.Student;
import com.bhanu.courseenrollement.repository.StudentRepository;
import com.bhanu.courseenrollement.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    StudentRepository studentRepository;

    @Override
    public void addStudent(Student student) {
        studentRepository.save(student);
    }

    @Override
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    @Override
    public Student getStudentById(Long id) {
        return  studentRepository.getStudentsByStudentId(id);
    }

    @Override
    public boolean updateStudentById(Long id, Student student) {
        Student student1=studentRepository.getStudentsByStudentId(id);
        if(student1==null)return false;
        student1.setAddress(student.getAddress());
        student1.setEmail(student.getEmail());
        student1.setName(student.getName());
        student1.setContactNumber(student.getContactNumber());
        studentRepository.save(student1);
        return true;
    }
    @Override
   public boolean deleteStudentById(Long id)
    {
        Student student=studentRepository.getStudentsByStudentId(id);
        if(student==null)return false;
        studentRepository.delete(student);
        return true;
    }
}
