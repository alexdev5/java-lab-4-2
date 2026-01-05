package cage;

import animal.Animal;
import exception.AnimalNotFoundException;
import exception.CageFullException;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public abstract class Cage<T extends Animal> implements Serializable {

    private int capacity;
    protected List<T> animals = new ArrayList<>();

    public Cage(int capacity) {
        this.capacity = capacity;
    }

    public int getCapacity() {
        return capacity;
    }

    public int getOccupiedCount() {
        return animals.size();
    }

    public void addAnimal(T animal) {
        if (animals.size() >= capacity) {
            throw new CageFullException("Cage is full");
        }
        animals.add(animal);
    }

    public void removeAnimal(T animal) {
        if (!animals.remove(animal)) {
            throw new AnimalNotFoundException("Animal not found in cage");
        }
    }

    public List<T> getAnimals() {
        return animals;
    }
}
