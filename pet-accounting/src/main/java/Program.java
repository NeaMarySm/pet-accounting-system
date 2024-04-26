import controller.AnimalController;
import model.Menu;
import model.PackAnimal;
import model.Pet;
import model.Storage;
import view.MenuView;

public class Program {
    private MenuView menu;
    private Storage<PackAnimal> packAnimalStorage;
    private Storage<Pet> petStorage;
    private AnimalController animalController;

    public Program() {
        this.menu = new MenuView(new Menu());
        this.packAnimalStorage = new Storage<>("PackAnimals");
        this.petStorage = new Storage<>("Pets");
        this.animalController = new AnimalController(packAnimalStorage, petStorage);
    }

    public MenuView getMenu() {
        return menu;
    }

    public void setMenu(MenuView menu) {
        this.menu = menu;
    }

    public Storage<PackAnimal> getPackAnimalStorage() {
        return packAnimalStorage;
    }

    public void setPackAnimalStorage(Storage<PackAnimal> packAnimalStorage) {
        this.packAnimalStorage = packAnimalStorage;
    }

    public Storage<Pet> getPetStorage() {
        return petStorage;
    }

    public void setPetStorage(Storage<Pet> petStorage) {
        this.petStorage = petStorage;
    }

    public void run(){
        boolean inProgress = true;
        while (inProgress) {
            System.out.println("\nPet accounting system");
            int input = menu.getMainMenuChoice();
            switch (input) {
                case 1:
                    animalController.createAnimal();
                    break;
                case 2:
                    input = menu.getShowChoice();
                    switch (input) {
                        case 1:
                            animalController.printAll();
                            break;
                        case 2:
                            animalController.printPets();
                            break;
                        case 3:
                            animalController.printPackAnimals();
                            break;
                        case 0:
                            break;
                        default:
                            System.out.println("Invalid command.");
                    }
                    break;
                case 3:
                    animalController.showAnimalCommands();
                    break;
                case 4:
                    animalController.trainAnimal();
                    break;
                case 0:
                    inProgress = false;
                    break;
                default:
                    System.out.println("Invalid command.");
            }
        }
    }
}
