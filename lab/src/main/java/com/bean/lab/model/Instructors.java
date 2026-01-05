package com.bean.lab.model;

import java.util.List;
import java.util.ArrayList;

public class Instructors extends People<Instructor> {

    public Instructors() {
        super(new ArrayList<Instructor>());
    }

    public Instructors(List<Instructor> instructors) {
        super(instructors);
    }
}
