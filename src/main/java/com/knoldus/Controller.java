package com.knoldus;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class Controller {

    @Autowired
    private StudentRepository studentRepository;

    @PostMapping("/createStudent")
    public String createStudent(@RequestParam String name) {
        studentRepository.save(new Student(name, "AKTU University"));
        return studentRepository.findByName(name);
    }

    @GetMapping("/getStudent")
    public List<Student> getAllStudents() {
        return (List<Student>) studentRepository.findAll();
    }

}
