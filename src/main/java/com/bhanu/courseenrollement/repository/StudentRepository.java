package com.bhanu.courseenrollement.repository;

import com.bhanu.courseenrollement.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student,Long> {

    Student getStudentsByStudentId(Long studentId);
}
