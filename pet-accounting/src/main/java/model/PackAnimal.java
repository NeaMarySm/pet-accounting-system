package model;

import java.time.LocalDate;
import java.util.Arrays;

public abstract class PackAnimal extends Animal {
    protected String owner;
    protected Double maxLoad;
    protected Integer packSize;

    public PackAnimal(String name, LocalDate birthDate, Gender gender, String owner, Double maxLoad, Integer packSize) {
        super(name, birthDate, gender);
        this.owner = owner;
        this.maxLoad = maxLoad;
        this.packSize = packSize;
        this.commands.addAll(Arrays.asList("LeadPack","CarryLoad"));
    }

    public String getOwner() {
        return this.owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public Double getMaxLoad() {
        return this.maxLoad;
    }

    public void setMaxLoad(Double maxLoad) {
        this.maxLoad = maxLoad;
    }

    public Integer getPackSize() {
        return packSize;
    }

    public void setPackSize(Integer packSize) {
        this.packSize = packSize;
    }

    public abstract void leadPack();

    public abstract void carryLoad(double weight);
}
