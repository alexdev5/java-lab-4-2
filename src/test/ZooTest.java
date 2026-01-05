package test;

import animal.*;
import cage.*;
import org.junit.jupiter.api.Test;
import zoo.Zoo;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ZooTest {

    @Test
    void countAnimalsInZoo() {
        Zoo zoo = new Zoo();

        LionCage lionCage = new LionCage(2);
        lionCage.addAnimal(new Lion("Simba"));

        BirdCage<Eagle> birdCage = new BirdCage<>(3);
        birdCage.addAnimal(new Eagle("Sky"));
        birdCage.addAnimal(new Eagle("Wind"));

        zoo.addCage(lionCage);
        zoo.addCage(birdCage);

        assertEquals(3, zoo.getCountOfAnimals());
    }
}
