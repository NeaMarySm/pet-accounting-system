package model;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.UUID;

public abstract class Animal {
    protected UUID id;
    protected String name;
    protected LocalDate birthDate;
    protected Gender gender;
    protected ArrayList<String> commands = new ArrayList<>(Arrays.asList("Sleep", "Eat", "makeSound"));

    public Animal(String name, LocalDate birthDate, Gender gender) {
        this.id = UUID.randomUUID();
        this.name = name;
        this.birthDate = birthDate;
        this.gender = gender;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public Integer getAge() {
        return Period.between(this.birthDate, LocalDate.now()).getYears();
    }

    public ArrayList<String> getCommands() {
        return commands;
    }

    public void setCommands(ArrayList<String> commands) {
        this.commands = commands;
    }
    public void train(String command){
        this.commands.add(command);
    }
    public void showCommands(){
        System.out.println("Known commands:");
        for (String cmd:
             commands) {
            System.out.print(cmd + "\t");
        }
    }
    public abstract void makeSound();

    public abstract void eat(String food);

    public abstract void sleep();
}

