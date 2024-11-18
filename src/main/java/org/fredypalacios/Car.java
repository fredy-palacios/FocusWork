package org.fredypalacios;

/**
 * It will represent the cars that customers will use.
 * This class has 2 attributes: the ID to identify the car and a boolean to determine whether the car is occupied or not.
 * It will also be a monitor class.
 */
public class Car {

    private final int id;
    private boolean occupied;

    public Car(int id, boolean occupied) {
        this.id = id;
        this.occupied = occupied;
    }

    public synchronized boolean isOccupied() {
        return occupied;
    }

    public synchronized void setOccupied(boolean occupied) {
        this.occupied = occupied;
    }

    public int getId() {
        return id;
    }
}