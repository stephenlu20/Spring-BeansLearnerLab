package com.bean.lab.config;

import com.bean.lab.model.Student;
import com.bean.lab.model.Students;

import java.util.ArrayList;
import java.util.Arrays;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class StudentConfig {

    @Bean(name = "students")
    public Students currentStudents() {
        return new Students( new ArrayList<>(
            Arrays.asList(
                new Student(1, "Alice"),
                new Student(2, "Bob")
            ))
        );
    }

    @Bean(name = "previousStudents")
    public Students previousStudents() {
        return new Students( new ArrayList<>(
            Arrays.asList(
                new Student(3, "Charlie"),
                new Student(4, "Diana")
            ))
        );
    }
}
