package com.example.queryByExample.repositories;

import com.example.queryByExample.InitialData;
import com.example.queryByExample.models.Student;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.data.domain.ExampleMatcher.GenericPropertyMatchers.exact;
import static org.springframework.data.domain.ExampleMatcher.GenericPropertyMatchers.startsWith;

@DataJpaTest
public class StudentRepositoryTest {

    @Autowired
    StudentRepository studentRepository;

    @BeforeEach
    public void setUp() {
        if(studentRepository.count() == 0) {
            studentRepository.saveAll(InitialData.getSampleStudents());
        }
    }

    @Test
    public void testFindByName() {

        // Example query to find students named "John Doe"
        Student exampleStudent = new Student(null, "John Doe", null, null);
        Example<Student> example = Example.of(exampleStudent);

        // assert
        List<Student> result = studentRepository.findAll(example);
        assertEquals(1, result.size());
        assertEquals("John Doe", result.get(0).getName());
    }

    @Test
    public void testFindByEmailContaining() {

        // Example query to find students with emails containing
        Student exampleStudent = new Student(null, null, "gmail", null);
        ExampleMatcher matcher = ExampleMatcher.matching()
                .withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING);
        Example<Student> example = Example.of(exampleStudent, matcher);

        // assert
        List<Student> result = studentRepository.findAll(example);
        assertEquals(6, result.size());
    }

    @Test
    public void testFindByEmailPrefixAndAge() {

        // specifying behavior for individual properties, by default all matchers should match
        Student exampleStudent = new Student(null, "J", null, 25);
        ExampleMatcher matcher = ExampleMatcher.matching()
                .withMatcher("name", startsWith().ignoreCase())
                .withMatcher("age", exact());

        Example<Student> example = Example.of(exampleStudent, matcher);

        // assert
        List<Student> result = studentRepository.findAll(example);
        assertEquals(1, result.size());
    }

    @Test
    public void testFindAnyByEmailPrefixAndAge() {

        // specifying behavior for individual properties, search for any match
        Student exampleStudent = new Student(null, "J", null, 25);
        ExampleMatcher matcher = ExampleMatcher.matchingAny()
                .withMatcher("name", startsWith().ignoreCase())
                .withMatcher("age", exact());

        Example<Student> example = Example.of(exampleStudent, matcher);

        // assert
        List<Student> result = studentRepository.findAll(example);
        assertEquals(2, result.size());
    }

}
