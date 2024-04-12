package model;

import java.util.Date;
import java.util.UUID;

public abstract class PackAnimal extends Animal {
    protected String owner;
    protected Double maxLoad;
    protected Integer packSize;

    public PackAnimal(String name, Date birthDate, Gender gender, String owner, Double maxLoad, Integer packSize) {
        super(name, birthDate, gender);
        this.owner = owner;
        this.maxLoad = maxLoad;
        this.packSize = packSize;
    }

    public PackAnimal(UUID id, String name, Date birthDate, Gender gender, String owner, Double maxLoad, Integer packSize) {
        super(id, name, birthDate, gender);
        this.owner = owner;
        this.maxLoad = maxLoad;
        this.packSize = packSize;
    }

    public PackAnimal(String name, Date birthDate, String owner, Double maxLoad, Integer packSize) {
        super(name, birthDate);
        this.owner = owner;
        this.maxLoad = maxLoad;
        this.packSize = packSize;
    }

    public abstract void leadPack();

    public abstract void carryLoad(double weight);
}
