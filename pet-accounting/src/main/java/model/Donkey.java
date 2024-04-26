package model;

import java.time.LocalDate;
import java.util.UUID;

public class Donkey extends PackAnimal {

    private String color;

    public Donkey(String name, LocalDate birthDate, Gender gender, String owner, Double maxLoad, Integer packSize, String color) {
        super(name, birthDate, gender, owner, maxLoad, packSize);
        this.color = color;
        commands.add("TransportGoods");
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