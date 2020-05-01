package com.geektrust.familytree.entities;

import com.geektrust.familytree.enums.GenderEnum;

public class Person {

    private String name;
    private GenderEnum gender;

    public Person(String name, GenderEnum gender) {
        this.name = name;
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public GenderEnum getGender() {
        return gender;
    }

    public boolean equalsName(String name) {
        if(this.name.equals(name))
            return true;
        return false;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Person)
        {
            Person objP = (Person) obj;
            return name.equals(objP.getName()) && gender.getGender().equals(objP.getGender().getGender());
        }
        return false;
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }
}