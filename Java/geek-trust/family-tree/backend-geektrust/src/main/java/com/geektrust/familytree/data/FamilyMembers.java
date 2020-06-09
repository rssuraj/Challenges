package com.geektrust.familytree.data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.geektrust.familytree.constants.FamilyConstants;
import com.geektrust.familytree.entities.Couple;
import com.geektrust.familytree.entities.Person;
import com.geektrust.familytree.enums.GenderEnum;

public class FamilyMembers {
    private List<Couple> couples;
    private Map<String, Person> membersOfFamily;

    public FamilyMembers() {
        this.couples = new ArrayList<Couple>();
        this.membersOfFamily = new HashMap<String, Person>();
        
        Couple coupleHead = populateFamilyHead();
        populateChildCoupleData(coupleHead);
    }

    private Couple populateFamilyHead() {
        Person king = new Person(FamilyConstants.KING_NAME, GenderEnum.MALE);
        Person queen = new Person(FamilyConstants.QUEEN_NAME, GenderEnum.FEMALE);
        addMember(king);
        addMember(queen);
        Couple coupleHead = new Couple(king, queen);
        this.couples.add(coupleHead);

        coupleHead.getChildren().add(new Person(FamilyConstants.CHIT, GenderEnum.MALE));
        coupleHead.getChildren().add(new Person(FamilyConstants.ISH, GenderEnum.MALE));
        coupleHead.getChildren().add(new Person(FamilyConstants.VICH, GenderEnum.MALE));
        coupleHead.getChildren().add(new Person(FamilyConstants.ARAS, GenderEnum.MALE));
        coupleHead.getChildren().add(new Person(FamilyConstants.SATYA, GenderEnum.FEMALE));
        addMembers(coupleHead.getChildren());
        return coupleHead;
    }

    private void populateChildCoupleData(Couple couple) {
        for(Person person : couple.getChildren()) {
            Couple childCouple = null;
            if(person.equalsName(FamilyConstants.CHIT)) {
                childCouple = new Couple(person, new Person(FamilyConstants.AMBA, GenderEnum.FEMALE));
                addMember(childCouple.getWife());
                childCouple.getChildren().add(new Person(FamilyConstants.DRITHA, GenderEnum.FEMALE));
                childCouple.getChildren().add(new Person(FamilyConstants.TRITHA, GenderEnum.FEMALE));
                childCouple.getChildren().add(new Person(FamilyConstants.VRITHA, GenderEnum.MALE));
            }
            else if(person.equalsName(FamilyConstants.VICH)) {
                childCouple = new Couple(person, new Person(FamilyConstants.LIKA, GenderEnum.FEMALE));
                addMember(childCouple.getWife());
                childCouple.getChildren().add(new Person(FamilyConstants.VILA, GenderEnum.FEMALE));
                childCouple.getChildren().add(new Person(FamilyConstants.CHIKA, GenderEnum.FEMALE));
            }
            else if(person.equalsName(FamilyConstants.ARAS)) {
                childCouple = new Couple(person, new Person(FamilyConstants.CHITRA, GenderEnum.FEMALE));
                addMember(childCouple.getWife());
                childCouple.getChildren().add(new Person(FamilyConstants.AHIT, GenderEnum.MALE));
                childCouple.getChildren().add(new Person(FamilyConstants.JNKI, GenderEnum.FEMALE));
            }
            else if(person.equalsName(FamilyConstants.SATYA)) {
                childCouple = new Couple(new Person(FamilyConstants.VYAN, GenderEnum.MALE), person);
                addMember(childCouple.getHusband());
                childCouple.getChildren().add(new Person(FamilyConstants.ASVA, GenderEnum.MALE));
                childCouple.getChildren().add(new Person(FamilyConstants.VYAS, GenderEnum.MALE));
                childCouple.getChildren().add(new Person(FamilyConstants.ATYA, GenderEnum.FEMALE));
            }

            if(childCouple != null) {
                couples.add(childCouple);
                addMembers(childCouple.getChildren());
                createChildrenCouple(childCouple);
            }
        }
    }

    private void createChildrenCouple(Couple couple) {
        for(Person person : couple.getChildren()) {
            Couple childCouple = null;
            if(person.equalsName(FamilyConstants.DRITHA)) {
                childCouple = new Couple(new Person(FamilyConstants.JAYA, GenderEnum.MALE), person);
                addMember(childCouple.getHusband());
                childCouple.getChildren().add(new Person(FamilyConstants.YODHAN, GenderEnum.MALE));
            }
            else if(person.equalsName(FamilyConstants.JNKI)) {
                childCouple = new Couple(new Person(FamilyConstants.ARIT, GenderEnum.MALE), person);
                addMember(childCouple.getHusband());
                childCouple.getChildren().add(new Person(FamilyConstants.LAKI, GenderEnum.MALE));
                childCouple.getChildren().add(new Person(FamilyConstants.LAVNYA, GenderEnum.FEMALE));
            }
            else if(person.equalsName(FamilyConstants.VYAS)) {
                childCouple = new Couple(person, new Person(FamilyConstants.KRPI, GenderEnum.FEMALE));
                addMember(childCouple.getWife());
                childCouple.getChildren().add(new Person(FamilyConstants.KRIYA, GenderEnum.MALE));
                childCouple.getChildren().add(new Person(FamilyConstants.KRITHI, GenderEnum.FEMALE));
            }
            else if(person.equalsName(FamilyConstants.ASVA)) {
                childCouple = new Couple(person, new Person(FamilyConstants.SATVY, GenderEnum.FEMALE));
                addMember(childCouple.getWife());
                childCouple.getChildren().add(new Person(FamilyConstants.VASA, GenderEnum.MALE));
            }

            if(childCouple != null) {
                couples.add(childCouple);
                addMembers(childCouple.getChildren());
            }
        }
    }

    private void addMember(Person person) {
        if(person != null)
            this.membersOfFamily.put(person.getName(), person);
    }

    private void addMembers(List<Person> persons) {
        if(persons != null && persons.size() > 0) {
            for(Person person : persons) {
                this.membersOfFamily.put(person.getName(), person);
            }
        }
    }

    public List<Couple> getCouples() {
        return couples;
    }

    public Map<String, Person> getMembersOfFamily() {
        return membersOfFamily;
    }    
}