package com.bean.lab;

import com.bean.lab.model.Instructors;
import com.bean.lab.config.InstructorsConfig;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(classes = InstructorsConfig.class)
public class TestInstructorConfig {

    @Autowired
    private Instructors instructors;   // Primary bean

    @Autowired
    @Qualifier("tcUsaInstructors")
    private Instructors tcUsaInstructors;

    @Autowired
    @Qualifier("tcUkInstructors")
    private Instructors tcUkInstructors;

    @Test
    public void testTcUsaInstructors() {
        assertNotNull(tcUsaInstructors);
        assertEquals(2, tcUsaInstructors.size());
    }

    @Test
    public void testTcUkInstructors() {
        assertNotNull(tcUkInstructors);
        assertEquals(2, tcUkInstructors.size());
    }

    @Test
    public void testPrimaryInstructors() {
        assertNotNull(instructors);
        assertEquals(4, instructors.size());
    }
}
