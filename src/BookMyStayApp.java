
/**
 * Version: 2.0
 * Description: Introduction to Object Modeling through Inheritance and Abstraction.
 * This version focuses on domain design using abstract classes and concrete specializations.
 */

// Abstract Class: Represents the generalized concept of a Room
abstract class Room {
    private String type;
    private int beds;
    private double price;

    public Room(String type, int beds, double price) {
        this.type = type;
        this.beds = beds;
        this.price = price;
    }

    // Encapsulation: Accessing properties through defined behavior
    public void displayInfo() {
        System.out.println("Room Type: " + type + " | Beds: " + beds + " | Rate: $" + price);
    }
}

// Inheritance: Concrete classes extending the abstract Room
class SingleRoom extends Room {
    public SingleRoom() {
        super("Single Room", 1, 100.0);
    }
}

class DoubleRoom extends Room {
    public DoubleRoom() {
        super("Double Room", 2, 180.0);
    }
}

class SuiteRoom extends Room {
    public SuiteRoom() {
        super("Executive Suite", 3, 350.0);
    }
}

public class BookMyStayApp {
    public static void main(String[] args) {
        System.out.println("--- Hotel System Version 2.0: Room Initialization ---");

        // Polymorphism: Referencing concrete objects using the abstract Room type
        Room single = new SingleRoom();
        Room doubled = new DoubleRoom();
        Room suite = new SuiteRoom();

        // Static Availability Representation:
        // Using simple variables to highlight limitations for future inventory lessons
        int singleAvailability = 5;
        int doubleAvailability = 3;
        int suiteAvailability = 1;

        // Displaying Room Details and State
        single.displayInfo();
        System.out.println("Current Availability: " + singleAvailability);
        System.out.println("-------------------------------------------");

        doubled.displayInfo();
        System.out.println("Current Availability: " + doubleAvailability);
        System.out.println("-------------------------------------------");

        suite.displayInfo();
        System.out.println("Current Availability: " + suiteAvailability);
        System.out.println("-------------------------------------------");

        System.out.println("Application Execution Completed.");
    }
}