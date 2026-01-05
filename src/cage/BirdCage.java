package cage;

import animal.Bird;

public class BirdCage<T extends Bird> extends Cage<T> {

    public BirdCage(int capacity) {
        super(capacity);
    }
}
