package com.geektrust.familytree.family;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.geektrust.familytree.constants.FamilyConstants;
import com.geektrust.familytree.data.FamilyMembers;
import com.geektrust.familytree.entities.Couple;
import com.geektrust.familytree.entities.Person;
import com.geektrust.familytree.enums.GenderEnum;

public class Family {
    
    private FamilyMembers data;

    public Family() {
        data = new FamilyMembers();
    }

    public String getRelationship(final String name, final String relationship) {
        List<String> result = null;

        switch(relationship) {
            case FamilyConstants.PATERNAL_UNCLE :
            {
                result = getPaternalUncles(name);
                break;
            }
            case FamilyConstants.MATERNAL_UNCLE :
            {
                result = getMaternalUncles(name);
                break;
            }
            case FamilyConstants.PATERNAL_AUNT :
            {
                result = getPaternalAunts(name);
                break;
            }
            case FamilyConstants.MATERNAL_AUNT :
            {
                result = getMaternalAunts(name);
                break;
            }
            case FamilyConstants.SISTER_IN_LAW :
            {
                result = getSisterInLaws(name);
                break;
            }
            case FamilyConstants.BROTHER_IN_LAW :
            {
                result = getBrotherInLaws(name);
                break;
            }
            case FamilyConstants.SON :
            {
                result = getSons(name);
                break;
            }
            case FamilyConstants.DAUGHTER :
            {
                result = getDaughters(name);
                break;
            }
            case FamilyConstants.SIBLINGS :
            {
                result = getSiblings(name);
                break;
            }
            default :
            {
                return relationship + " Relationship Not Supported!!";
            }
        }

        return getResultAsString(result);
    }

    private List<String> getPaternalUncles(String name) {
        return getUnclesOrAunts(name, GenderEnum.MALE.getGender(), true);
    }

    private List<String> getMaternalUncles(String name) {
        return getUnclesOrAunts(name, GenderEnum.MALE.getGender(), false);
    }

    private List<String> getPaternalAunts(String name) {
        return getUnclesOrAunts(name, GenderEnum.FEMALE.getGender(), true);
    }

    private List<String> getMaternalAunts(String name) {
        return getUnclesOrAunts(name, GenderEnum.FEMALE.getGender(), false);
    }

    private List<String> getSisterInLaws(String name) {
        return getSiblingInLaws(name, GenderEnum.MALE.getGender(), GenderEnum.FEMALE.getGender());
    }

    private List<String> getBrotherInLaws(String name) {
        return getSiblingInLaws(name, GenderEnum.FEMALE.getGender(), GenderEnum.MALE.getGender());
    }

    private List<String> getSons(String name) {
        return getChildrenPerGender(name, GenderEnum.MALE.getGender());
    }

    private List<String> getDaughters(String name) {
        return getChildrenPerGender(name, GenderEnum.FEMALE.getGender());
    }

    private List<String> getSiblings(String name) {
        List<String> result = new ArrayList<String>();

        Person person  = getPerson(name);
        if(person == null) {
            result.add("PERSON_NOT_FOUND");
            return result;
        }

        Couple couple = getCoupleContainingChild(person);
        if(couple != null) {
            result.addAll(couple.getChildren().stream().map(Person::getName).collect(Collectors.toList()));
        }

        result.remove(person.getName());

        return result;
    }

    private List<String> getUnclesOrAunts(String name, String gender, boolean paternal) {
        List<String> result = new ArrayList<String>();

        Person person  = getPerson(name);
        if(person == null) {
            result.add("PERSON_NOT_FOUND");
            return result;
        }

        Couple parents = getCoupleContainingChild(person);
        if(parents == null) {
            result.add("PARENTS_NOT_FOUND");
            return result;
        }
        
        String parentName = paternal ? parents.getHusband().getName() : parents.getWife().getName();
        Person parent = data.getMembersOfFamily().get(parentName);
        Couple grandParents = getCoupleContainingChild(parent);
        if(grandParents == null) {
            result.add("GRAND_PARENTS_NOT_FOUND");
            return result;
        }
        
        for(Person uncleOrAunt : grandParents.getChildren()) {
            if(!uncleOrAunt.getName().equals(parentName) 
                && uncleOrAunt.getGender().getGender().equals(gender)) {
                    result.add(uncleOrAunt.getName());
                }
        }

        return result;
    }

