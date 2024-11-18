package org.fredypalacios;

/**
 * It will represent the customers.
 * It will have a single parameter, which will be the person's name.
 * This will inherit from the Thread class.
 * The run() method is overridden, and within this method, thread management is handled.
 */
public class Customer extends Thread{
    private final String name;

    public Customer(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        Car assignedCar = null;
        try {
            CarDealer.carsAvailable.acquire(); // Try to get a car (permission)
            synchronized (CarDealer.cars) { // Search a car available
                for (Car car : CarDealer.cars) {
                    if (!car.isOccupied()) {
                        car.setOccupied(true);
                        assignedCar = car; // Assigns the car to the customer
                        System.out.println(name + " está probando el vehiculo numero " + car.getId());
                        break;
                    }
                }
            }
            Thread.sleep((long) (Math.random() * 6000) + 1000); // simulates runtime
            assert assignedCar != null;

            synchronized (CarDealer.cars) {
                assignedCar.setOccupied(false); // Release the car
            }
            System.out.println(name + " ha terminado de probar el vehiculo " + assignedCar.getId());

        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        } finally {
            CarDealer.carsAvailable.release(); // Release the permit
        }
    }
}