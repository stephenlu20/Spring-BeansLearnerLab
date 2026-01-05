package com.bean.lab;

import com.bean.lab.model.Alumni;
import com.bean.lab.model.Student;
import com.bean.lab.model.Students;
import com.bean.lab.model.Instructors;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class TestAlumni {

    @Autowired
    private Alumni alumni;

    @Test
    public void testBootcampHoursDistributed() {
        Students students = alumni.getPreviousStudents();
        Instructors instructors = alumni.getInstructors();

        assertNotNull(students);
        assertNotNull(instructors);

        for (Student s : students) {
            assertEquals(1200.0, s.getTotalStudyTime(), 0.001,
                    "Each student should receive exactly 1200 hours");
        }

        int numberOfStudents = students.size();
        int numberOfInstructors = instructors.size();

        double expectedPerInstructor =
                (1200.0 * numberOfStudents) / numberOfInstructors;

        var instructorIterator = instructors.iterator();
        while (instructorIterator.hasNext()) {
            instructorIterator.next();

            double totalTaught = 0;

            var studentIterator = students.iterator();
            while (studentIterator.hasNext()) {
                studentIterator.next();
                totalTaught += 1200.0 / numberOfInstructors;
            }

            assertEquals(expectedPerInstructor, totalTaught, 0.001,
                    "Each instructor should teach the same total hours");
        }
    }
}
