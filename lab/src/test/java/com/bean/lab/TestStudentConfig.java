package com.bean.lab;

import com.bean.lab.model.Students;
import com.bean.lab.config.StudentConfig;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(classes = StudentConfig.class)
public class TestStudentConfig {

    @Autowired
    @Qualifier("students")
    private Students currentStudents;

    @Autowired
    @Qualifier("previousStudents")
    private Students previousStudents;

    @Test
    public void testCurrentStudentsBean() {
        assertNotNull(currentStudents, "Current students bean should not be null");
        assertEquals(2, currentStudents.size(), "Current students size should be 2");
    }

    @Test
    public void testPreviousStudentsBean() {
        assertNotNull(previousStudents, "Previous students bean should not be null");
        assertEquals(2, previousStudents.size(), "Previous students size should be 2");
    }
}
