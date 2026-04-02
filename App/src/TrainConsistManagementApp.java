import java.util.*;

public class TrainConsistManagementApp {

  public static void main(String[] args) {

    // =========================
    // UC1: Initialize Train
    // =========================
    System.out.println("=== Train Consist Management App ===");

    List<String> trainConsist = new ArrayList<>();
    System.out.println("Initial Bogie Count: " + trainConsist.size());

    // =========================
    // UC2: Passenger Bogies
    // =========================
    List<String> passengerBogies = new ArrayList<>();

    passengerBogies.add("Sleeper");
    passengerBogies.add("AC Chair");
    passengerBogies.add("First Class");

    System.out.println("\nPassenger Bogies after addition:");
    System.out.println(passengerBogies);

    passengerBogies.remove("AC Chair");

    System.out.println("\nPassenger Bogies after removal:");
    System.out.println(passengerBogies);

    boolean exists = passengerBogies.contains("Sleeper");
    System.out.println("\nIs Sleeper present? " + exists);

    System.out.println("\nFinal Passenger Bogie List:");
    System.out.println(passengerBogies);

    // =========================
    // UC3: Unique Bogie IDs
    // =========================
    Set<String> bogieIds = new HashSet<>();

    // Add IDs (with duplicates)
    bogieIds.add("BG101");
    bogieIds.add("BG102");
    bogieIds.add("BG103");
    bogieIds.add("BG101"); // duplicate
    bogieIds.add("BG102"); // duplicate

    System.out.println("\nUnique Bogie IDs (duplicates removed automatically):");
    System.out.println(bogieIds);
  }
}
