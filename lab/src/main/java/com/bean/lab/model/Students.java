package com.bean.lab.model;

import java.util.List;

public class Students extends People<Student> {
    public Students(List<Student> students) {
        super(students);
    }
}
