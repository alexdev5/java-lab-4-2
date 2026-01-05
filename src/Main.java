import animal.*;
import cage.*;
import storage.ZooStorage;
import zoo.Zoo;

public class Main {

    public static void main(String[] args) {

        // Створюємо зоопарк
        Zoo zoo = new Zoo();

        // Створюємо вольєри
        LionCage lionCage = new LionCage(2);
        HoofedCage hoofedCage = new HoofedCage(3);
        BirdCage<Eagle> birdCage = new BirdCage<>(2);

        // Додаємо тварин
        lionCage.addAnimal(new Lion("Simba"));
        lionCage.addAnimal(new Lion("Mufasa"));

        hoofedCage.addAnimal(new Zebra("Zed"));
        hoofedCage.addAnimal(new Giraffe("Gerry"));

        birdCage.addAnimal(new Eagle("Sky"));

        // Додаємо вольєри в зоопарк
        zoo.addCage(lionCage);
        zoo.addCage(hoofedCage);
        zoo.addCage(birdCage);

        System.out.println("=== Zoo state ===");
        System.out.println("Lions in cage: " + lionCage.getOccupiedCount());
        System.out.println("Hoofed animals in cage: " + hoofedCage.getOccupiedCount());
        System.out.println("Birds in cage: " + birdCage.getOccupiedCount());

        System.out.println("Total animals in zoo: " + zoo.getCountOfAnimals());

        // Збереження у файл
        ZooStorage.save(zoo, "zoo.dat");
        System.out.println("\nZoo saved to file.");

        // Завантаження з файлу
        Zoo loadedZoo = ZooStorage.load("zoo.dat");
        System.out.println("Zoo loaded from file.");
        System.out.println("Total animals after loading: " + loadedZoo.getCountOfAnimals());
    }
}
