package com.example.queryByExample.services;


import com.example.queryByExample.models.Student;
import com.example.queryByExample.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    private StudentRepository repo;

    public List<Student> findByExample(Student studentExample) {
        Example<Student> example = Example.of(studentExample);
        return repo.findAll(example);
    }
}
