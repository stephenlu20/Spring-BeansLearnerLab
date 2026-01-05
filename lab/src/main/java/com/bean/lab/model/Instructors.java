package com.bean.lab.model;

public class Instructors extends People<Instructor> {
    @SafeVarargs
    public Instructors(Instructor... instructors) {
        super(instructors);
    }
}