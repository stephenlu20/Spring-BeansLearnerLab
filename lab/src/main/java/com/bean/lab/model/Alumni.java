package com.bean.lab.model;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Alumni {

    @Autowired
    private Students previousStudents;

    @Autowired
    private Instructors instructors;

    @PostConstruct
    public void executeBootcamp() {
        double totalHours = 1200;
        int numStudents = previousStudents.size();
        int numInstructors = instructors.size();
        double hoursPerInstructor = (totalHours * numStudents) / numInstructors;

        for (Instructor inst : instructors) {
            inst.lecture(previousStudents, hoursPerInstructor);
        }
    }

    public Students getPreviousStudents() { return previousStudents; }
    public Instructors getInstructors() { return instructors; }
}
