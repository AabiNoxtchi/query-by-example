package com.example.queryByExample.repositories;

import com.example.queryByExample.models.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {
}

