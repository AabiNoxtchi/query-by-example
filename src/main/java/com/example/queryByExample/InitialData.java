package com.example.queryByExample;


import com.example.queryByExample.models.Student;
import com.example.queryByExample.repositories.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.util.List;


@Profile("!test")
@Component
@RequiredArgsConstructor
public class InitialData implements CommandLineRunner {

    private final StudentRepository studentRepository;

    @Override
    public void run(String... args) throws Exception {
        studentRepository.saveAll(InitialData.getSampleStudents());
    }

    public static List<Student> getSampleStudents() {
        return List.of(
                new Student(1L, "John Doe", "john.doe@gmail.com", 25),
                new Student(2L, "Jane Smith", "jane.smith@gmail.com", 30),
                new Student(3L, "Alice Johnson", "alice.johnson@example.com", 27),
                new Student(4L, "Bob Brown", "bob.brown@gmail.com", 22),
                new Student(5L, "Charlie Black", "charlie.black@example.com", 35),
                new Student(6L, "David White", "david.white@gmail.com", 28),
                new Student(7L, null, "emily.green@gmail.com", 24),
                new Student(8L, "Frank Blue", null, 31),
                new Student(9L, "Grace Yellow", "grace.yellow@gmail.com", 26),
                new Student(10L, "Hank Purple", "hank.purple@example.com", 29)
        );
    }
}
