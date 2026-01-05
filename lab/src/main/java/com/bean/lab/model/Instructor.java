package com.bean.lab.model;

import com.bean.lab.interfaces.Teacher;
import com.bean.lab.interfaces.Learner;

public class Instructor extends Person implements Teacher {

    public Instructor(long id, String name) {
        super(id, name);
    }

    @Override
    public void teach(Learner learner, double numberOfHours) {
        learner.learn(numberOfHours);
    }

    @Override
    public void lecture(Iterable<? extends Learner> learners, double numberOfHours) {
        int count = 0;
        for (Learner l : learners) count++;
        double hoursPerLearner = numberOfHours / count;
        for (Learner l : learners) {
            l.learn(hoursPerLearner);
        }
    }
}
