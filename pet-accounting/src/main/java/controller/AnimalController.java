package controller;

import model.*;
import view.AnimalView;

import java.time.LocalDate;
import java.util.UUID;

public class AnimalController {
    Storage<PackAnimal> packAnimalStorage;
    Storage<Pet> petStorage;
    AnimalView animalView;

    public AnimalController(Storage<PackAnimal> packAnimalStorage, Storage<Pet> petStorage) {
        this.packAnimalStorage = packAnimalStorage;
        this.petStorage = petStorage;
        this.animalView = new AnimalView();
    }

    public void createAnimal() {
        AnimalList animal = animalView.getType();
        if (animal == AnimalList.CAT || animal == AnimalList.DOG || animal == AnimalList.HAMSTER) {
            createPet(animal);
        } else if (animal == AnimalList.CAMEL || animal == AnimalList.DONKEY || animal == AnimalList.HORSE) {
            createPackAnimal(animal);
        } else {
            System.out.println("Unavailable type");
        }
    }

    public void createPet(AnimalList type) {
        String name = animalView.getName();
        String breed = animalView.getBreed();
        LocalDate birthDate = animalView.getBirthDate();
        Gender gender = animalView.getGender();
        String owner = animalView.getOwner();
        if (type == AnimalList.CAT) {
            petStorage.add(new Cat(name, birthDate, gender, owner, breed));
        } else if (type == AnimalList.DOG) {
            petStorage.add(new Dog(name, birthDate, gender, owner, breed));
        } else {
            petStorage.add(new Hamster(name, birthDate, gender, owner, breed));
        }

    }

    public void createPackAnimal(AnimalList type) {
        String name = animalView.getName();
        LocalDate birthDate = animalView.getBirthDate();
        Gender gender = animalView.getGender();
        String owner = animalView.getOwner();
        Double maxLoad = animalView.getMaxLoad();
        Integer packSize = animalView.getPackSize();
        if (type == AnimalList.CAMEL) {
            Integer humpCount = animalView.getHumpCount();
            packAnimalStorage.add(new Camel(name, birthDate, gender, owner, maxLoad, packSize, humpCount));
        } else if (type == AnimalList.DONKEY) {
            String color = animalView.getColor();
            packAnimalStorage.add(new Donkey(name, birthDate, gender, owner, maxLoad, packSize, color));

        } else {
            String color = animalView.getColor();
            String breed = animalView.getBreed();
            packAnimalStorage.add(new Horse(name, birthDate, gender, owner, maxLoad, packSize, color, breed));
        }
    }

    public void printAll() {
        printPets();
        printPackAnimals();
    }
    public void printPets(){
        if (petStorage.size() > 0) {
            System.out.println("Pets");
            System.out.println("№\tType\tName\tOwner\tAge\tID");
            for (int i = 0; i < petStorage.size(); i++) {
                System.out.printf("%d\t", (i + 1));
                animalView.printShort(petStorage.getAnimals().get(i));
            }
        }
    }
    public void printPackAnimals(){
        if (packAnimalStorage.size() > 0) {
            System.out.println("Pack Animals");
            System.out.println("№\tType\tName\tOwner\tAge\tID");
            for (int i = 0; i < packAnimalStorage.size(); i++) {
                System.out.printf("%d\t", (i + 1));
                animalView.printShort(packAnimalStorage.getAnimals().get(i));
            }
        }
    }

    public void removeAnimal(Animal animal){
        if(animal instanceof PackAnimal){
            packAnimalStorage.remove((PackAnimal) animal);
            System.out.println("Removed successfully");
            return;
        }
        if(animal instanceof Pet){
            petStorage.remove((Pet) animal);
            System.out.println("Removed successfully");
            return;
        }
        System.out.println("Can`t find such animal");
    }
    public Animal find(UUID id){
        if(packAnimalStorage.inStore(id)){
           return packAnimalStorage.get(id);
        }
        if (petStorage.inStore(id)){
            return petStorage.get(id);
        }
        return null;
    }
    public void trainAnimal(){
        UUID id = animalView.getAnimalID();
        Animal selectedAnimal = find(id);
        String command = animalView.getCommand();
        selectedAnimal.train(command);
        System.out.println("Successfully trained!");
        selectedAnimal.showCommands();
    }
    public void showAnimalCommands(){
        UUID id = animalView.getAnimalID();
        Animal selectedAnimal = find(id);
        if(selectedAnimal != null){
        selectedAnimal.showCommands();}
    }

}
