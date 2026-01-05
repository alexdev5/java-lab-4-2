package zoo;

import cage.Cage;
import animal.Animal;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Zoo implements Serializable {

    private List<Cage<? extends Animal>> cages = new ArrayList<>();

    public void addCage(Cage<? extends Animal> cage) {
        cages.add(cage);
    }

    public int getCountOfAnimals() {
        int total = 0;
        for (Cage<? extends Animal> cage : cages) {
            total += cage.getOccupiedCount();
        }
        return total;
    }

    public List<Cage<? extends Animal>> getCages() {
        return cages;
    }
}
