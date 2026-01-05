package com.bean.lab.model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public abstract class People<T extends Person> implements Iterable<T> {
    protected List<T> personList;

    public People(List<T> people) {
        this.personList = new ArrayList<>(people);
    }

    public void add(T person) { personList.add(person); }
    public void remove(T person) { personList.remove(person); }
    public int size() { return personList.size(); }
    public void clear() { personList.clear(); }

    public void addAll(Iterable<T> people) {
        for (T p : people) personList.add(p);
    }

    public T findById(long id) {
        return personList.stream().filter(p -> p.getId() == id).findFirst().orElse(null);
    }

    public List<T> findAll() { return personList; }

    @Override
    public Iterator<T> iterator() { return personList.iterator(); }
}
