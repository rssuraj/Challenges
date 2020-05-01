package com.geektrust.familytree.enums;

public enum GenderEnum {

    MALE("Male"),
    FEMALE("Female"),
    OTHER("Other");

    private String gender;

    private GenderEnum(String gender)
    {
        this.gender = gender;
    }

    public String getGender() {
        return gender;
    }
}