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

    bogieIds.add("BG101");
    bogieIds.add("BG102");
    bogieIds.add("BG103");
    bogieIds.add("BG101"); // duplicate

    System.out.println("\nUnique Bogie IDs:");
    System.out.println(bogieIds);

    // =========================
    // UC4: Ordered Train Consist
    // =========================
    LinkedList<String> consist = new LinkedList<>();

    // Add bogies
    consist.add("Engine");
    consist.add("Sleeper");
    consist.add("AC");
    consist.add("Cargo");
    consist.add("Guard");

    System.out.println("\nInitial Train Consist:");
    System.out.println(consist);

    // Insert Pantry Car at position 2
    consist.add(2, "Pantry");

    System.out.println("\nAfter adding Pantry at position 2:");
    System.out.println(consist);

    // Remove first and last
    consist.removeFirst();
    consist.removeLast();

    System.out.println("\nFinal Train Consist:");
    System.out.println(consist);
  }
}
