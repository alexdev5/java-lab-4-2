package test;

import animal.*;
import cage.*;
import exception.AnimalNotFoundException;
import exception.CageFullException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CageTest {

    @Test
    void addAnimal_success() {
        LionCage cage = new LionCage(2);
        cage.addAnimal(new Lion("Simba"));

        assertEquals(1, cage.getOccupiedCount());
    }

    @Test
    void addAnimal_cageFull_exception() {
        LionCage cage = new LionCage(1);
        cage.addAnimal(new Lion("Simba"));

        assertThrows(CageFullException.class,
                () -> cage.addAnimal(new Lion("Mufasa")));
    }

    @Test
    void removeAnimal_success() {
        BirdCage<Eagle> cage = new BirdCage<>(2);
        Eagle eagle = new Eagle("Sky");

        cage.addAnimal(eagle);
        cage.removeAnimal(eagle);

        assertEquals(0, cage.getOccupiedCount());
    }

    @Test
    void removeAnimal_notFound_exception() {
        HoofedCage cage = new HoofedCage(2);

        assertThrows(AnimalNotFoundException.class,
                () -> cage.removeAnimal(new Zebra("Zed")));
    }

    @Test
    void hoofedCage_acceptsDifferentHoofedAnimals() {
        HoofedCage cage = new HoofedCage(3);

        cage.addAnimal(new Zebra("Zebra"));
        cage.addAnimal(new Giraffe("Giraffe"));

        assertEquals(2, cage.getOccupiedCount());
    }
}
