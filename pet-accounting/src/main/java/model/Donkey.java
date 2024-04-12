package model;

import java.util.Date;
import java.util.UUID;

public class Donkey extends PackAnimal {

    private String color;

    public Donkey(String name, Date birthDate, Gender gender, String owner, Double maxLoad, Integer packSize, String color) {
        super(name, birthDate, gender, owner, maxLoad, packSize);
        this.color = color;
    }

    public Donkey(UUID id, String name, Date birthDate, Gender gender, String owner, Double maxLoad, Integer packSize, String color) {
        super(id, name, birthDate, gender, owner, maxLoad, packSize);
        this.color = color;
    }

    public Donkey(String name, Date birthDate, String owner, Double maxLoad, Integer packSize, String color) {
        super(name, birthDate, owner, maxLoad, packSize);
        this.color = color;
    }

    public void transportGoods(){

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