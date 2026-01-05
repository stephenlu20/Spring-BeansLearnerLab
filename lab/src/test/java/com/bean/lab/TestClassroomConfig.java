package com.bean.lab;

import com.bean.lab.model.Classroom;
import com.bean.lab.config.ClassroomConfig;
import com.bean.lab.model.Students;
import com.bean.lab.model.Instructors;
import com.bean.lab.config.InstructorsConfig;
import com.bean.lab.config.StudentConfig;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(classes = {ClassroomConfig.class, StudentConfig.class, InstructorsConfig.class})
public class TestClassroomConfig {

    @Autowired
    @Qualifier("currentCohort")
    private Classroom currentCohort;

    @Autowired
    @Qualifier("previousCohort")
    private Classroom previousCohort;

    @Test
    public void testCurrentCohort() {
        assertNotNull(currentCohort);
        Students students = currentCohort.getStudents();
        Instructors instructors = currentCohort.getInstructors();
        assertEquals(2, students.size());
        assertEquals(4, instructors.size());
    }

    @Test
    public void testPreviousCohort() {
        assertNotNull(previousCohort);
        Students students = previousCohort.getStudents();
        Instructors instructors = previousCohort.getInstructors();
        assertEquals(2, students.size());
        assertEquals(4, instructors.size());
    }
}
