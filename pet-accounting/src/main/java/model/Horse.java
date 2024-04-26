package model;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Date;
import java.util.UUID;

public class Horse extends PackAnimal {

    private String color;
    private String breed;

    public Horse(String name, LocalDate birthDate, Gender gender, String owner, Double maxLoad, Integer packSize, String color, String breed) {
        super(name, birthDate, gender, owner, maxLoad, packSize);
        this.color = color;
        this.breed = breed;
        commands.addAll(Arrays.asList("PullCart", "Gallop"));
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