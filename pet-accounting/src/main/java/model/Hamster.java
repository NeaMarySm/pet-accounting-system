package model;

import java.time.LocalDate;
import java.util.UUID;

public class Hamster extends Pet{
    private String breed;

    public Hamster(String name, LocalDate birthDate, Gender gender, String owner, String breed) {
        super(name, birthDate, gender, owner);
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

