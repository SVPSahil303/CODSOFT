package com.sahil.StudentManagement.service;

import com.sahil.StudentManagement.model.Student;
import com.sahil.StudentManagement.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public Student addStudent(Student student){
        return studentRepository.save(student);
    }

    public void removeStudent(Long id){
        studentRepository.deleteById(id);
    }

    public Student searchStudentByRollNumber(int rollNumber){
        return studentRepository.findByRollNumber(rollNumber);
    }

    public List<Student> getAllStudents(){
        return  studentRepository.findAll();
    }

    public Student getStudentById(Long id) {
        return studentRepository.findById(id).orElse(null);
    }

    public Student updateStudent(Student student) {
        return studentRepository.save(student);
    }
}
