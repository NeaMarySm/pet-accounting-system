package model;

import java.time.LocalDate;
import java.util.Arrays;

public abstract class Pet extends Animal{
    protected String owner;
    public Pet(String name, LocalDate birthDate, Gender gender, String owner) {
        super(name, birthDate, gender);
        this.owner = owner;
        commands.addAll(Arrays.asList("Play", "Fetch"));
    }


    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public abstract void play();

    public abstract void fetch();
}
