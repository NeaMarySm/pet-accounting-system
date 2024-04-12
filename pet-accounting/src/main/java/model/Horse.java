package model;

import java.util.Date;
import java.util.UUID;

public class Horse extends PackAnimal {

    private String color;
    private String breed;

    public Horse(String name, Date birthDate, Gender gender, String owner, Double maxLoad, Integer packSize, String color, String breed) {
        super(name, birthDate, gender, owner, maxLoad, packSize);
        this.color = color;
        this.breed = breed;
    }

    public Horse(UUID id, String name, Date birthDate, Gender gender, String owner, Double maxLoad, Integer packSize, String color, String breed) {
        super(id, name, birthDate, gender, owner, maxLoad, packSize);
        this.color = color;
        this.breed = breed;
    }

    public Horse(String name, Date birthDate, String owner, Double maxLoad, Integer packSize, String color, String breed) {
        super(name, birthDate, owner, maxLoad, packSize);
        this.color = color;
        this.breed = breed;
    }

    public void pullCart(){

    }
    public void gallop(){

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
    public void leadPack() {

    }

    @Override
    public void carryLoad(double weight) {

    }
}