package com.sahil.StudentManagement.controller;

import com.sahil.StudentManagement.model.Student;
import com.sahil.StudentManagement.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/students")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @GetMapping("/add")
    public String addStudent(Model model){
        model.addAttribute("student",new Student());
        return "add-student";
    }

    @PostMapping
    public String add_student(@ModelAttribute Student student){
        studentService.addStudent(student);
        return "redirect:/students";
    }

    @GetMapping
    public String getAllStudents(Model model){
        List<Student> students=studentService.getAllStudents();
        model.addAttribute("students",students);
        return "students";
    }

    @GetMapping("/delete/{id}")
    public String removeStudent(@PathVariable Long id){
        studentService.removeStudent(id);
        return "redirect:/students";
    }

    @GetMapping("/edit/{id}")
    public String showEditStudentForm(@PathVariable Long id, Model model) {
        Student student = studentService.getStudentById(id);
        if (student != null) {
            model.addAttribute("student", student);
            return "edit-student";
        } else {
            return "redirect:/students";
        }
    }

    @PostMapping("/edit")
    public String updateStudent(@ModelAttribute Student student) {
        studentService.updateStudent(student);
        return "redirect:/students";
    }

}
