import java.util.HashMap;
import java.util.Map;

/**
 * Version: 3.0
 * Description: Centralized Room Inventory Management.
 * This version replaces independent variables with a HashMap to manage state efficiently.
 */

// Domain Model (from previous use case)
abstract class Room {
    private String type;
    public Room(String type) { this.type = type; }
    public String getType() { return type; }
}

class SingleRoom extends Room { public SingleRoom() { super("Single"); } }
class DoubleRoom extends Room { public DoubleRoom() { super("Double"); } }
class SuiteRoom extends Room { public SuiteRoom() { super("Suite"); } }

// New Component: Centralized Inventory Manager
class RoomInventory {
    // HashMap provides O(1) average lookup and update time
    private Map<String, Integer> inventory;

    public RoomInventory() {
        this.inventory = new HashMap<>();
    }

    // Register room types and their initial counts
    public void initializeInventory(String type, int count) {
        inventory.put(type, count);
    }

    // Controlled access to availability
    public int getAvailability(String type) {
        return inventory.getOrDefault(type, 0);
    }

    // Method to simulate updates (e.g., after a booking)
    public void updateAvailability(String type, int newCount) {
        if (inventory.containsKey(type)) {
            inventory.put(type, newCount);
        }
    }

    public void displayCurrentInventory() {
        System.out.println("\n--- Current Inventory Status ---");
        for (Map.Entry<String, Integer> entry : inventory.entrySet()) {
            System.out.println("Room Type: " + entry.getKey() + " | Available: " + entry.getValue());
        }
    }
}

public class BookMyStayApp {
    public static void main(String[] args) {
        System.out.println("Initializing Hotel Booking System V3.0...");

        // 1. Setup Inventory
        RoomInventory hotelInventory = new RoomInventory();

        // 2. Register Room Types (The "Put" operation)
        hotelInventory.initializeInventory("Single", 10);
        hotelInventory.initializeInventory("Double", 7);
        hotelInventory.initializeInventory("Suite", 2);

        // 3. Display Initial State
        hotelInventory.displayCurrentInventory();

        // 4. Demonstrate a controlled update (Simulating a booking)
        System.out.println("\nAction: Booking one Single Room...");
        int currentSingle = hotelInventory.getAvailability("Single");
        hotelInventory.updateAvailability("Single", currentSingle - 1);

        // 5. Final State Check
        hotelInventory.displayCurrentInventory();

        System.out.println("\nInventory state remains consistent and centralized.");
    }
}