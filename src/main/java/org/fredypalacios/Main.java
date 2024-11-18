package org.fredypalacios;

/**
 * This is the main class.
 * From here, we run the program.
 */
public class Main {
    public static void main(String[] args) {
        // Create 9 threads
        new Customer("Angie").start();
        new Customer("Beatriz").start();
        new Customer("Cedric").start();
        new Customer("Daniel").start();
        new Customer("Elias").start();
        new Customer("Fredy") .start();
        new Customer("Gabriela").start();
        new Customer("Helena").start();
        new Customer("Isabela").start();
    }
}