package com.example.queryByExample.controllers;


import com.example.queryByExample.models.Student;
import com.example.queryByExample.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentService service;

    @PostMapping("/search")
    public List<Student> search(@RequestBody Student studentExample) {
        return service.findByExample(studentExample);
    }
}

