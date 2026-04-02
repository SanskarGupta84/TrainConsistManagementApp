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

    System.out.println("\nIs Sleeper present? " + passengerBogies.contains("Sleeper"));
    System.out.println("Final Passenger Bogie List:");
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

    consist.add("Engine");
    consist.add("Sleeper");
    consist.add("AC");
    consist.add("Cargo");
    consist.add("Guard");

    consist.add(2, "Pantry");
    consist.removeFirst();
    consist.removeLast();

    System.out.println("\nFinal Train Consist (LinkedList):");
    System.out.println(consist);

    // =========================
    // UC5: LinkedHashSet (Ordered + Unique)
    // =========================
    Set<String> formation = new LinkedHashSet<>();

    // Add bogies
    formation.add("Engine");
    formation.add("Sleeper");
    formation.add("Cargo");
    formation.add("Guard");

    // Add duplicate
    formation.add("Sleeper"); // ignored automatically

    System.out.println("\nTrain Formation using LinkedHashSet:");
    System.out.println(formation);
  }
}
