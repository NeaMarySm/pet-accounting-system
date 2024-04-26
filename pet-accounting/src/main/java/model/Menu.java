package model;

import java.util.ArrayList;
import java.util.List;

public class Menu {
    private ArrayList<String> mainMenu = new ArrayList<>(List.of("1 - AddAnimal", "2 - ShowAnimals","3 - ShowAnimalCommands", "4 - TrainAnimal", "0 - Exit"));
    private ArrayList<String> subShow = new ArrayList<>(List.of("1 - All", "2 - Pets", "3 - PackAnimals", "0 - Return"));

    public ArrayList<String> getMainMenu() {
        return mainMenu;
    }

    public void setMainMenu(ArrayList<String> mainMenu) {
        this.mainMenu = mainMenu;
    }

    public ArrayList<String> getSubShow() {
        return subShow;
    }

    public void setSubShow(ArrayList<String> subShow) {
        this.subShow = subShow;
    }


    public void print(ArrayList<String> commands) {
        commands.forEach(el -> System.out.printf("%s\t", el));
    }

}