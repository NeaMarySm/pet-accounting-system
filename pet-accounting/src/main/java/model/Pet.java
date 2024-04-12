package model;

import java.util.Date;
import java.util.UUID;

public abstract class Pet extends Animal{
    protected String owner;
    public Pet(String name, Date birthDate, Gender gender, String owner) {
        super(name, birthDate, gender);
        this.owner = owner;
    }

    public Pet(UUID id, String name, Date birthDate, Gender gender,String owner) {
        super(id, name, birthDate, gender);
        this.owner = owner;
    }

    public Pet(String name, Date birthDate, String owner) {
        super(name, birthDate);
        this.owner = owner;
    }
    public abstract void play();

    public abstract void fetch();
}
