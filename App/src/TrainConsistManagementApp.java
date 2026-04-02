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

    passengerBogies.remove("AC Chair");

    System.out.println("\nPassenger Bogies:");
    System.out.println(passengerBogies);

    // =========================
    // UC3: Unique Bogie IDs
    // =========================
    Set<String> bogieIds = new HashSet<>();

    bogieIds.add("BG101");
    bogieIds.add("BG102");
    bogieIds.add("BG101"); // duplicate

    System.out.println("\nUnique Bogie IDs:");
    System.out.println(bogieIds);

    // =========================
    // UC4: LinkedList (Ordered)
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

    System.out.println("\nFinal Train Consist:");
    System.out.println(consist);

    // =========================
    // UC5: LinkedHashSet
    // =========================
    Set<String> formation = new LinkedHashSet<>();

    formation.add("Engine");
    formation.add("Sleeper");
    formation.add("Cargo");
    formation.add("Guard");
    formation.add("Sleeper"); // duplicate ignored

    System.out.println("\nTrain Formation:");
    System.out.println(formation);

    // =========================
    // UC6: HashMap (Bogie → Capacity)
    // =========================
    Map<String, Integer> bogieCapacity = new HashMap<>();

    // Add capacities
    bogieCapacity.put("Sleeper", 72);
    bogieCapacity.put("AC Chair", 60);
    bogieCapacity.put("First Class", 40);

    System.out.println("\nBogie Capacity Details:");

    // Iterate using entrySet
    for (Map.Entry<String, Integer> entry : bogieCapacity.entrySet()) {
      System.out.println(entry.getKey() + " → Capacity: " + entry.getValue());
    }
  }
}
