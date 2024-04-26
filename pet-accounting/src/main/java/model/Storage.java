package model;

import java.util.ArrayList;
import java.util.UUID;

public class Storage<T extends Animal> {
    private ArrayList<T> animals = new ArrayList<>();
    private String name;

    public Storage(String name) {
        this.name = name;
    }

    public ArrayList<T> getAnimals() {
        return animals;
    }

    public void setTasks(ArrayList<T> animals) {
        this.animals = animals;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean add(T animal) {
        return animals.add(animal);
    }

    public boolean remove(T animal) {
        return animals.remove(animal);
    }

    public boolean addList(ArrayList<T> animalList) {
        return animals.addAll(animalList);
    }

    public int size() {
        return animals.size();
    }

    public T get(UUID id) {
        for (T t : animals) {
            if (t.getId().equals(id)) {
                return t;
            }
        }
        System.out.println("Animal not found");
        return null;
    }
    public boolean inStore(UUID id){
        for (T t : animals) {
            if (t.getId().equals(id)) {
                return true;
            }
        }
        return false;
    }
    @Override
    public String toString() {
        return name;
    }
}