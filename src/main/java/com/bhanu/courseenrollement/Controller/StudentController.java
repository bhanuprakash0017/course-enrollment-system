package com.bhanu.courseenrollement.Controller;


import com.bhanu.courseenrollement.entity.Student;
import com.bhanu.courseenrollement.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    StudentService studentService;
    @PostMapping()
    public ResponseEntity<String> addStudent(@RequestBody Student student)
    {
        studentService.addStudent(student);
        return new ResponseEntity<>("Student added successfully",HttpStatus.CREATED);
    }

    @GetMapping()

    public ResponseEntity<List<Student>> getAllStudents()
    {
        return new ResponseEntity<>(studentService.getAllStudents(),HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable Long id)
    {
        Student student=studentService.getStudentById(id);
        if(student!=null)return new ResponseEntity<>(student,HttpStatus.OK);
        return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateStudentById(@PathVariable Long id,@RequestBody Student student)
    {
        boolean isUpdated= studentService.updateStudentById(id,student);
        if(isUpdated)return new ResponseEntity<>("Student is updated successfully!",HttpStatus.OK);
        return new ResponseEntity<>("Student not found so cant able to update it.",HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteStudentById(@PathVariable Long id)
    {
        boolean isDeleted=studentService.deleteStudentById(id);
        if(isDeleted)return new ResponseEntity<>("Student Deleted Successfully",HttpStatus.OK);
        return new ResponseEntity<>("Student not found ,so can't be deleted",HttpStatus.NOT_FOUND);
    }
}
