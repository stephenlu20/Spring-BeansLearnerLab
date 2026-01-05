package com.bean.lab.model;

public class Students extends People<Student> {
    @SafeVarargs
    public Students(Student... students) {
        super(students);
    }
}
