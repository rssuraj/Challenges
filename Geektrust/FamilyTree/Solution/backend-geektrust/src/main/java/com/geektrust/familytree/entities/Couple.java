package com.geektrust.familytree.entities;

import java.util.ArrayList;
import java.util.List;

public class Couple {
    private Person husband;
    private Person wife;
    private List<Person> children;

    public Couple(Person husband, Person wife) {
        this.husband = husband;
        this.wife = wife;
        children = new ArrayList<Person>();
    }

    public Person getHusband() {
        return husband;
    }

    public Person getWife() {
        return wife;
    }

    public List<Person> getChildren() {
        return children;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Couple) {
            Couple objC = (Couple) obj;
            if(husband.equals(objC.getHusband()) && wife.equals(objC.getWife()))
                return true;
        }
        return false;
    }

    @Override
    public int hashCode() {
        return husband.hashCode() * wife.hashCode();
    }
}