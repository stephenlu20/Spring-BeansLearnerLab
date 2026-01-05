package com.bean.lab.config;

import com.bean.lab.model.Instructor;
import com.bean.lab.model.Instructors;

import java.util.ArrayList;
import java.util.Arrays;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class InstructorsConfig {

    @Bean
    public Instructors tcUsaInstructors() {
        return new Instructors(new ArrayList<>(
                Arrays.asList(
                    new Instructor(1, "John"),
                    new Instructor(2, "Jane")           
            ))
        );
    }

    @Bean
    public Instructors tcUkInstructors() {
        return new Instructors(new ArrayList<>(
                Arrays.asList(
                    new Instructor(3, "Peter"),
                    new Instructor(4, "Mary")
            ))
        );
    }

    @Bean
    @Primary
    public Instructors instructors() {
        Instructors all = new Instructors();
        all.addAll(tcUsaInstructors());
        all.addAll(tcUkInstructors());
        return all;
    }
}
