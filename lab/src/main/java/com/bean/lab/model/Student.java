package com.bean.lab.model;

import com.bean.lab.interfaces.Learner;

public class Student extends Person implements Learner {
    private double totalStudyTime = 0;

    public Student(long id, String name) {
        super(id, name);
    }

    @Override
    public void learn(double numberOfHours) {
        this.totalStudyTime += numberOfHours;
    }

    public double getTotalStudyTime() { return totalStudyTime; }
}
