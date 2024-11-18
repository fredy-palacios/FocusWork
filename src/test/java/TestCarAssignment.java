import org.fredypalacios.Car;
import org.fredypalacios.Customer;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class TestCarAssignment {

    /**
     *This test verifies that a car is correctly released after a customer uses it.
     *This test creates a car, assigns a customer, and runs the customer's thread. Once the execution is finished,
     * it is expected that the car will be free (occupation = false).
     */
    @Test
    void testCustomerCarRelease() throws InterruptedException {
        Car testCar = new Car(1, false);
        Customer customer = new Customer("Fredy");

        customer.start(); // Start the customer thread, executing the run() method
        customer.join();  // Wait for the customer thread to finish before continuing

        assertFalse(testCar.isOccupied(),
                "El coche debería estar libre después de que el cliente termine"
        );
    }
}