package model;

import java.util.Date;
import java.util.UUID;

enum Gender {
    MALE,
    FEMALE,
    UNKNOWN
}

public abstract class Animal {
    protected UUID id;
    protected String name;
    protected Date birthDate;
    protected Gender gender;
    public Animal( String name, Date birthDate, Gender gender) {
        this.id = UUID.randomUUID();
        this.name = name;
        this.birthDate = birthDate;
        this.gender = gender;
    }
    public Animal(UUID id, String name, Date birthDate, Gender gender) {
        this.id = id;
        this.name = name;
        this.birthDate = birthDate;
        this.gender = gender;
    }
    public Animal( String name, Date birthDate) {
        this.id = UUID.randomUUID();
        this.name = name;
        this.birthDate = birthDate;
        this.gender = Gender.UNKNOWN;
    }
    public UUID getId() {
        return id;
    }
    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }


    public abstract void makeSound();

    public abstract void eat(String food);

    public abstract void sleep();
}

