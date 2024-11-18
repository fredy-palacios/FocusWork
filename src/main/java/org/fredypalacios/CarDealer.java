package org.fredypalacios;

import java.util.concurrent.Semaphore;

/**
 * It will represent the dealership.
 * This is where we will create the objects of the Car class,
 * and the semaphore will be created to allow only 4 people to use the cars at the same time.
 */
public class CarDealer {
    // Allowed only 4 people to access a car at the same time
    protected static final Semaphore carsAvailable = new Semaphore(4, true);
    // Created 4 car
    protected static final Car[] cars = {
            new Car(1, false),
            new Car(2, false),
            new Car(3, false),
            new Car(4, false)
    };
}