package model;

import java.util.Date;
import java.util.UUID;

public class Dog extends Pet {
    private String breed;

    public Dog(String name, Date birthDate, Gender gender, String owner, String breed) {
        super(name, birthDate, gender, owner);
        this.breed = breed;
    }

    public Dog(UUID id, String name, Date birthDate, Gender gender, String owner, String breed) {
        super(id, name, birthDate, gender, owner);
        this.breed = breed;
    }

    public Dog(String name, Date birthDate, String owner, String breed) {
        super(name, birthDate, owner);
        this.breed = breed;
    }

    @Override
    public void makeSound() {

    }

    @Override
    public void eat(String food) {

    }

    @Override
    public void sleep() {

    }

    @Override
    public void play() {

    }

    @Override
    public void fetch() {

    }
}


