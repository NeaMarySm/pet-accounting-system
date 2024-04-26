package view;

import model.*;

import java.time.LocalDate;
import java.util.UUID;

public class AnimalView extends View {
    public AnimalView() {
        super();
    }

    private String baseAnimalData(Animal animal) {
        return String.format("%s\tName: %s\tAge: %d\t%s\t", animal.getId(), animal.getName(), animal.getAge(), animal.getGender());
    }

    public void print(PackAnimal animal) {
        String type = "unknown";
        if (animal instanceof Camel) {
            type = "Camel";
        } else if (animal instanceof Horse) {
            type = "Horse";
        } else if (animal instanceof Donkey) {
            type = "Donkey";
        }
        String base = baseAnimalData(animal);
        String packSpecific = String.format("Owner: %s\tMax Load: %.2f\tPack Size: %d\n", animal.getOwner(), animal.getMaxLoad(), animal.getPackSize());
        System.out.print("Pack Animal - " + type + "\n" + base + packSpecific);
    }

    public void print(Pet animal) {
        String type = "unknown";
        if (animal instanceof Cat) {
            type = "Cat";
        } else if (animal instanceof Dog) {
            type = "Dog";
        } else if (animal instanceof Hamster) {
            type = "Hamster";
        }
        String base = baseAnimalData(animal);
        String petSpecific = String.format("Owner: %s", animal.getOwner());
        System.out.print("Pet - " + type + "\n" + base + petSpecific);
    }

    public void printShort(Pet animal) {
        String type = "unknown";
        if (animal instanceof Cat) {
            type = "Cat";
        } else if (animal instanceof Dog) {
            type = "Dog";
        } else if (animal instanceof Hamster) {
            type = "Hamster";
        }
        System.out.printf("%s\t%s\t%s\t%d\t%s\n", type, animal.getName(), animal.getOwner(), animal.getAge(), animal.getId());
    }

    public void printShort(PackAnimal animal) {
        String type = "unknown";
        if (animal instanceof Camel) {
            type = "Camel";
        } else if (animal instanceof Horse) {
            type = "Horse";
        } else if (animal instanceof Donkey) {
            type = "Donkey";
        }
        System.out.printf("");
        System.out.printf("%s\t%s\t%s\t%d\t%s\n", type, animal.getName(), animal.getOwner(), animal.getAge(), animal.getId());
    }

    public AnimalList getType() {
        System.out.println("Choose animal to add: ");
        for (AnimalList el : AnimalList.values()) {
            System.out.printf("%s\t", el);
        }
        System.out.println("\n");
        String input = in.nextLine();
        AnimalList animal = null;
        while (true) {
            switch (input.toLowerCase()) {
                case "camel":
                    animal = AnimalList.CAMEL;
                    break;
                case "donkey":
                    animal = AnimalList.DONKEY;
                    break;
                case "horse":
                    animal = AnimalList.HORSE;
                    break;
                case "cat":
                    animal = AnimalList.CAT;
                    break;
                case "dog":
                    animal = AnimalList.DOG;
                    break;
                case "hamster":
                    animal = AnimalList.HAMSTER;
                    break;
                default:
                    System.out.println("Invalid input");
                    break;
            }
            return animal;
        }
    }

    public String getName() {
        System.out.println("Animal Name: ");
        return in.nextLine();
    }

    public String getOwner() {
        System.out.println("Owner Name: ");
        return in.nextLine();
    }

    public String getBreed() {
        System.out.println("Breed: ");
        return in.nextLine();
    }

    public Gender getGender() {
        System.out.println("Choose gender:\t1 - Male\t2 - Female\t3 - Unknown");
        int input = in.nextInt();
        in.nextLine();
        Gender gender = Gender.UNKNOWN;
        switch (input) {
            case 1:
                gender = Gender.MALE;
                break;
            case 2:
                gender = Gender.FEMALE;
                break;
            default:
                break;
        }
        return gender;
    }

    public Double getMaxLoad() {
        System.out.println("MaxLoad: ");
        return in.nextDouble();
    }

    public Integer getPackSize() {
        System.out.println("PackSize: ");
        return in.nextInt();
    }

    public LocalDate getBirthDate() {
        System.out.println("Birth date");
        System.out.println("Enter day: ");
        int day = in.nextInt();
        System.out.println("Enter month: ");
        int month = in.nextInt();
        System.out.println("Enter year: ");
        int year = in.nextInt();
        in.nextLine();
        return LocalDate.of(year, month, day);
    }


    public Integer getHumpCount() {
        System.out.println("Number of humps: ");
        return in.nextInt();
    }

    public String getColor() {
        System.out.println("Color: ");
        return in.nextLine();
    }

    public UUID getAnimalID() {
        System.out.println("Enter animal id:");
        String input = in.nextLine();
        UUID selectedId = null;
        try {
            selectedId = UUID.fromString(input);
        } catch (IllegalArgumentException e) {
            System.out.println("Invalid id format. Please enter a valid id.");
        }
        return selectedId;
    }

    public String getCommand() {
        System.out.println("New command: ");
        return in.nextLine();
    }
}