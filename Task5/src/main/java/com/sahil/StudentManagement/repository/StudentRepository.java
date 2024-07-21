package com.sahil.StudentManagement.repository;

import com.sahil.StudentManagement.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student,Long> {
    Student findByRollNumber(int rollNumber);

}
