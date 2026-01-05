package com.bean.lab.config;

import com.bean.lab.model.Instructor;
import com.bean.lab.model.Instructors;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.beans.factory.annotation.Qualifier;

@Configuration
public class InstructorsConfig {

    @Bean("tcUsaInstructors")
    public Instructors tcUsaInstructors() {
        return new Instructors(
                new Instructor(1, "John"),
                new Instructor(2, "Jane")
        );
    }

    @Bean("tcUkInstructors")
    public Instructors tcUkInstructors() {
        return new Instructors(
                new Instructor(3, "Peter"),
                new Instructor(4, "Mary")
        );
    }

    @Bean
    @Primary
    public Instructors instructors(
            @Qualifier("tcUsaInstructors") Instructors usa,
            @Qualifier("tcUkInstructors") Instructors uk
    ) {
        Instructors all = new Instructors();
        all.addAll(usa);
        all.addAll(uk);
        return all;
    }
}
