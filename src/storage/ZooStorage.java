package storage;

import zoo.Zoo;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.IOException;

public class ZooStorage {

    public static void save(Zoo zoo, String fileName) {
        try (ObjectOutputStream out =
                     new ObjectOutputStream(new FileOutputStream(fileName))) {
            out.writeObject(zoo);
        } catch (IOException e) {
            throw new RuntimeException("Failed to save zoo to file", e);
        }
    }

    public static Zoo load(String fileName) {
        try (ObjectInputStream in =
                     new ObjectInputStream(new FileInputStream(fileName))) {
            return (Zoo) in.readObject();
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException("Failed to load zoo from file", e);
        }
    }
}
