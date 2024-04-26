package model;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Date;
import java.util.UUID;

public class Camel extends PackAnimal {

    private Integer humpCount;

    public Camel(String name, LocalDate birthDate, Gender gender, String owner, Double maxLoad, Integer packSize, Integer humpCount) {
        super(name, birthDate, gender, owner, maxLoad, packSize);
        this.humpCount = humpCount;
    }

    public void travelInDesert(){

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