    private List<String> getSiblingInLaws(String name, String ownSibSpouseGender, String spouseSibSpouseGender) {
        List<String> result  = new ArrayList<String>();
        
        Person person  = getPerson(name);
        if(person == null) {
            result.add("PERSON_NOT_FOUND");
            return result;
        }

        Couple parents = getCoupleContainingChild(person);
        if(parents != null) {
            for(Person child : parents.getChildren()) {
                if(!child.equals(person) && child.getGender().getGender().equals(ownSibSpouseGender)) {
                    Person siblingSpouse = getSpouse(child);
                    if(siblingSpouse != null)
                        result.add(siblingSpouse.getName());
                }
            }
        }

        Person spouse = getSpouse(person);
        if(spouse == null) {
            return result;
        }

        Couple spouseParents = getCoupleContainingChild(spouse);
        if(spouseParents != null) {
            for(Person child : spouseParents.getChildren()) {
                if(!child.equals(spouse) && child.getGender().getGender().equals(spouseSibSpouseGender)) {
                    result.add(child.getName());
                }
            }
        }

        return result;
    }

    private List<String> getChildrenPerGender(String name, String gender) {
        List<String> result = new ArrayList<String>();

        Person person  = getPerson(name);
        if(person == null) {
            result.add("PERSON_NOT_FOUND");
            return result;
        }

        List<Person> children = getChildren(person);
        if(children != null) {
            for(Person child : children) {
                if(child.getGender().getGender().equals(gender))
                    result.add(child.getName());
            }
        }

        return result;
    }

    private Couple getCoupleContainingChild(Person person) {
        for(Couple couple : data.getCouples()) {
            if(couple.getChildren().contains(person)) {
                return couple;
            }
        }
        return null;
    }

    private Person getSpouse(Person person) {
        for(Couple couple : data.getCouples()) {
            if(couple.getHusband().equals(person)) {
                return couple.getWife();
            }

            if(couple.getWife().equals(person)) {
                return couple.getHusband();
            }
        }
        return null;
    }

    private List<Person> getChildren(Person person) {
        for(Couple couple : data.getCouples()) {
            if(couple.getHusband().equals(person) || couple.getWife().equals(person))
                return couple.getChildren();
        }
        return null;
    }

    public String addChild(final String motherName, final String childName, final String gender) {
        Person mother = getPerson(motherName);
        if(mother == null) {
            return "PERSON_NOT_FOUND";
        }

        Couple parents = getCoupleObject(mother);
        if(parents == null) {
            return "CHILD_ADDITION_FAILED";
        }

        GenderEnum genderEnum = gender.equals(GenderEnum.MALE.getGender()) ? GenderEnum.MALE : (gender.equals(GenderEnum.FEMALE.getGender()) ? GenderEnum.FEMALE : GenderEnum.OTHER);
        Person child = new Person(childName, genderEnum);
        parents.getChildren().add(child);
        data.getMembersOfFamily().put(childName, child);
        return "CHILD_ADDITION_SUCCEEDED";
    }

    private Couple getCoupleObject(Person mother) {
        for(Couple couple : data.getCouples()) {
            if(couple.getWife().equals(mother))
                return couple;
        }
        return null;
    }

    private Person getPerson(String name) {
        Person person = data.getMembersOfFamily().get(name);
        if(person == null) {
            return null;
        }
        return person;
    }

    private String getResultAsString(List<String> names) {
        if(names.size() == 0) {
            return "NONE";
        }
        StringBuilder result = new StringBuilder();
        for(String name : names) {
            result.append(name).append(" ");
        }
        return result.toString();
    }
}