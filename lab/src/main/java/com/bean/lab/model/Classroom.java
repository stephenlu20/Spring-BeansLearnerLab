package com.bean.lab.model;

import com.bean.lab.interfaces.Teacher;

public class Classroom {
    private final Instructors instructors;
    private final Students students;

    public Classroom(Instructors instructors, Students students) {
        this.instructors = instructors;
        this.students = students;
    }

    public void hostLecture(Teacher teacher, double numberOfHours) {
        teacher.lecture(students, numberOfHours);
    }

    public Instructors getInstructors() { return instructors; }
    public Students getStudents() { return students; }
}