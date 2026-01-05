package com.bean.lab.config;

import com.bean.lab.model.Classroom;
import com.bean.lab.model.Instructors;
import com.bean.lab.model.Students;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;

@Configuration
public class ClassroomConfig {

    @Bean(name = "currentCohort")
    @DependsOn({"instructors", "students"})
    public Classroom currentCohort(Instructors instructors, @Qualifier("students") Students students) {
        return new Classroom(instructors, students);
    }

    @Bean(name = "previousCohort")
    @DependsOn({"instructors", "previousStudents"})
    public Classroom previousCohort(Instructors instructors, @Qualifier("previousStudents") Students previousStudents) {
        return new Classroom(instructors, previousStudents);
    }
}
