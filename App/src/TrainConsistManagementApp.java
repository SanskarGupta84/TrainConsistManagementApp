import java.util.ArrayList;
import java.util.List;

public class TrainConsistManagementApp {

  public static void main(String[] args) {

    // =========================
    // UC1: Initialize Train
    // =========================
    System.out.println("=== Train Consist Management App ===");

    List<String> trainConsist = new ArrayList<>();
    System.out.println("Initial Bogie Count: " + trainConsist.size());

    // =========================
    // UC2: Add Passenger Bogies
    // =========================

    // Create passenger bogie list
    List<String> passengerBogies = new ArrayList<>();

    // Add bogies
    passengerBogies.add("Sleeper");
    passengerBogies.add("AC Chair");
    passengerBogies.add("First Class");

    // Display after adding
    System.out.println("\nPassenger Bogies after addition:");
    System.out.println(passengerBogies);

    // Remove one bogie
    passengerBogies.remove("AC Chair");

    // Display after removal
    System.out.println("\nPassenger Bogies after removal:");
    System.out.println(passengerBogies);

    // Check existence
    boolean exists = passengerBogies.contains("Sleeper");

    System.out.println("\nIs Sleeper present? " + exists);

    // Final state
    System.out.println("\nFinal Passenger Bogie List:");
    System.out.println(passengerBogies);
  }
}
